package com.example.InsuranceApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.InsuranceApp.entity.Client;
import com.example.InsuranceApp.service.ClientService;

@Controller
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("")
    public String getAllClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "clients";
    }

    @GetMapping("/{id}")
    public String getClientById(@PathVariable Long id, Model model) {
        Optional<Client> client = clientService.getClientById(id);
        model.addAttribute("client", client.orElse(null));
        return "clients";
    }
    
    // Show the new client form
    @GetMapping("/NewClient")
    public String showNewClientForm(Model model) {
        Client client = new Client();
        model.addAttribute("client", client);
        return "NewClient";
    }
    
    @PostMapping("")
    public String createClient(Client client, Model model) {
        clientService.createClient(client);
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("clients", clients);
        return "redirect:/clients";
    }

    @GetMapping("/{clientId}/EditClient")
    public String showEditClientForm(@PathVariable Long clientId, Model model) {
        Client client = clientService.getClientById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + clientId));
        model.addAttribute("client", client);
        return "EditClient";
    }

    @PutMapping("/{clientId}")
    public String updateClient(@PathVariable Long clientId, @ModelAttribute Client client) {
        clientService.updateClient(clientId, client);
        return "redirect:/clients";
    }

    @DeleteMapping("/{clientId}")
    public String deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/clients";
    }

    @PostMapping("/{clientId}")
    public String confirmDelete(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
        return "redirect:/clients";
    }
    
}
