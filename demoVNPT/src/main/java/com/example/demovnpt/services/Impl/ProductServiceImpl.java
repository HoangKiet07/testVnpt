package com.example.demovnpt.services.Impl;

import com.example.demovnpt.dto.ProductDto;
import com.example.demovnpt.exceptions.DataNotFoundException;
import com.example.demovnpt.models.Product;
import com.example.demovnpt.repositories.ProductRepository;
import com.example.demovnpt.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DateTimeException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
            return productRepository.findById(id).orElseThrow(()->new DateTimeException("Product not Found"));
    }

    @Override
    public Product createProduct(ProductDto productDTO) {
        return productRepository.save(Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .code(productDTO.getCode())
                .status(productDTO.getStatus())
                .build());
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDTO){
        Product product = getProductById(id);
        if(product !=null){
            product.setCode(productDTO.getCode());
            product.setName(productDTO.getName());
            product.setStatus(productDTO.getStatus());
            product.setPrice(productDTO.getPrice());
        }
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
