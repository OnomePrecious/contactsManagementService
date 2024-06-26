package org.example.utils;

import org.example.data.models.Contact;
import org.example.data.models.User;
import org.example.dtos.request.ChangePasswordRequest;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.request.DeleteContactRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.ChangePasswordResponse;
import org.example.dtos.response.CreateNewContactResponse;
import org.example.dtos.response.DeleteContactResponse;
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

    public static Contact mapContactToNewContactRequest(CreateNewContactRequest createNewContactRequest, Contact contact){
        contact.setFirstName(createNewContactRequest.getFirstName());
        contact.setLastName(createNewContactRequest.getLastName());
        contact.setPhoneNumber(createNewContactRequest.getPhoneNumber());
        contact.setUsername(createNewContactRequest.getUsername());
        return contact;
    }

    public static CreateNewContactResponse mapContactToCreateNewContactResponse(Contact contact){
        CreateNewContactResponse response = new CreateNewContactResponse();
        response.setMessage("Contact created successfully");

        return response;
    }

    public static Contact mapDeleteContactToContact(DeleteContactRequest deleteContactRequest, Contact contact){
        contact.setId(deleteContactRequest.getId());
        contact.setUsername(deleteContactRequest.getUsername());
        return contact;

    }
    public static DeleteContactResponse mapDeleteContactResponseToContact(Contact contact){
        DeleteContactResponse response = new DeleteContactResponse();
        response.setMessage("Contact deleted successfully");
        return response;
    }
}
