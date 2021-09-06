package com.catalogointerno.Projeto.Catalogo.Json;

import lombok.Data;

@Data
public class StaffUser {

    private String userId;
    private String email;
    private String password;
    private String roles[];


}
