package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RestController
public class DemoController {

    private final ExternalBridgeService bridgeService;
    private final FactRepository factRepository;

    public DemoController(ExternalBridgeService bridgeService, FactRepository factRepository) {
        this.bridgeService = bridgeService;
        this.factRepository = factRepository;
    }

    @GetMapping("/facts")
    public List<String> facts(@RequestParam(defaultValue = "1") Integer page) {
        return bridgeService.getFacts(page)
            .getData()
            .stream()
            .map( f -> f.getFact())
            .collect(Collectors.toList());
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

    @DeleteMapping("/favorites/{id}")
    @ResponseBody void deleteFavorites(@PathVariable Integer id) {
        factRepository.deleteById(id);
    }
}