package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactService {

    @Autowired
    private RestTemplate restTemplate;

    public String getFacts() {
        return getFacts(1);
    }

    public String getFacts(int number) {
        String url = "https://catfact.ninja/facts?page=" + number;
        return restTemplate.getForObject(url, String.class);
    }
}