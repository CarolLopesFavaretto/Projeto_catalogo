package com.catalogointerno.Projeto.Catalogo.controller;

import com.catalogointerno.Projeto.Catalogo.model.UserLogin;
import com.catalogointerno.Projeto.Catalogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    @Autowired
    UserService userService;

//    @PostMapping ("/logar")
//    public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
//        return userService.logar(user).map(resp -> ResponseEntity.ok(resp))
//                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
//    }

}




