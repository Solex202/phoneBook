package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.dtos.request.AddContactRequest;
import africa.semicolon.phoneBook.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBook.dtos.request.UpdateContactRequest;
import africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import africa.semicolon.phoneBook.dtos.response.UpdateContactResponse;
import africa.semicolon.phoneBook.exception.ContactNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ContactServiceImplTest {
    ContactService contactService;
    @BeforeEach
    void beforeEach(){
        contactService = new ContactServiceImpl();
    }

    @Test
    void testThatAContactCanBeAddedToARepo(){
        //given
        AddContactRequest request = new AddContactRequest();
        request.setFirstName("lota");
        request.setLastName("deji");
        request.setMobile("09043545454");
        //when
        contactService.save(request);
        //assert
        assertEquals(1, contactService.getRepository().count());
    }

    @Test
    void testThatCorrectResponse_Is_GottenBack(){
        //given
        AddContactRequest request = new AddContactRequest();
        request.setFirstName("lota");
        request.setLastName("deji");
        request.setMobile("09043545454");
        //when
        AddContactResponse response = contactService.save(request);
        //assert
        assertEquals("lota deji",response.getFullName());
        assertEquals("09043545454",response.getMobile());
    }

    @Test
    void testThatContactCanBeAddedToARepo(){
        //given
        AddContactRequest request1 = new AddContactRequest();
        request1.setFirstName("lota");
        request1.setLastName("deji");
        request1.setMobile("09043545454");
        AddContactResponse response1 = contactService.save(request1);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("adeola");
        request2.setLastName("oladeji");
        request2.setMobile("08023456789");
        AddContactResponse response2= contactService.save(request2);

        //when
        DeleteContactRequest deleteRequest = new DeleteContactRequest();
        deleteRequest.setFirstName("adeola");
        deleteRequest.setMobile("08023456789");

        contactService.delete(deleteRequest);
        assertEquals(1, contactService.getRepository().count());
    }

    @Test
    void testContactCanBeRetrievedByFirstName(){
        //given
        AddContactRequest request1 = new AddContactRequest();
        request1.setFirstName("lota");
        request1.setLastName("deji");
        request1.setMobile("09043545454");

          contactService.save(request1);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("adeola");
        request2.setLastName("oladeji");
        request2.setMobile("08023456789");

        contactService.save(request2);

        AddContactResponse response = contactService.search(request2.getFirstName());
        //assert
        assertEquals("adeola oladeji",response.getFullName());
        assertEquals("08023456789",response.getMobile());
    }

    @Test
    void testContactCanBeRetrievedByLastName(){
        //given
        AddContactRequest request1 = new AddContactRequest();
        request1.setFirstName("lota");
        request1.setLastName("deji");
        request1.setMobile("09043545454");
        contactService.save(request1);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("adeola");
        request2.setLastName("oladeji");
        request2.setMobile("08023456789");
        contactService.save(request2);

        AddContactResponse response = contactService.search(request2.getLastName());
        //assert
        assertEquals("adeola oladeji",response.getFullName());
        assertEquals("08023456789",response.getMobile());
    }

    @Test
    void testContactCanBeRetrievedByMobile(){
        //given
        AddContactRequest request1 = new AddContactRequest();
        request1.setFirstName("lota");
        request1.setLastName("deji");
        request1.setMobile("09043545454");

        contactService.save(request1);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("adeola");
        request2.setLastName("oladeji");
        request2.setMobile("08023456789");

        contactService.save(request2);

        AddContactResponse response = contactService.search(request2.getMobile());
        //assert
        assertEquals("adeola oladeji",response.getFullName());
        assertEquals("08023456789",response.getMobile());
    }

    @Test
    void testContactNotFoundException(){
        //given
        AddContactRequest request1 = new AddContactRequest();
        request1.setFirstName("lota");
        request1.setLastName("deji");
        request1.setMobile("09043545454");

        contactService.save(request1);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("adeola");
        request2.setLastName("oladeji");
        request2.setMobile("08023456789");

        contactService.save(request2);
        //assert
        assertThrows(ContactNotFoundException.class, ()-> contactService.search("fumi"));
    }

    @Test
    void UpdateContactTest(){
        //given
        AddContactRequest request1 = new AddContactRequest();
        request1.setFirstName("lota");
        request1.setLastName("deji");
        request1.setMobile("09043545454");

        contactService.save(request1);

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("adeola");
        request2.setLastName("oladeji");
        request2.setMobile("08023456789");

        contactService.save(request2);

        UpdateContactRequest updateRequest = new UpdateContactRequest();
        updateRequest.setFirstName("daami");
        updateRequest.setLastName("johnson");
        contactService.editContact(updateRequest);
      UpdateContactResponse updateResponse = new UpdateContactResponse();
      //assert
        assertEquals("contact updated", updateResponse.getMessage());
    }

}
