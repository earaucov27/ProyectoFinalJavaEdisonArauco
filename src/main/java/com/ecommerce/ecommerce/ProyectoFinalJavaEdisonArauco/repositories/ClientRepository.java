package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
}
