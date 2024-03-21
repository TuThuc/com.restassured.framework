package com.demoproject.pojo;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class RegisterUserPOJO {
    private  String username;
    private  String firstName;
    private  String lastName;
    private  String email;
    private  String password;
    private  String phone;
    private  int userStatus;

}
