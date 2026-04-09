package com.umaxcode.reactive_stock_price_dashboard.service;

import com.umaxcode.reactive_stock_price_dashboard.dto.GlobalQuote;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class StockPriceService {

    @Value("${price.stock.apiKey}")
    private String apiKey;

    private final StockApiService stockApiService;

    public Observable<List<GlobalQuote>> getStockQuote(String symbol) {
        return stockApiService.getStockQuote(symbol, apiKey);
    }

    public Observable<List<GlobalQuote>> getStockQuoteUpdate(String symbol) {

        return Observable.interval(1, TimeUnit.SECONDS)
                .flatMap(i -> getStockQuote(symbol))
                .subscribeOn(Schedulers.io());
    }
}
