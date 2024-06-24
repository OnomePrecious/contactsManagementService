package org.example.services;

import org.example.data.repositories.UserRepository;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.RegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void setUp(){
        userRepository.deleteAll();

    }


    @Test
   public void testThatAUserCanRegister() {
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);
        RegisterResponse response = userService.registerUser(request);
        assertNotNull(response);
        assertEquals(1, userRepository.count());
    }
}