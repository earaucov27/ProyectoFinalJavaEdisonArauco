package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.services;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Product;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setTitle(productDetails.getTitle());
        product.setStock(productDetails.getStock());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }
}
