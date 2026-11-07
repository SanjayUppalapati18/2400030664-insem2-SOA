package com.soa.microservice;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeploymentController {

    @GetMapping("/")
    public String home() {
        return "SOA Microservice Deployed Successfully!";
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "UP", "service", "soa-microservice");
    }

    @GetMapping("/api/message")
    public Map<String, String> message() {
        return Map.of("message", "Cloud deployment verified successfully");
    }
}
