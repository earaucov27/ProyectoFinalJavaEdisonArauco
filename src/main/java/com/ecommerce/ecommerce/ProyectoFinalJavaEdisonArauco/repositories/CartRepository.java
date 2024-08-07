package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByClientIdAndDelivered(Long clientId, Boolean delivered);
}
