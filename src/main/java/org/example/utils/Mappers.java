package org.example.utils;

import org.example.data.models.User;
import org.example.dtos.request.ChangePasswordRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.ChangePasswordResponse;
import org.example.dtos.response.RegisterResponse;

public class Mappers {

    public static void mapUserToRegisterRequest (RegisterRequest request, User user) {
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setEmail(request.getEmail());

    }

    public static RegisterResponse mapUserToRegisterResponse(User user){
        RegisterResponse response = new RegisterResponse();
        response.setUsername(user.getUsername());
        return response;
    }

    public static void mapChangePasswordRequestToUser(ChangePasswordRequest changePasswordRequest, User user){
        user.setPassword(changePasswordRequest.getPassword());
        user.setUsername(changePasswordRequest.getUsername());
    }

    public static ChangePasswordResponse mapUserToChangePasswordResponse(User user){
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setUsername(user.getUsername());
        return response;
    }
}
