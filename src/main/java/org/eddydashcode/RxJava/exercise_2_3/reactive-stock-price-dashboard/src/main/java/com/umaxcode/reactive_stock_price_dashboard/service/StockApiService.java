package com.umaxcode.reactive_stock_price_dashboard.service;

import com.umaxcode.reactive_stock_price_dashboard.dto.GlobalQuote;
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import java.util.List;

public interface StockApiService {

    @GET("{symbol}")
    Observable<List<GlobalQuote>> getStockQuote(@Path("symbol") String symbol,
                                                @Query("apikey") String apiKey);
}
