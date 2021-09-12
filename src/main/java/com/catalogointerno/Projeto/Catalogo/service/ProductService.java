package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.model.Organization;
import com.catalogointerno.Projeto.Catalogo.model.Product;
import com.catalogointerno.Projeto.Catalogo.model.ReturnProducts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProductService {

    @Autowired
    OrganizationService organizationService;

    public ReturnProducts consultaProducts (String organizationName, String tags, List<GrantedAuthority> authorities) {

        ReturnProducts retorno = new ReturnProducts();

        List<Organization> organizationList = organizationService.loadOrganization();


        retorno.setProductList(this.loadProducts());
        retorno.setTotal(retorno.getProductList().size());

        return retorno;
    }

    public List<Product> loadProducts(){
        String file = "products.txt";
        Gson gson = new Gson();
        List<Product> retornoList = new ArrayList<>();

        Path path = Paths.get(file);

        try {
            List<String> linhasArquivo = Files.readAllLines(path);
            for (String linha : linhasArquivo) {
                Product product = gson.fromJson(linha, new TypeToken<Product>(){}.getType());
                retornoList.add(product);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return retornoList;

    }
}