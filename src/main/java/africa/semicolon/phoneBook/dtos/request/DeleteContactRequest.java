package africa.semicolon.phoneBook.dtos.request;

import lombok.Data;

@Data

public class DeleteContactRequest {

    private String firstName;
    private String mobile;
}
