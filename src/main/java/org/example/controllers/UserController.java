package org.example.controllers;

import org.example.dtos.request.RegisterRequest;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/Register")
    public ResponseEntity<?> RegisterUser(@RequestBody RegisterRequest request){


    }

}
