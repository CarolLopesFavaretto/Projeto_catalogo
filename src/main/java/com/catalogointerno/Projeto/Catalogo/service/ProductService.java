package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.Json.StaffUser;
import com.catalogointerno.Projeto.Catalogo.model.LeituraProducts;
import com.catalogointerno.Projeto.Catalogo.model.Product;
import com.catalogointerno.Projeto.Catalogo.model.ReturnProducts;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    private Object LeituraProducts;

    public ReturnProducts consultaProducts (String organizationName, String tags) {

        ReturnProducts retorno = new ReturnProducts();

        List<LeituraProducts> list = new ArrayList<>();

//        Product product1 = new Product();
//        Product product2 = new Product();
//        String tags1[] = {"menina", "brinquedos"};
//        String tags2[] = {"tecnologia", "informatica"};
//
//        product1.setName("Boneca");
//        product1.setDepartment("Brinquedos");
//        product1.setMaterial("Plastico");
//        product1.setPrice("50.00");
//        product1.setTags(tags1);
//
//        product2.setName("Monitor");
//        product2.setDepartment("Informatica");
//        product2.setMaterial("Plastico");
//        product2.setPrice("180.00");
//        product2.setTags(tags2);

        //for (LeituraProducts lista : LeituraProducts) {

       // retorno.getProductList().add(product2);
        retorno.setTotal(retorno.getProductList().size());

        return retorno;
    }
}