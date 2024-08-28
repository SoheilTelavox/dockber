package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private final CatFactService catFactService;

    public DemoController(CatFactService catFactService) {
        this.catFactService = catFactService;
    }

    @GetMapping("/facts")
    public String facts() {
        return catFactService.getFacts();
    }
}