package testcases.common;

import com.google.gson.Gson;
import commons.ApiKeyword;
import commons.globals.ConfigsGlobal;
import commons.globals.EndPoints;
import commons.globals.TokenGlobal;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import pojo.LoginPOJO;
import pojo.data.LoginPOJO_Builder;

public class BaseTest {
    @BeforeTest
    public void loginUser() {
        LoginPOJO loginPOJO = LoginPOJO_Builder.getDataLogin();

        Gson gson = new Gson();
        Response response = ApiKeyword.postNotq
        Auth(EndPoints.EP_LOGIN, gson.toJson(loginPOJO));
        response.then().statusCode(200);

        TokenGlobal.TOKEN = response.getBody().path("token");
        System.out.println("Token Global: " + TokenGlobal.TOKEN);
    }
}
