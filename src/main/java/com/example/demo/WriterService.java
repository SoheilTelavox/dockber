package com.example.demo;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

@Service
public class WriterService {

    @Value("${NAMES_PATH:output.txt}")
    private final String filePath;

    public WriterService() {
        this.filePath = "names/names.txt";
    }

    public void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromFile() {
        List<String> names = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                names.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
}
