package com.umaxcode.service_one.controller;

import com.umaxcode.service_one.dto.response.ServiceOneResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/service-one")
public class ServiceOneController {

    @GetMapping
    public ResponseEntity<ServiceOneResponse> sayHello() {

        return ResponseEntity.ok(
                ServiceOneResponse.builder()
                        .message("Hello from service one")
                        .build()
        );
    }
}
