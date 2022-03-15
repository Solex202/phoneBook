package africa.semicolon.phoneBook.controllers;

import africa.semicolon.phoneBook.dtos.request.AddContactRequest;
import africa.semicolon.phoneBook.dtos.request.DeleteContactRequest;
import africa.semicolon.phoneBook.dtos.response.AddContactResponse;
import africa.semicolon.phoneBook.dtos.response.DeleteContactResponse;
import africa.semicolon.phoneBook.services.ContactService;
import africa.semicolon.phoneBook.services.ContactServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController

@RequestMapping("/contact")
public class ContactController {
 private ContactService service = new ContactServiceImpl();

 @PostMapping("/save")
    public AddContactResponse response(@RequestBody  AddContactRequest request) {
     return service.save(request);
 }

//@DeleteMapping("/{id}")
//    public DeleteContactResponse response(@RequestBody DeleteContactRequest request) {
//    if(Objects.equals(service.delete(request).getResponse(), "delete successful"))
//    return service.delete(request);
//    else return
//}

//@GetMapping
}
