package org.example.dtos.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter


public class RegisterResponse {
    private String id;
    private String username;
    private String message;
}
