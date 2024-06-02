package com.homework.clientregistry.controller;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.service.ClientService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<ClientDto>> getClients() {
        return ResponseEntity.ok(service.getClients());
    }

    @CrossOrigin
    @PostMapping("/clients")
    public ResponseEntity<Void> addClient(@RequestBody ClientDto clientDto) {
        service.addClient(clientDto);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin
    @GetMapping("/clients/{id}")
    public ResponseEntity<ClientDto> getClient(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClient(id));
    }

    @CrossOrigin
    @DeleteMapping("/clients/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
