package com.umaxcode.reactive_stock_price_dashboard.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umaxcode.reactive_stock_price_dashboard.dto.GlobalQuote;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

@Service
@Slf4j
@RequiredArgsConstructor
public class WebSocketService extends TextWebSocketHandler {

    private final StockPriceService stockPriceService;
    private final ExecutorService executorService;
    private final ConcurrentMap<String, Disposable> subscriptions = new ConcurrentHashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        // Send initial stock price
        executorService.execute(() -> {
            try {
                String tickerSymbol = Objects.requireNonNull(session.getUri()).getQuery();
                if (tickerSymbol != null) {
//                    GlobalQuote stockQuote = stockPriceService.getStockQuote(tickerSymbol);
//                    String s = objectMapper.writeValueAsString(stockQuote);
//                    session.sendMessage(new TextMessage(s));
                }
            } catch (Exception e) {
                log.error("Error sending initial price", e);
                closeSessionSilently(session);
            }
        });
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String tickerSymbol = message.getPayload().trim().toUpperCase();

        // Validate ticker symbol
        if (!isValidTicker(tickerSymbol)) {
            session.sendMessage(new TextMessage("ERROR: Invalid ticker symbol"));
            return;
        }

        // Unsubscribe previous subscription if exists
        String sessionId = session.getId();
        if (subscriptions.containsKey(sessionId)) {
            subscriptions.get(sessionId).dispose();
            subscriptions.remove(sessionId);
        }

        // Store the ticker symbol in session attributes
        session.getAttributes().put("tickerSymbol", tickerSymbol);

        // Subscribe to updates
        try {
            Disposable subscription = stockPriceService.getStockQuoteUpdate(tickerSymbol)
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                            quote -> {
                                try {
                                    if (session.isOpen()) {
                                        System.out.println(quote);
                                        session.sendMessage(new TextMessage(formatStockMessage(quote.get(0))));
                                    }
                                } catch (IOException e) {
                                    log.error("Error sending update", e);
                                    closeSessionSilently(session);
                                }
                            },
                            error -> {
                                log.error("Subscription error", error);
                                try {
                                    session.sendMessage(new TextMessage(objectMapper.writeValueAsString(error)));
                                    closeSessionSilently(session);
                                } catch (IOException e) {
                                    log.error("Error sending error message", e);
                                }
                            }
                    );

            subscriptions.put(sessionId, subscription);
        } catch (Exception e) {
            log.error("Error creating subscription", e);
            closeSessionSilently(session);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // Clean up subscription when connection closes
        String sessionId = session.getId();
        if (subscriptions.containsKey(sessionId)) {
            subscriptions.get(sessionId).dispose();
            subscriptions.remove(sessionId);
        }
    }

    private String formatStockMessage(GlobalQuote quote) {
        return String.format("%s: %s (Change)",
                quote.getAskPrice(),
                quote.getBidPrice());
    }

    private boolean isValidTicker(String ticker) {
        return ticker != null && !ticker.isEmpty() && ticker.matches("[A-Z]+");
    }

    private void closeSessionSilently(WebSocketSession session) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("Error closing session", e);
        }
    }
}