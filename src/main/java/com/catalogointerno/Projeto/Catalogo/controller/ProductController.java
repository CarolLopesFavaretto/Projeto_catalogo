package com.catalogointerno.Projeto.Catalogo.controller;

import com.catalogointerno.Projeto.Catalogo.model.Product;
import com.catalogointerno.Projeto.Catalogo.model.ReturnProducts;
import com.catalogointerno.Projeto.Catalogo.service.ProductService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{organizationName}")
    public ReturnProducts getByName(@PathVariable String organizationName, @RequestParam(required = false) String tags) {



        return productService.consultaProducts(organizationName, tags);
    }
}