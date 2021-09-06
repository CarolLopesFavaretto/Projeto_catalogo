package com.catalogointerno.Projeto.Catalogo.service;

import com.catalogointerno.Projeto.Catalogo.model.User;
import com.catalogointerno.Projeto.Catalogo.model.UserLogin;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.nio.charset.Charset;
import java.util.Optional;

public class UserService {

    public Optional<UserLogin> Logar (Optional<UserLogin> user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        //Optional<User> usuario = UserRepository.findByUser(User.get().getUser());

        if(user.isPresent()) {
            if(encoder.matches(user.get().getPassword(), user.get().getPassword())) {

                String auth = user.get().getEmail() + ":" + user.get().getPassword();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setUserId(user.get().getUserId());
                user.get().setEmail(user.get().getEmail());
                user.get().setRole(user.get().getRole());


                return user;

            }
        }
        return null;
    }
}
