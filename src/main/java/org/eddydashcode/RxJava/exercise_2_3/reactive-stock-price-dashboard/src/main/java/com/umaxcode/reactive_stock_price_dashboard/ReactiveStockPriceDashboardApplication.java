package com.umaxcode.reactive_stock_price_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveStockPriceDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveStockPriceDashboardApplication.class, args);

        String apiBaseUrl = "https://financialmodelingprep.com/api/v3/stock/full/real-time-price/";
        String tickerSymbol = "AAPL";


    }
}
