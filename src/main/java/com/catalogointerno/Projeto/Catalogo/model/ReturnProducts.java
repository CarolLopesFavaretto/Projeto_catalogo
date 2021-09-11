package com.catalogointerno.Projeto.Catalogo.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReturnProducts {

    private int total;

     private List<Product> productList = new ArrayList<>();
}
