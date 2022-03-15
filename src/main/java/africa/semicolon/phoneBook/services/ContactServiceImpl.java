package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepo;
import africa.semicolon.phoneBook.data.repositories.ContactRepoImpl;
import africa.semicolon.phoneBook.dtos.request.AddContactRequest;
import africa.semicolon.phoneBook.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBook.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import africa.semicolon.phoneBook.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBook.exception.ContactNotFoundException;

public class ContactServiceImpl implements ContactService {

    private ContactRepo contactDb = new ContactRepoImpl();
    @Override
    public AddContactResponse save(AddContactRequest request) {
        Contact contactToBeAdded = new Contact(request.getFirstName(), request.getLastName(), request.getMobile());
        contactDb.addContact(contactToBeAdded);

        AddContactResponse response = new AddContactResponse();
        response.setFullName(contactToBeAdded.getFirstName() + " " + contactToBeAdded.getLastName());
        response.setMobile(contactToBeAdded.getMobile());

        return response;
    }

//    @Override
//    public void save(Contact myContact) {
//
//    }

    @Override
    public ContactRepo getRepository() {
        return contactDb;
    }

    @Override
    public DeleteContactResponse delete(DeleteContactRequest deleteRequest) {

        Contact contactToBeDeleted = new Contact(deleteRequest.getFirstName(), deleteRequest.getMobile());
        contactDb.deleteContact(contactToBeDeleted);

        DeleteContactResponse response = new DeleteContactResponse();
        response.setResponse("delete successful");
    return response;
    }

    @Override
    public AddContactResponse search(String params) {
        for (Contact contact: contactDb.findAllContact()) {
            if(contact.getFirstName().trim().equalsIgnoreCase(params) ||
                    contact.getLastName().trim().equalsIgnoreCase(params) ||
            contact.getMobile().trim().equalsIgnoreCase(params)){
             AddContactResponse response = new AddContactResponse();
             response.setFullName(contact.getFirstName() + " " + contact.getLastName() );
             response.setMobile(contact.getMobile());
             return response;
            }

        }
         throw new ContactNotFoundException(params+ " not found");

    }

    @Override
    public void editContact(UpdateContactRequest updateRequest) {

    }
}
