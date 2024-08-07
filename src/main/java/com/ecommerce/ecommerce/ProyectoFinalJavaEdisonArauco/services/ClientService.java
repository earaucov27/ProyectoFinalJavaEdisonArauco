package com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.services;

import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.entities.Client;
import com.ecommerce.ecommerce.ProyectoFinalJavaEdisonArauco.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        client.setName(clientDetails.getName());
        client.setLastname(clientDetails.getLastname());
        client.setDocnumber(clientDetails.getDocnumber());
        return clientRepository.save(client);
    }
}
