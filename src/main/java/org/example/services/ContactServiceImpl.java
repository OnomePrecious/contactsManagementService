package org.example.services;

import org.example.data.models.Contact;
import org.example.data.models.User;
import org.example.data.repositories.ContactRepository;
import org.example.data.repositories.UserRepository;
import org.example.dtos.request.CreateNewContactRequest;
import org.example.dtos.response.CreateNewContactResponse;
import org.example.exceptions.ContactNotFoundException;
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

    @Override
    public Contact findContactByUsername(String username) {
        return contactRepository.findContactByUsername(username);
    }

    @Override
    public CreateNewContactResponse deleteContactByUsername(String username) {
        User user = userRepository.findByUsername(username);
        Contact contact = contactRepository.findContactByUsername(username);
        if(user == null) throw  new UserNotFoundException("You have to be a registered user to delete this contact");
        if(contact == null) throw new ContactNotFoundException("No contact found");
        contactRepository.deleteById(contact.getId());
        contactRepository.delete(contact);
        return mapContactToCreateNewContactResponse(contact);
    }


}
