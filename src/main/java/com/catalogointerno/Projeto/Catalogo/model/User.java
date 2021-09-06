package com.catalogointerno.Projeto.Catalogo.model;

import lombok.Data;

@Data
public class User {

    private String UserId;
    private String email;
    private String password;
    private String role[];

}

