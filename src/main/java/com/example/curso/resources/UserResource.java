package com.example.curso.resources;

import com.example.curso.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Maria", "maria@gmail.com", "(44) 99999-9999", "123mudar");
        return ResponseEntity.ok().body(user);
    }
}
