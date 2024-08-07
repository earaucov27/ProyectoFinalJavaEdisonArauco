package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.controllers;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.services.InvoiceService;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Invoice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Operation(summary = "Generate an invoice", description = "Generates an invoice for the client's cart with the total amount")
    @ApiResponse(responseCode = "200", description = "Invoice generated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Invoice.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Client or carts not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping
    public ResponseEntity<Invoice> generateInvoice(@RequestParam Long clientId) {
        try {
            Invoice invoice = invoiceService.generateInvoice(clientId);
            return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Get invoices by client ID", description = "Retrieves the last invoice for the specified client")
    @ApiResponse(responseCode = "200", description = "Invoices retrieved successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Invoice.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Client not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @GetMapping("/{clientId}")
    public ResponseEntity<Optional<Invoice>> getInvoicesByClientId(@PathVariable Long clientId) {
        try {
            Optional<Invoice> invoice = invoiceService.getLastInvoiceByClientId(clientId);
            return ResponseEntity.ok(invoice);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
