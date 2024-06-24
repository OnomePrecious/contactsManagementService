package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.ChangePasswordRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.ChangePasswordResponse;
import org.example.dtos.response.RegisterResponse;
import org.example.exceptions.UsernameAlreadyExistsException;
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

    @Test
    public void testThatICanRegisterTwoUsers(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request1 = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);
        request1.setFirstName("Rachel");
        request1.setLastName("Abu");
        request1.setUsername("username1");
        request1.setPassword("password1");
        request1.setEmail("precious@gmail.com");
        request1.setPhoneNumber(321);

        userService.registerUser(request);
        userService.registerUser(request1);

        assertEquals(2, userRepository.count());


    }
    @Test
    public void userTriesToRegisterWithAnExistingUsername_throwsException(){
        RegisterRequest request = new RegisterRequest();
        RegisterRequest request1 = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);
        request1.setFirstName("Rachel");
        request1.setLastName("Abu");
        request1.setUsername("username");
        request1.setPassword("password1");
        request1.setEmail("precious@gmail.com");
        request1.setPhoneNumber(321);

        userService.registerUser(request);
        assertThrows(UsernameAlreadyExistsException.class, ()-> userService.registerUser(request1));

    }

    @Test
    public void testThatICanFindUserByUsername(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);

        userService.registerUser(request);

        assertEquals("username", userService.findUserByUsername("username").getUsername());

    }

    @Test
    public void testThatUserCanChangePassword(){
        RegisterRequest request = new RegisterRequest();
        request.setFirstName("Precious");
        request.setLastName("Onome");
        request.setUsername("username");
        request.setPassword("password");
        request.setEmail("precious@gmail.com");
        request.setPhoneNumber(123);
        userService.registerUser(request);

        ChangePasswordRequest changePasswordRequest = new ChangePasswordRequest();
        changePasswordRequest.setUsername("username");
        changePasswordRequest.setPassword("password");
        changePasswordRequest.setNewPassword("newPassword");
         userService.changePassword(changePasswordRequest);

        assertEquals("username", userRepository.findUserByUsername("username").getUsername());
        }
    }
