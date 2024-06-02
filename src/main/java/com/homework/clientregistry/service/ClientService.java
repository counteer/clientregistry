package com.homework.clientregistry.service;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.entity.Client;
import com.homework.clientregistry.mapper.ClientMapper;
import com.homework.clientregistry.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    private final ClientMapper clientMapper;


    public ClientService(ClientRepository repository, ClientMapper modelMapper) {
        this.repository = repository;
        this.clientMapper = modelMapper;
    }

    public List<ClientDto> getClients() {
        return repository.findAll().stream().map(clientMapper::toClientDTO).toList();
    }

    public ClientDto getClient(Long id) {
        return clientMapper.toClientDTO(repository.findById(id).orElseThrow());
    }

    public void addClient(ClientDto clientDto) {
        Client client = clientMapper.toClient(clientDto);
        repository.save(client);
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }
}
