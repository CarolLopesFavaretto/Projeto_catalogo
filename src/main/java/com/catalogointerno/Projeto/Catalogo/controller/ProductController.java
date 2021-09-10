package com.catalogointerno.Projeto.Catalogo.controller;

import com.catalogointerno.Projeto.Catalogo.Json.Product;
import com.catalogointerno.Projeto.Catalogo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{organizationName}")
    public Product getByName(@PathVariable String organizationName, @RequestParam(required = false) String tags) {


        System.out.println(organizationName); // verificando funcionamento de endpoint

        return null;
    }
}