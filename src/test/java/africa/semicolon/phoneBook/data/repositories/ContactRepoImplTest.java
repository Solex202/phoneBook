package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.exception.ContactNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepoImplTest {
    ContactRepo contactRepo;
    @BeforeEach
    void setup() {
      contactRepo = new ContactRepoImpl();
    }

    @Test
    void testThatContactCanBeAddedToRepository() {
        //given
        Contact myContact = new Contact("lota","onwuka","09034653698");
        //when
        contactRepo.addContact(myContact);
        //assert
        assertEquals(1,contactRepo.count());
    }

    @Test
    void testThatContactCanBeDeleted(){
        //given
        Contact myContact1 = new Contact("lota","dejoi","09043764373");
        contactRepo.addContact(myContact1);
        Contact myContact2 = new Contact("miju","adam","08023645363");
        contactRepo.addContact(myContact2);
        Contact myContact3 = new Contact("increase","adam","08076645363");
        //when
        contactRepo.addContact(myContact3);
        //assert
        assertEquals(3,contactRepo.count());
        //when
        contactRepo.deleteContact(myContact1);
        contactRepo.deleteContact(myContact2);
        assertEquals(1,contactRepo.count());

    }

    @Test
    void testThatWeCanFindByFirstName(){
        //given
        Contact myContact1 = new Contact("lota","dejoi","09043764373");
        Contact myContact2 = new Contact("dee","dejoi","09043764373");
        //when
        contactRepo.addContact(myContact1);
        contactRepo.addContact(myContact2);
        List<Contact> foundContact = contactRepo.findBy("lOta");
        //assert
        assertEquals(1,foundContact.size());

    }

    @Test
    void testThatWeCanFindContactsWithSameFirstName(){
        //given
        Contact myContact1 = new Contact("lota","dejoi","09043764373");
        Contact myContact2 = new Contact("lota","ade","07054238765");
        //when
        contactRepo.addContact(myContact1);
        contactRepo.addContact(myContact2);
        List<Contact> foundContacts = contactRepo.findBy("lota");
        //assert
        assertEquals(2, foundContacts.size());

    }
//
//    @Test
//    void testThrowExceptionWhenContactNotFound(){
//        //given
//        Contact myContact1 = new Contact("lota","dejoi","09043764373");
//        Contact myContact2 = new Contact("lota","ade","07054238765");
//        //when
//        contactRepo.addContact(myContact1);
//        contactRepo.addContact(myContact2);
//        //assert
//        assertThrows(ContactNotFoundException.class,()-> contactRepo.findBy("nkechi"));
//
//    }

    @Test
    void testThatWeCanFindContactsByMobile(){

        //given
        Contact myContact1 = new Contact("lota","dejoi","09043764373");
        Contact myContact2 = new Contact("lota","ade","07054238765");
        //when
        contactRepo.addContact(myContact1);
        contactRepo.addContact(myContact2);

        List <Contact> foundContact = contactRepo.findBy("07054238765") ;
        //assert
        assertEquals(1,foundContact.size());
    }

    @Test
    void testThatWeCanFindContactByLastName(){
        //given
        Contact myContact1 = new Contact("lota","dejoi","09043764373");
        Contact myContact2 = new Contact("lota","ade","07054238765");
        //when
        contactRepo.addContact(myContact1);
        contactRepo.addContact(myContact2);

        List <Contact> foundContact = contactRepo.findBy("dejoi") ;
        //assert
        assertEquals(1,foundContact.size());
    }

//    @Test
//    void testUpdateContact(){
//        //given
//        Contact myContact1 = new Contact("lota","dejoi","09043764373");
//        Contact myContact2 = new Contact("lota","ade","07054238765");
//        //when
//        contactRepo.addContact(myContact1);
//        contactRepo.addContact(myContact2);
//
//        myContact1.setFirstName("igwe");
//        //assert
//        assertEquals(myContact1,contactRepo.findBy("igwe"));
//    }

}