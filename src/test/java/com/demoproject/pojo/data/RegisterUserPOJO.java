package com.demoproject.pojo.data;

import net.datafaker.Faker;

import java.util.Locale;

public class RegisterUserPOJO{
public static  RegisterUserPOJO{
    Faker faker = new Faker(new Locale("vi"));
    String phoneNumber = faker.phoneNumber().cellPhone();
    phoneNumber = phoneNumber.replace(" ", "");

        return RegisterUserPOJO.builder()
                .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .phone(phoneNumber)
                .email(faker.internet().emailAddress())
            .userStatus(1)
                .build();
}
}
