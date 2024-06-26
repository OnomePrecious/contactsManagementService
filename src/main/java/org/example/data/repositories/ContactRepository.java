package org.example.data.repositories;

import org.example.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactRepository extends MongoRepository<Contact, String> {
    Contact findContactByUsername(String username);
}
