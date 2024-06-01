package com.homework.clientregistry.service;

import com.homework.clientregistry.dto.AddressDto;
import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.dto.PhoneNumberDto;
import com.homework.clientregistry.entity.Address;
import com.homework.clientregistry.entity.Client;
import com.homework.clientregistry.entity.PhoneNumber;
import com.homework.clientregistry.mapper.ClientMapper;
import com.homework.clientregistry.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    private final ClientMapper modelMapper;


    public ClientService(ClientRepository repository, ClientMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<ClientDto> getClients() {
        return repository.findAll().stream().map(modelMapper::toClientDTO).toList();

    }

    public void addClient(ClientDto clientDto) {
//        Client client = clientFromDto(clientDto);
        Client client = modelMapper.toClient(clientDto);
        repository.save(client);
    }

    private Client clientFromDto(ClientDto dto) {

//        final Client client = new Client();
////        client.setId(dto.getId());
//        client.setBirthDate(dto.getBirthDate());
//        client.setName(dto.getName());
//        client.setBirthPlace(dto.getBirthPlace());
//        client.setMothersName(dto.getMothersName());
//        client.setSocialSecurityNumber(dto.getSocialSecurityNumber());
//        if(dto.getAddresses()!=null) {
//            client.setAddresses(dto.getAddresses().stream().map(this::addressFromDto).peek(address -> address.setClient(client)).toList());
//        }
//        if(dto.getPhoneNumbers()!=null) {
//            client.setPhoneNumbers(dto.getPhoneNumbers().stream().map(this::phoneNumbersFromDto).peek(number -> number.setClient(client)).toList());
//        }
        return modelMapper.toClient(dto);
    }

    private Address addressFromDto(AddressDto dto) {
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setStreetAddress(dto.getStreetAddress());
        address.setPostalCode(dto.getPostalCode());
        return address;
    }

    private PhoneNumber phoneNumbersFromDto(PhoneNumberDto dto) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setId(dto.getId());
        phoneNumber.setPhoneNumber(dto.getPhoneNumber());
        return phoneNumber;
    }
}
