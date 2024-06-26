package org.example.services;

import org.example.data.models.Contact;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.request.DeleteContactRequest;
import org.example.dtos.response.CreateNewContactResponse;
import org.example.dtos.response.DeleteContactResponse;

public interface ContactService {

    CreateNewContactResponse createNewContact (CreateNewContactRequest request);

    Contact findContactByUsername (String username);

    DeleteContactResponse deleteContactBy(DeleteContactRequest request);
}
