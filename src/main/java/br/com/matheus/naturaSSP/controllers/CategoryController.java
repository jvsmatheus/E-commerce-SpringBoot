package br.com.matheus.naturaSSP.controllers;

import br.com.matheus.naturaSSP.models.Category;
import br.com.matheus.naturaSSP.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CategoryController {

    @Autowired
    private ICategoryService service;

    @GetMapping("/categories")
    public ResponseEntity<ArrayList<Category>> findAll() {
        return ResponseEntity.ok().body(service.findAllCategories());
    }

    @GetMapping("/categories/search")
    public ResponseEntity<ArrayList<Category>> findByKeyWord(@RequestParam(name = "key") String keyWord) {
        if (keyWord != null) {
            return ResponseEntity.ok().body(service.findByKeyWord(keyWord));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category result = service.createCategory(category);
        if (result != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category != null) {
            return ResponseEntity.ok().body(service.updateCategory(category));
        }
        return ResponseEntity.badRequest().build();
    }
}
