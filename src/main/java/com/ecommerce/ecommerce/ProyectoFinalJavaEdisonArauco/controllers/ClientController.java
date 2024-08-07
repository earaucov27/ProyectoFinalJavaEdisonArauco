package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.controllers;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Client;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Operation(summary = "Register a new client", description = "Registers a new client with the provided details")
    @ApiResponse(responseCode = "200", description = "Client registered successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PostMapping("/register")
    public ResponseEntity<Client> registerClient(@RequestBody Client client) {
        try {
            Client newClient = clientService.registerClient(client);
            return ResponseEntity.ok(newClient);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Update client profile", description = "Updates the profile of the authenticated client")
    @ApiResponse(responseCode = "200", description = "Client profile updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Client.class)))
    @ApiResponse(responseCode = "400", description = "Bad request")
    @ApiResponse(responseCode = "404", description = "Client not found")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    @PutMapping("/me")
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        try {
            Client updatedClient = clientService.updateClient(client.getId(), client);
            return ResponseEntity.ok(updatedClient);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
