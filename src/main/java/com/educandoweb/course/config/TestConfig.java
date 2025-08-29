package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepositories;

@Configuration //Spring sabe que aqui tem código de configuração.
@Profile("test") //só será carregada quando o perfil ativo for test.
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepositories userRepositories;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
    
    //salva no banco
    userRepositories.saveAll(Arrays.asList(u1, u2));
    }
}
