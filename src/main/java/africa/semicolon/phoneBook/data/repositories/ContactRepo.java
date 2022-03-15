package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepo{ //extends MongoRepository <Contact, String> {

//    Contact findAllContact(String firstName);
    Contact addContact(Contact contact);

    int count();

    void deleteContact(Contact contact);

    List<Contact> findBy(String findName);

    List<Contact> findAllContact();
}
