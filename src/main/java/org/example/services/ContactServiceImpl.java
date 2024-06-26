package org.example.services;

import org.example.data.models.Contact;
import org.example.data.models.User;
import org.example.data.repositories.ContactRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.response.CreateNewContactResponse;
import org.example.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.utils.Mappers.mapContactToNewContactRequest;
import static org.example.utils.Mappers.mapContactToCreateNewContactResponse;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ContactRepository contactRepository;
    @Override
    public CreateNewContactResponse createNewContact(CreateNewContactRequest request) {
        Contact contact = new Contact();
        User user = userRepository.findByUsername(request.getUsername());
        if(user == null) throw new UserNotFoundException("You must be a registered user");
        mapContactToNewContactRequest(request, contact);
        userRepository.save(user);
        contactRepository.save(contact);
        return mapContactToCreateNewContactResponse(contact);

    }
}
