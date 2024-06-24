package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ChangePasswordRequest {
    private String username;
    private String password;
    private String newPassword;
}
