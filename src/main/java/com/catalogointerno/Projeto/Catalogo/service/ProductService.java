package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.model.Product;
import com.catalogointerno.Projeto.Catalogo.model.ReturnProducts;
import org.springframework.stereotype.Service;



@Service
public class ProductService {

    public ReturnProducts consultaProducts (String organizationName, String tags) {

        ReturnProducts retorno = new ReturnProducts();
        Product product1 = new Product();
        Product product2 = new Product();
        String tags1[] = {"menina", "brinquedos"};
        String tags2[] = {"tecnologia", "informatica"};

        product1.setName("Boneca");
        product1.setDepartment("Brinquedos");
        product1.setMaterial("Plastico");
        product1.setPrice("50.00");
        product1.setTags(tags1);

        product2.setName("Monitor");
        product2.setDepartment("Informatica");
        product2.setMaterial("Plastico");
        product2.setPrice("180.00");
        product2.setTags(tags2);

        retorno.getProductList().add(product1);
        retorno.getProductList().add(product2);
        retorno.setTotal(retorno.getProductList().size());

        return retorno;
    }
}