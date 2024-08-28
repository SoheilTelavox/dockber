package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalBridgeService {

    @Autowired
    private RestTemplate restTemplate;

    public String getFacts() {
        String url = "http://?????/facts";
        return restTemplate.getForObject(url, String.class);
    }

    public String getHomeDocs() {
        String url = "http://localhost:8082/api/external/calls/doc";
        return restTemplate.getForObject(url, String.class);
    }
}