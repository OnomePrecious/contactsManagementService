package org.example.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DeleteContactRequest {
    private String username;
    private String id;
}
