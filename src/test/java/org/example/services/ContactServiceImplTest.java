package org.example.services;

import org.example.data.repositories.ContactRepository;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.RegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.AccessType;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ContactServiceImplTest {
    @Autowired
    private ContactRepository contactRepository;
    private UserService userService;
    private ContactService contactService;

    @BeforeEach
    void setUp() {
        contactRepository.deleteAll();
    }

    @Test
    void createNewContact() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);
        userService.registerUser(request);

        CreateNewContactRequest createNewContactRequest = new CreateNewContactRequest();
        createNewContactRequest.setFirstName("ALicia");
        createNewContactRequest.setLastName("Keys");
        createNewContactRequest.setUsername("Alike");
        createNewContactRequest.setPhoneNumber(123);

    }
}