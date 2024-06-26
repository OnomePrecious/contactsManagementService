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
        isValidUser(user);
        user = userRepository.save(user);
        return mapUserToRegisterResponse(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public ChangePasswordResponse changePassword(ChangePasswordRequest changePasswordRequest) {
        User user = userRepository.findByUsername(changePasswordRequest.getUsername());
        if(user == null) throw new UserNotFoundException("You must be a registered user");
        user.setPassword(changePasswordRequest.getNewPassword());
//        user = mapChangePasswordRequestToUser(changePasswordRequest, user);
        var user2 = userRepository.save(user);
        System.out.println(user2.getPassword()+ " has been changed");
        return mapUserToChangePasswordResponse(user2);
    }

    private void isValidUser(User user) {
        User foundUser = userRepository.findByUsername(user.getUsername());
        if (foundUser != null) throw new UsernameAlreadyExistsException("Invalid username or password");
    }
}
