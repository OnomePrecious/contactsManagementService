package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int phoneNumber;
    private String email;

}
