package testcases.users;

import commons.ApiKeyword;
import commons.globals.EndPoints;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testcases.common.BaseTest;

public class GetUsers extends BaseTest {
    @Test(priority = 1)
    public void TC01_GetAllUser(){
        Response response = ApiKeyword.get(EndPoints.EP_GET_ALL_USER);
        ApiKeyword.verifyStatusCode(response,200);
    }
}

