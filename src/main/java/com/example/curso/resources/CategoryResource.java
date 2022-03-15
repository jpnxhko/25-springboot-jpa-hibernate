package com.example.curso.resources;

import com.example.curso.entities.Category;
import com.example.curso.services.CatergoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CatergoryService catergoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> list = catergoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = catergoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
