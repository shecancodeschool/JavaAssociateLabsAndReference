package com.umaxcode.reactive_stock_price_dashboard.dto;

import org.springframework.web.socket.WebSocketMessage;

public final class MyWebsocketMessage implements WebSocketMessage<GlobalQuote> {
    private final GlobalQuote globalQuote;

    public MyWebsocketMessage(GlobalQuote globalQuote) {
        this.globalQuote = globalQuote;
    }

    @Override
    public GlobalQuote getPayload() {
        return this.globalQuote;
    }

    @Override
    public int getPayloadLength() {
        return this.globalQuote.getAskSize();
    }

    @Override
    public boolean isLast() {
        return false;
    }
}
