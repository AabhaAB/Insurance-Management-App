package com.example.InsuranceApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.InsuranceApp.entity.Client;
import com.example.InsuranceApp.repository.ClientRepo;

@Service
public class ClientService {
	@Autowired
	 private ClientRepo clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long i) {
        return clientRepository.findById(i);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client client) {
        Optional<Client> existingClient = clientRepository.findById(id);
        if (existingClient.isPresent()) {
            Client updatedClient = existingClient.get();
            updatedClient.setName(client.getName());
            updatedClient.setDateOfBirth(client.getDateOfBirth());
            updatedClient.setAddress(client.getAddress());
            updatedClient.setContact(client.getContact());
            return clientRepository.save(updatedClient);
        } else {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
    }

    public void deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if (client.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Client not found with id: " + id);
        }
    }
}
