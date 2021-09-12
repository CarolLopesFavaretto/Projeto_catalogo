package com.catalogointerno.Projeto.Catalogo.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LeituraProducts {

    public static void main(String[] args) {
        String file = "products.txt";
        try (Stream<String> stream = Files.lines(Paths.get("products.txt"))) {
            stream.forEach(System.out::println);
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
