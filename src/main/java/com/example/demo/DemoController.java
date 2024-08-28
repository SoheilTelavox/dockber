package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    private final WriterService fileWriteService;

    public DemoController(WriterService fileWriteService) {
        this.fileWriteService = fileWriteService;
    }

    @GetMapping("/write/{name}")
    public String writeFile(@PathVariable String name) {
        fileWriteService.writeToFile(name);
        return "Content written to file.";
    }

	@GetMapping("/namess")
    public List<String> getAllNames() {
        return fileWriteService.readFromFile();
    }
}