package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNewContactRequest {
    private String username;
    private String firstName;
    private String lastName;
    private int phoneNumber;
}
