package com.demoproject.tests.users;

import com.demoproject.common.BaseTest;
import com.demoproject.globals.StatusCode;
import com.demoproject.keywords.ApiKeyword;
import com.demoproject.globals.EndPoints;
import com.demoproject.pojo.RegisterUserPOJO;
import com.demoproject.pojo.data.RegisterUserPOJO_Builder;
import com.google.gson.Gson;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
@Epic("REST API Regression Testing using TestNG")
@Feature("Verify CRUID Operations on User module")
public class GetUsers extends BaseTest {
    @Test(description = "To get the details of all user", priority = 0)
    @Story("GET Request with All User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of list all user")
    public void TC01_VerifyGetAllUser(){
        Response response = ApiKeyword.get(EndPoints.EP_GET_ALL_USER);
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
    }
    @Test(description = "To create new user ", priority = 0)
    @Story("Post Request with Create User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify create new user")
    public void TC02_VerifyCreateNewUser(){
        RegisterUserPOJO registerUserPOJO = RegisterUserPOJO_Builder.getUserData();
        Gson gson = new Gson();
        Response response = ApiKeyword.post(EndPoints.EP_CREATE_USER,gson.toJson(registerUserPOJO));
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
    }

}

