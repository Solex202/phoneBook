package africa.semicolon.phoneBook.dtos.request;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Data
public class UpdateContactRequest {


    private String firstName;
    private String lastName;
    private String middleName;
    private String mobile;
    private String office;

}
