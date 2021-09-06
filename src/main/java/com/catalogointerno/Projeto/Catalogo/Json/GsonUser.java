package com.catalogointerno.Projeto.Catalogo.Json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class GsonUser {

    public static void main(String[] args) {

        Gson gson = new Gson();


        try {

            File file = new ClassPathResource("users.json").getFile();

            Reader reader = new FileReader(file);

            List<StaffUser> staffUser = gson.fromJson(reader, new TypeToken<List<StaffUser>>(){}.getType());

            System.out.println(staffUser.toString());


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
