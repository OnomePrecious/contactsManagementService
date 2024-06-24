package org.example.data.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class User {
    private String username;
    private String password;
    private int phoneNumber;
    private String address;
    private String email;
}
