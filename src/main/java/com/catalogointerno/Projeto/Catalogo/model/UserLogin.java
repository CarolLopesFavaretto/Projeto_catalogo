package com.catalogointerno.Projeto.Catalogo.model;

import lombok.Data;

@Data
public class UserLogin {

	private String UserId;
	private String email;
	private String password;
	private String token;
	private String role[];
}
