package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.model.Organization;
import com.catalogointerno.Projeto.Catalogo.model.Product;
import com.catalogointerno.Projeto.Catalogo.model.ReturnProducts;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bouncycastle.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@Service
public class ProductService {

    @Autowired
    OrganizationService organizationService;

    public ReturnProducts consultaProducts (String organizationName, String tags, List<GrantedAuthority> authorities) {

        ReturnProducts retorno = new ReturnProducts();
        List<Organization> organizationList = organizationService.loadOrganization();
        List<Product> productListFull = this.loadProducts();
        List<Product> productList = new ArrayList<>();

        Set<Organization> organizations = this.verifyAuthorities(organizationName, authorities);


        if(tags == null){
            for (Organization org : organizations) {
               for(Product produto: productListFull){
                   if(produto.getDepartment().equalsIgnoreCase(org.getName())){
                       productList.add(produto);
                   }
               }
            }
            retorno.setProductList(productList);
        }else{
            List<String> tagList = new ArrayList<String>(Arrays.asList(tags.split(",")));
            for (Organization org : organizations) {
                for(Product produto: productListFull){
                    if(produto.getDepartment().equalsIgnoreCase(org.getName())){
                        for(String tag : tagList){
                            for (String tagProduto : produto.getTags()){
                                if(tag.equalsIgnoreCase(tagProduto)){
                                    productList.add(produto);
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            retorno.setProductList(productList);

        }

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

    private Set<Organization> verifyAuthorities(String organizationName, List<GrantedAuthority> authorities) {
        List<Organization> organizationList = organizationService.loadOrganization();
        List<Organization> organizations = new ArrayList<>();
        Set<Organization> organizationsRetorno = new HashSet<>();
        String parent = "";

        for (Organization org: organizationList) {
            if (org.getName().equalsIgnoreCase(organizationName) || parent.equalsIgnoreCase(org.getParent())){
                parent = org.getName();
                organizations.add(org);
            }
        }

        for (Organization o : organizationList){
            for(Organization oo: organizations){
                if(o.getParent() != null  &&  o.getParent().equalsIgnoreCase(oo.getName())){
                    organizationsRetorno.add(o);
                }

            }
        }

        return organizationsRetorno;

    }
}