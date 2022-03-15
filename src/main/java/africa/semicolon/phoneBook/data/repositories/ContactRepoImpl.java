package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.exception.ContactNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ContactRepoImpl implements ContactRepo{

     private List<Contact> db = new ArrayList<>();
    private int count;

    @Override
    public Contact addContact(Contact contact) {
        for ( Contact myContact: db) {
            if(myContact.equals(contact)){
                update(contact);
            }
        }
        db.add(contact);
        count++;
        return contact;
    }

    private void update(Contact contact) {
        deleteContact(contact);
        db.add(contact);
    }

    @Override
    public int count() {

        return count;
    }

    @Override
    public void deleteContact(Contact contact) {
//        Contact foundContact = findBy(contact.getFirstName());
        db.remove(contact);
        count--;
    }

    @Override
    public List<Contact> findBy(String params) {
        List<Contact> contacts = new ArrayList<>();
        for (Contact contact : db) {
            if(contact.getFirstName().trim().equalsIgnoreCase(params) ||
            contact.getMobile().trim().equalsIgnoreCase(params) || contact.getLastName().trim().equalsIgnoreCase(params))  {

                contacts.add(contact);
            }
        }
//        if(contacts.isEmpty()) throw new ContactNotFoundException(params+ " not found");
        return contacts;
    }

    @Override
    public List<Contact> findAllContact() {
        return db;
    }


}
