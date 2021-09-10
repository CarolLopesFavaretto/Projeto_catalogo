package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.Json.StaffUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.core.userdetails.User;
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
public class UserService implements UserDetailsService {



    public Optional<StaffUser>  validaEmail (String email){
        Gson gson = new Gson();
        try {
            File file = new ClassPathResource("users.json").getFile();
            Reader reader = new FileReader(file);
            List<StaffUser> staffUser = gson.fromJson(reader, new TypeToken<List<StaffUser>>(){}.getType());

            for (StaffUser su : staffUser) {
                if(email.equals(su.getEmail())){
                    Optional<StaffUser> user = Optional.of(su);
                  return user;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<StaffUser> usuario = this.validaEmail(email);

        return User
                .builder()
                .username(usuario.get().getEmail())
                .password(usuario.get().getPassword())
                .roles(usuario.get().getRoles())
                .build()
                ;
    }
}
