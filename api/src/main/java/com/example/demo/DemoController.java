package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final ExternalBridgeService bridgeService;

    public DemoController(ExternalBridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }

    @GetMapping("/facts")
    public String facts() {
        return bridgeService.getFacts();
    }

    @GetMapping("/home")
    public String home() {
        return bridgeService.getHomeDocs();
    }
}