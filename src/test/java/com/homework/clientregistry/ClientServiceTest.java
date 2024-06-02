package com.homework.clientregistry;

import com.homework.clientregistry.mapper.ClientMapper;
import com.homework.clientregistry.repository.ClientRepository;
import com.homework.clientregistry.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository repository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService service;


    @Test
    public void testGetClients() {
        service.getClients();
        verify(repository).findAll();
    }
}
