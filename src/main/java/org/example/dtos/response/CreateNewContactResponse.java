package org.example.dtos.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CreateNewContactResponse {
    private String id;
    private String username;
    private String message;
}
