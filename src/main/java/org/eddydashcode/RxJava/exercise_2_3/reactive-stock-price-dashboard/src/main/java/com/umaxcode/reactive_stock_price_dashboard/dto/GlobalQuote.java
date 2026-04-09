package com.umaxcode.reactive_stock_price_dashboard.dto;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GlobalQuote {

    @SerializedName("symbol")
    private String symbol;

    @SerializedName("bidPrice")
    private Double bidPrice;

    @SerializedName("bidSize")
    private Integer bidSize;

    @SerializedName("askPrice")
    private Double askPrice;

    @SerializedName("askSize")
    private Integer askSize;

    @SerializedName("lastSalePrice")
    private Double lastSalePrice;

    @SerializedName("lastSaleSize")
    private Integer lastSaleSize;

    @SerializedName("lastSaleTime")
    private Long lastSaleTime; // Unix timestamp in milliseconds

    @SerializedName("fmpLast")
    private Double fmpLast;

    @SerializedName("lastUpdated")
    private Long lastUpdated; // Unix timestamp in milliseconds

    @SerializedName("volume")
    private Integer volume;
}
