package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.model.Organization;
import com.catalogointerno.Projeto.Catalogo.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


@Service
public class OrganizationService {

    public List<Organization> loadOrganization() {
        Gson gson = new Gson();
        List<Organization> list = new ArrayList<>();

        try {

            File file = new ClassPathResource("organization.json").getFile();
            Reader reader = new FileReader(file);
            list = gson.fromJson(reader, new TypeToken<List<Organization>>() {
            }.getType());



        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return list;
    }

}







