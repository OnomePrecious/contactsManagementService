package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.ChangePasswordRequest;
import org.example.dtos.request.RegisterRequest;
import org.example.dtos.response.ChangePasswordResponse;
import org.example.dtos.response.RegisterResponse;
import org.example.exceptions.UserNotFoundException;
import org.example.exceptions.UsernameAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.utils.Mappers.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;


    @Override
    public RegisterResponse registerUser(RegisterRequest request) {
        User user = new User();
        mapUserToRegisterRequest(request, user);
        if(isValidUser(user)) userRepository.save(user);
        else throw new UsernameAlreadyExistsException("Invalid username or password");
        return mapUserToRegisterResponse(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findUserByUsername(changePasswordRequest.getUsername());
        if(user == null) throw new UserNotFoundException("You must be a registered user");
        mapChangePasswordRequestToUser(changePasswordRequest, user);
        userRepository.save(user);
        mapUserToChangePasswordResponse(user);
        return null;
    }

    private boolean isValidUser(User user) {
        return userRepository.findUserByUsername(user.getUsername()) == null;
    }
}
