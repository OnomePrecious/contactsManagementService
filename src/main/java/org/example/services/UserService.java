package org.example.services;

import org.example.data.models.User;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.RegisterResponse;

public interface UserService {

    RegisterResponse registerUser (RegisterRequest request);

    User findUserByUsername (String username);
}
