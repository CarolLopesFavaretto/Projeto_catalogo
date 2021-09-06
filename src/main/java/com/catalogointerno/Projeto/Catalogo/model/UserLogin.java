package com.catalogointerno.Projeto.Catalogo.model;

import lombok.Data;

@Data

public class UserLogin {

	private long UserId;
	private String email;
	private String password;
	private String token;
	private String role[]; // retorna list de usuarios?
}
