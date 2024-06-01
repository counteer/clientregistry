package com.homework.clientregistry.controller;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.entity.Client;
import com.homework.clientregistry.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping("/clients")
    public List<ClientDto> getClients(){
        return service.getClients();
    }

    @PostMapping("/clients")
    public List<ClientDto> addClient(@RequestBody ClientDto clientDto){
        service.addClient(clientDto);
        return service.getClients();
    }
}
