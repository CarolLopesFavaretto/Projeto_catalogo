package com.catalogointerno.Projeto.Catalogo.controller;

import com.catalogointerno.Projeto.Catalogo.model.ReturnProducts;
import com.catalogointerno.Projeto.Catalogo.service.ProductService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${security.jwt.signing-key}")
    private String signingKey;

    @GetMapping("/{organizationName}")
    public ReturnProducts getByName(@PathVariable String organizationName, @RequestParam(required = false) String tags, @RequestHeader("Authorization") String token) {

        String newToken = token.substring(7, token.length());
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(signingKey.getBytes(Charset.forName("UTF-8")))
                    .parseClaimsJws(newToken)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }

        final List<GrantedAuthority> authorities =
                Arrays.stream(claims.get("authorities").toString().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());


        return productService.consultaProducts(organizationName, tags, authorities );
    }
}