package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@RestController
public class DemoController {

    private final ExternalBridgeService bridgeService;
    private final FactRepository factRepository;

    public DemoController(ExternalBridgeService bridgeService, FactRepository factRepository) {
        this.bridgeService = bridgeService;
        this.factRepository = factRepository;
    }

    @GetMapping("/facts")
    public List<FactObject> facts() {
        return bridgeService.getFacts().getData();
    }

    @GetMapping("/favorites")
    @ResponseBody Iterable<Fact> getFavorites() {
        return factRepository.findAll();
    }

    @PostMapping("/favorites")
    @ResponseBody Fact saveFavorites(@RequestBody String body) {
        var fact = new Fact();
        fact.setFact(body);
        return factRepository.save(fact);
    }
}