package org.example.services;

import org.example.data.repositories.ContactRepository;
import org.example.data.repositories.UserRepository;
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
    @Autowired
    private UserService userService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        contactRepository.deleteAll();
        userRepository.deleteAll();
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
        var user = userService.registerUser(request);


        CreateNewContactRequest createNewContactRequest = new CreateNewContactRequest();
        createNewContactRequest.setFirstName("Alicia");
        createNewContactRequest.setLastName("Keys");
        createNewContactRequest.setUsername(user.getUsername());
        createNewContactRequest.setPhoneNumber(1243);
        contactService.createNewContact(createNewContactRequest);

        assertEquals(1, contactRepository.count());
        assertEquals("Alicia", createNewContactRequest.getFirstName());

    }
}