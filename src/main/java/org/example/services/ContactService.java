package org.example.services;

import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.response.CreateNewContactResponse;

public interface ContactService {

    CreateNewContactResponse createNewContact (CreateNewContactRequest request);
}
