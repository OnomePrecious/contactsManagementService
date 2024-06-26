package org.example.utils;

import org.example.data.models.User;
import org.example.dtos.request.ChangePasswordRequest;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.ChangePasswordResponse;
import org.example.dtos.response.CreateNewContactResponse;
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

    public static User mapChangePasswordRequestToUser(ChangePasswordRequest changePasswordRequest, User user){
        user.setUsername(changePasswordRequest.getUsername());
        user.setPassword(changePasswordRequest.getNewPassword());
        return user;
    }

    public static ChangePasswordResponse mapUserToChangePasswordResponse(User user){
        ChangePasswordResponse response = new ChangePasswordResponse();
        response.setMessage("password changed successfully");
        response.setUsername(user.getUsername());
        return response;
    }

    public static User mapUserToCreateContact(CreateNewContactRequest createNewContactRequest, User user){
        user.setFirstName(createNewContactRequest.getFirstName());
        user.setLastName(createNewContactRequest.getLastName());
        user.setPhoneNumber(createNewContactRequest.getPhoneNumber());
        user.setUsername(createNewContactRequest.getUsername());
        return user;
    }

    public static void mapUserToCreateContactResponse(User user){
        CreateNewContactResponse response = new CreateNewContactResponse();
        response.setMessage("Contact created successfully");
        response.setUsername(user.getUsername());
    }
}
