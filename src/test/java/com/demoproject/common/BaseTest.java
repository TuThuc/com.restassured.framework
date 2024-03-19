package com.demoproject.common;

import com.demoproject.globals.StatusCode;
import com.demoproject.pojo.LoginPOJO;
import com.demoproject.pojo.data.LoginPOJO_Builder;
import com.google.gson.Gson;
import com.demoproject.keywords.ApiKeyword;
import com.demoproject.globals.EndPoints;
import com.demoproject.globals.TokenGlobal;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    @BeforeTest
    public void loginUser() {
        LoginPOJO loginPOJO = LoginPOJO_Builder.getDataLogin();

        Gson gson = new Gson();
        Response response = ApiKeyword.postNotAuth(EndPoints.EP_LOGIN, gson.toJson(loginPOJO));
      ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);

        TokenGlobal.TOKEN = response.getBody().path("token");
        System.out.println("Token Global: " + TokenGlobal.TOKEN);
    }
}
