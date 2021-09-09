package com.catalogointerno.Projeto.Catalogo.controller;

import com.catalogointerno.Projeto.Catalogo.Json.Product;
import com.catalogointerno.Projeto.Catalogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {

    @Autowired
    UserService userService;

//    @GetMapping("/organizationName")
//    public Product getByName(@PathVariable String name, @RequestParam(required = false) String tags) {
//        return userService.findByName.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
//    }
}