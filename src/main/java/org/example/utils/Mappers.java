package org.example.utils;

import org.example.data.models.User;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.RegisterResponse;

public class Mappers {

    public static void mapUserToRegisterRequest (RegisterRequest request, User user) {
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.se
    }
}
