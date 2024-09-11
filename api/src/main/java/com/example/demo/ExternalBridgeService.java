package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalBridgeService {

    @Autowired
    private RestTemplate restTemplate;

    public FactExternal getFacts() {
        String url = "http://fact-service/facts";
        return restTemplate.getForObject(url, FactExternal.class);
    }
}