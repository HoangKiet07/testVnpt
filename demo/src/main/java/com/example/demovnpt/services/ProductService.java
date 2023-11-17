package com.example.demovnpt.services;

import com.example.demovnpt.dto.ProductDto;
import com.example.demovnpt.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProduct();

    public Product getProductById(Long id)throws  Exception;

    public Product createProduct(ProductDto productDTO);

    public Product updateProduct(Long id, ProductDto productDTO);

    public void deleteProduct(Long id);
}
