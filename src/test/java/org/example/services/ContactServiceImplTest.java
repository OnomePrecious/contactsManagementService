package org.example.services;

import org.example.data.repositories.ContactRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.RegisterResponse;
import org.example.exceptions.UserNotFoundException;
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
    @Test
    public void test_throwsExceptionWhenITryToCreateContactWithoutRegisteringFirst(){
        CreateNewContactRequest createNewContactRequest = new CreateNewContactRequest();
        createNewContactRequest.setFirstName("Alicia");
        createNewContactRequest.setLastName("Keys");
        createNewContactRequest.setPhoneNumber(1243);
        assertThrows(UserNotFoundException.class, () -> {
            contactService.createNewContact(createNewContactRequest);
        });
    }

    @Test
    public void testThatRegisteredUserCanCreateTwoContact(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);
        userService.registerUser(request);


        CreateNewContactRequest createNewContactRequest = new CreateNewContactRequest();
        createNewContactRequest.setFirstName("Alicia");
        createNewContactRequest.setLastName("Keys");
        createNewContactRequest.setUsername("username");
        createNewContactRequest.setPhoneNumber(1243);
        contactService.createNewContact(createNewContactRequest);

        CreateNewContactRequest createNewContactRequest1 = new CreateNewContactRequest();
        createNewContactRequest1.setFirstName("Bianca");
        createNewContactRequest1.setLastName("Blanche");
        createNewContactRequest1.setUsername("username");

        createNewContactRequest1.setPhoneNumber(33451);
        contactService.createNewContact(createNewContactRequest1);

        assertEquals(2, contactRepository.count());

    }
}