package org.example.data.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Contact {
    @Id
    private String id;
    private String username;
    private String firstName;
    private String lastName;
    private int phoneNumber;

}
