package com.homework.clientregistry;

import com.homework.clientregistry.controller.ClientController;
import com.homework.clientregistry.service.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    @Mock
    private ClientService clientService;

    @InjectMocks
    private ClientController controller;

    @Test
    public void testGetClients() {
        controller.getClients();
        verify(clientService).getClients();
    }
}
