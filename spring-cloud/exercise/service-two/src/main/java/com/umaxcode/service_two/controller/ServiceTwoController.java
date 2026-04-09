package com.umaxcode.service_two.controller;

import com.umaxcode.service_two.dto.ServiceTwoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/service-two")
public class ServiceTwoController {

    @GetMapping
    public ResponseEntity<ServiceTwoResponse> sayHello() {

        return ResponseEntity.ok(ServiceTwoResponse.builder()
                .message("Hello from service two")
                .build());
    }

}
