package com.demoproject.pojo.data;

import com.demoproject.pojo.CreateUserPOJO;
import net.datafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class CreateUserPOJO_Builder {
    public static CreateUserPOJO getUserData() {
        Faker faker = new Faker(new Locale("vi"));
        String phoneNumber = faker.phoneNumber().cellPhone();
        phoneNumber = phoneNumber.replace(" ", "");


        return CreateUserPOJO.builder()
                .username(faker.name().username())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .phone(phoneNumber)
                .password("Demo@123")
                .email(faker.internet().emailAddress())
                .userStatus(1)
                .build();
    }
}
