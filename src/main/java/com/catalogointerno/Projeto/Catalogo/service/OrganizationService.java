package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.Json.StaffOrganization;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService {

    public Optional<StaffOrganization> validaNome (String name) {
        Gson gson = new Gson();

        try {

            File file = new ClassPathResource("organization.json").getFile();

            Reader reader = new FileReader(file);

            List<StaffOrganization> staffOrganization = gson.fromJson(reader, new TypeToken<List<StaffOrganization>>() {
            }.getType());



        } catch(IOException e){
            e.printStackTrace();
        }
        return null;

    }
}
