package org.example.controllers;

import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.ApiResponse;
import org.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/contacts")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/Register")
    public ResponseEntity<?> RegisterUser(@RequestBody RegisterRequest request){
    try{
        var result = userService.registerUser(request);
        return new ResponseEntity<>(new ApiResponse(true, result), CREATED);
    }catch(Exception e){
        return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), CREATED);
    }

    }

}
