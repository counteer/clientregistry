package com.homework.clientregistry.controller;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @CrossOrigin
    @GetMapping("/clients")
    public List<ClientDto> getClients() {
        return service.getClients();
    }

    @CrossOrigin
    @PostMapping("/clients")
    public List<ClientDto> addClient(@RequestBody ClientDto clientDto) {
        service.addClient(clientDto);
        return service.getClients();
    }

    @CrossOrigin
    @GetMapping("/clients/{id}")
    public ClientDto getClient(@PathVariable Long id) {
        return service.getClient(id);
    }
}
