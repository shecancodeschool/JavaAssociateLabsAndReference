package com.umaxcode.reactive_stock_price_dashboard.config;

import com.umaxcode.reactive_stock_price_dashboard.service.StockApiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {

    @Value("${price.stock.baseUrl}")
    String apiBaseUrl;

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(apiBaseUrl) // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    @Bean
    public StockApiService stockApiService(Retrofit retrofit) {
        return retrofit.create(StockApiService.class);
    }

    @Bean
    public ExecutorService executorService(){
        return Executors.newSingleThreadExecutor();
    }
}
