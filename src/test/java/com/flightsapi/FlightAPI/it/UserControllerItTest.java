package com.flightsapi.FlightAPI.it;

import com.flightsapi.FlightAPI.dto.UserDTO;
import com.flightsapi.FlightAPI.entity.User;
import com.flightsapi.FlightAPI.repository.UserRepository;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.awaitility.Awaitility.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
public class UserControllerItTest {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Container
    private final static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16.0")
            .withDatabaseName("test")
            .withUsername("testUser")
            .withPassword("testPassword")
            .withInitScript("init.sql");

    @DynamicPropertySource
    static void dynamicPropertyRegistry(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", () -> postgres.getJdbcUrl());
        registry.add("spring.datasource.username", () -> postgres.getUsername());
        registry.add("spring.datasource.password", () -> postgres.getPassword());
    }

    @BeforeAll
    static void beforeAll() {
        postgres.start();
    }

    @AfterAll
    static void afterAll() {
        postgres.stop();
    }

    @Test
    void run(){

    }

    @Test
    void shouldCreateUser() {
        //given
        String url = "http://localhost:" + port + "/api/v1/users/create";
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("test_firstname");
        userDTO.setLastName("test_lastname");
        userDTO.setEmail("test_email");
        userDTO.setPassword("test_password");

        //when
        ResponseEntity<String> response = restTemplate.postForEntity(url, userDTO, String.class);

        //then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    //TODO Jak dobić się do endpointu
}
