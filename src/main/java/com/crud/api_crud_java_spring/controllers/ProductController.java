package com.crud.api_crud_java_spring.controllers;

import com.crud.api_crud_java_spring.domain.product.Product;
import com.crud.api_crud_java_spring.domain.product.ProductRepository;
import com.crud.api_crud_java_spring.domain.product.ProductRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;
    @GetMapping
    public ResponseEntity getAllProducts(){
        var allProduct = repository.findAll();
        return ResponseEntity.ok(allProduct);
    }
    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Valid ProductRequest data){
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    @Transactional
    public ResponseEntity updateProduct(@RequestBody @Valid ProductRequest data){
        Optional<Product> optionalProduct = repository.findById(data.id());
        if (optionalProduct.isPresent()){
            Product product = optionalProduct.get();
            product.setName(data.name());
            product.setPrice_in_cents(data.price_in_cents());
            return ResponseEntity.ok(product);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable String id ){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
