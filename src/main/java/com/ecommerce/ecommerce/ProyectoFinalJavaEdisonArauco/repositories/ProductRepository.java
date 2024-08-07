package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
