package testcases;

import commons.ApiKeyword;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.User;

import java.util.Locale;

public class UserTest {
    Faker faker;
    User userPayload;
    @BeforeClass
    public void setupData(){
        faker = new Faker(new Locale("vi"));
userPayload = new User();
userPayload.setId(faker.idNumber().hashCode());
userPayload.setUserName(faker.name().name());
userPayload.setFirstName(faker.name().firstName());
userPayload.setLastName(faker.name().lastName());
userPayload.setEmail(faker.internet().safeEmailAddress());
userPayload.setPassword(faker.internet().password(5,10));
userPayload.setPhone(faker.phoneNumber().cellPhone());
    }
    @Test(priority = 1)
    public void testPostUser(){
        Response rs = ApiKeyword.get(userPayload);
        rs.then().log().all();
        Assert.assertEquals(rs.getStatusCode(),200);
    }
}

