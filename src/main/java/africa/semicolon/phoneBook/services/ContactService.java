package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.repositories.ContactRepo;
import africa.semicolon.phoneBook.dtos.request.AddContactRequest;
import africa.semicolon.phoneBook.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBook.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import africa.semicolon.phoneBook.dtos.response.DeleteContactResponse;

public interface ContactService {
    AddContactResponse save(AddContactRequest request);

    ContactRepo getRepository();

    DeleteContactResponse delete(DeleteContactRequest deleteRequest);

    AddContactResponse search(String params);

    void editContact(UpdateContactRequest updateRequest);
}
