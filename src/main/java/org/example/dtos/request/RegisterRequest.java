package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

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
