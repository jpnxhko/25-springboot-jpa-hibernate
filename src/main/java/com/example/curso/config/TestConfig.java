package com.example.curso.config;

import com.example.curso.entities.User;
import com.example.curso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        User user1 = new User(null, "Maria Brown", "maria@gmail.com", "111111111", "senha1");
        User user2 = new User(null, "Alex Green", "alex@gmail.com", "222222222", "senha2");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}
