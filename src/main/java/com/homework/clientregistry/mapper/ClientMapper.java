package com.homework.clientregistry.mapper;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.entity.Client;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toClientDTO(Client client);

    Client toClient(ClientDto ClientDto);

    @AfterMapping
    default void setClient(@MappingTarget Client client, ClientDto dto) {
        if (client.getPhoneNumbers() != null) {
            client.getPhoneNumbers().forEach(phoneNumber -> phoneNumber.setClient(client));
        }
        if (client.getAddresses() != null) {
            client.getAddresses().forEach(address -> address.setClient(client));
        }
    }
}
