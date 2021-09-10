package com.catalogointerno.Projeto.Catalogo.controller;

import com.catalogointerno.Projeto.Catalogo.model.UserLogin;
import com.catalogointerno.Projeto.Catalogo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {


//        String newToken = token.substring(7, token.length());
//        Claims claims2 = null;
//        try {
//            claims2 = Jwts.parser()
//                    .setSigningKey(signingKey.getBytes(Charset.forName("UTF-8")))
//                    .parseClaimsJws(newToken)
//                    .getBody();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        final List<GrantedAuthority> authorities =
//                Arrays.stream(claims2.get("authorities").toString().split(","))
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//        for (GrantedAuthority grantedAuthority : authorities) {
//            System.out.println(grantedAuthority.getAuthority());
//        }
//
        return null;
    }
}







