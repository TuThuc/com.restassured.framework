package com.demoproject.pojo.data;

import com.demoproject.pojo.RegisterUserPOJO;
import net.datafaker.Faker;

import java.util.Locale;

public class RegisterUserPOJO_Builder {
    public static RegisterUserPOJO getUserData() {
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
