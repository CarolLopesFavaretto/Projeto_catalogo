package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.Json.StaffOrganization;
import com.catalogointerno.Projeto.Catalogo.Json.StaffUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

@Service
public class OrganizationService implements UserDetailsService {



    public Optional<StaffOrganization> validaLevel (String level) {
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
