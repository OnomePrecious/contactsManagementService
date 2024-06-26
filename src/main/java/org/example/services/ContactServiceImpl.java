package org.example.services;

import org.example.data.models.Contact;
import org.example.data.models.User;
import org.example.data.repositories.ContactRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.response.CreateNewContactResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.utils.Mappers.mapContactToNewContactRequest;
import static org.example.utils.Mappers.mapUserToCreateContactResponse;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private UserRepository userRepository;
    private ContactRepository contactRepository;
    @Override
    public CreateNewContactResponse createNewContact(CreateNewContactRequest request) {
        Contact contact = new Contact();
        User user = userRepository.findByUsername(request.getUsername());
        mapContactToNewContactRequest(request, contact);
        userRepository.save(user);
        contactRepository.save(contact);
        return mapUserToCreateContactResponse(contact);

    }
}
