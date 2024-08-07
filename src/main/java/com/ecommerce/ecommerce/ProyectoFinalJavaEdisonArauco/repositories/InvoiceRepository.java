package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
