package com.example.demovnpt.controllers;

import com.example.demovnpt.dto.ProductDto;
import com.example.demovnpt.models.Product;
import com.example.demovnpt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PostMapping("/createProduct")
    public ResponseEntity<String> createProduct(@RequestBody ProductDto productDto){
        productService.createProduct(productDto);
        return ResponseEntity.ok("Create Product Successfully");
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody ProductDto productDto) {
        productService.updateProduct(id, productDto);
        return ResponseEntity.ok("Update Product Successfully");
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok(" Deleted Product Successfully");
    }
}
