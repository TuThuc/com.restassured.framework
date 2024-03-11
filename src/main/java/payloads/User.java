package payloads;

import lombok.Data;

@Data
public class User {
    private int id;
   private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;
}
