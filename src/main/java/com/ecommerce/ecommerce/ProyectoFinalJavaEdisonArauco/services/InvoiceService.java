package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.services;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Invoice;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Client;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Cart;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.InvoiceRepository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.CartRepository;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CartRepository cartRepository;

    public Invoice generateInvoice(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        List<Cart> carts = cartRepository.findByClientIdAndDelivered(clientId, false);
        if (carts.isEmpty()) {
            throw new RuntimeException("No products in cart");
        }
        Invoice invoice = new Invoice();
        invoice.setClient(client);
        invoice.setCreatedAt(new Date());
        double total = carts.stream().mapToDouble(cart -> cart.getAmount() * cart.getPrice()).sum();
        invoice.setTotal(total);
        carts.forEach(cart -> cart.setDelivered(true));
        cartRepository.saveAll(carts);
        return invoiceRepository.save(invoice);
    }

    public Optional<Invoice> getLastInvoiceByClientId(Long clientId) {
        return invoiceRepository.findAll()
                .stream()
                .filter(invoice -> invoice.getClient().getId().equals(clientId))
                .sorted((i1, i2) -> i2.getCreatedAt().compareTo(i1.getCreatedAt()))
                .findFirst();
    }
}
