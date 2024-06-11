package com.homework.clientregistry;

import com.homework.clientregistry.dto.ClientDto;
import com.homework.clientregistry.entity.Client;
import com.homework.clientregistry.repository.ClientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(classes = {ClientRegistryApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
class ClientRegistryApplicationTests {


    @LocalServerPort
    private int port;

    @Autowired
    private ClientRepository clientRepository;

    TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void contextLoads() {
        clientRepository.deleteAll();
        HttpEntity<ClientDto> payload = new HttpEntity<>(createClient());
        restTemplate.exchange(getUrl(), HttpMethod.POST, payload, Void.class);
        List<Client> dbContent = clientRepository.findAll();
        assertThat(dbContent.size(), is(1));
    }

    private ClientDto createClient() {
        return new ClientDto(null, "test", "any_mother", null, "any_place", "ssn", "email", new ArrayList<>(), new ArrayList<>());
    }

    private String getUrl() {
        return "http://localhost:" + port + "/clients";
    }
}
