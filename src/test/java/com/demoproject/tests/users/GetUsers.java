package com.demoproject.tests.users;

import com.demoproject.common.BaseTest;
import com.demoproject.globals.StatusCode;
import com.demoproject.keywords.ApiKeyword;
import com.demoproject.globals.EndPoints;
import com.demoproject.pojo.CreateUserPOJO;
import com.demoproject.pojo.data.CreateUserPOJO_Builder;
import com.demoproject.ultilities.LogUtils;
import com.google.gson.Gson;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

@Epic("REST API Regression Testing using TestNG")
@Feature("Verify CRUID Operations on User module")
public class GetUsers extends BaseTest {
    private int userID;
    private String userName;
    @Test(description = "To get the details of all user", priority = 0)
    @Story("GET Request with All User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of list all user")
    public void TC01_VerifyGetAllUser(){
        Response response = ApiKeyword.get(EndPoints.EP_GET_ALL_USER);
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
    }
    @Test(description = "To create new user ", priority = 1)
    @Story("Post Request with Create User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify create new user")
    public void TC02_VerifyCreateNewUser(){
        CreateUserPOJO createUserPOJO = CreateUserPOJO_Builder.getUserData();
        Gson gson = new Gson();
        Response response = ApiKeyword.postWithPayload(EndPoints.EP_CREATE_USER, gson.toJson(createUserPOJO));
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
        userID = Integer.parseInt(ApiKeyword.getResponseKeyValue(response,"response.id"));
        userName = ApiKeyword.getResponseKeyValue(response,"response.username");

    }

    @Story("Get Request with UserName")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify get user by username")
    @Test(description = "Get user by username",priority = 2)
    public void TC03_VerifyGetUserByUserName() {
        Map<String, String> params = new HashMap<>();
        params.put("username", userName);
        Response response = ApiKeyword.get(EndPoints.EP_CREATE_USER , params);

        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);

        Assert.assertEquals(ApiKeyword.getResponseKeyValue(response, "response.username"), userName);
    }
    @Story("PUT Request with UserName")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify update user by username")
    @Test(description = "Update user by username",priority = 3)
    public void TC04_VerifyUpdateUserByUserID() {
        String dataFile = "src/test/resources/testdata/EditUser.json";
        Response response = ApiKeyword.putWithFile(EndPoints.EP_UPDATE_USER,dataFile, userID);
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
    }
}

