package br.com.matheus.naturaSSP.controllers;

import br.com.matheus.naturaSSP.models.Category;
import br.com.matheus.naturaSSP.models.Product;
import br.com.matheus.naturaSSP.services.product.IProductService;
import br.com.matheus.naturaSSP.services.upload.IUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    private IProductService service;
    @Autowired
    private IUploadService upload;


    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            service.createProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/products/upload")
    ResponseEntity<String> uploadImage(@RequestParam(name = "file")MultipartFile file) {
        String path = upload.uploadFile(file);
        if (path != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(path);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/products")
    public ResponseEntity<ArrayList<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/products/category/{id}")
    public ResponseEntity<ArrayList<Product>> findByCategory(@PathVariable(name = "id") int idCategory) {
        Category category = new Category();
        category.setId(idCategory);
        return ResponseEntity.ok(service.findAllByCategory(category));
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findById(@PathVariable(name = "id") int idProduto) {
        Product prod = service.findById(idProduto);
        if (prod != null) {
            return ResponseEntity.ok(prod);
        }
        return  ResponseEntity.badRequest().build();
    }
}
