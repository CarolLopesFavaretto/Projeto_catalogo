package com.catalogointerno.Projeto.Catalogo.model;

import lombok.Data;

@Data
public class Product {

    private String name;
    private String department;
    private String material;
    private String price;
    private String tags[];

}
