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
    private String userName,userNameEdited;
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
    @Story("PUT Request with UserID")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify update user by userID")
    @Test(description = "Update user by userID",priority = 3)
    public void TC04_VerifyUpdateUserByUserID() {
        CreateUserPOJO createUserPOJO = CreateUserPOJO_Builder.getUserData();
        Response response = ApiKeyword.put(EndPoints.EP_CREATE_USER+"/"+ userID,createUserPOJO);
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
        verifyEquals(ApiKeyword.getResponseKeyValue(response, "response.username"),createUserPOJO.getUsername());
        //Assert.assertEquals(ApiKeyword.getResponseKeyValue(response, "response.username"), createUserPOJO.getUsername());
        userNameEdited = ApiKeyword.getResponseKeyValue(response,"response.username");
    }
    @Story("DELETE Request with username")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify delete user by username")
    @Test(description = "Delete user by userID",priority = 4)
    public void TC05_VerifyDeleteUserByUsername() {
        Map<String, String> params = new HashMap<>();
        params.put("username", userNameEdited);
        Response response = ApiKeyword.delete(EndPoints.DELETE_URL,params);
        ApiKeyword.verifyStatusCode(response, StatusCode.CODE_200);
    }

    // sửa test rebase
}

