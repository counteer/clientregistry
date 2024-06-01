package com.homework.clientregistry.mapper;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDto toClientDTO(Client client);

    Client toClient(ClientDto ClientDto);
}
