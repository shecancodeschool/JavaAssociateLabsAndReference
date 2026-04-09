package com.umaxcode.cloud_gateway.fallback;

import com.umaxcode.cloud_gateway.dto.FallbackResponse;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public ResponseEntity<FallbackResponse> fallback(ServerWebExchange exchange) {

        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);
        String serviceId = route != null ? route.getId() : "unknown service";
        return ResponseEntity.status(503)
                .body(new FallbackResponse("{" + serviceId + "} Service is unavailable. Please try again later"));
    }
}
