package commons;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payloads.User;

import static io.restassured.RestAssured.given;

public class ApiKeyword {
    public static Response createUser(User payload) {
        Response res = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(EndPoints.POST_URL);
        return res;
    }

    public static Response readUser(String userName, User payload) {
        Response res = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", userName)
                .body(payload)
                .when()
                .get(EndPoints.UPDATE_URL);
        return res;
    }

    public static Response updateUser(String userName) {
        Response res = given()
                .pathParam("username", userName)
                .when()
                .put(EndPoints.GET_URL);
        return res;
    }

    public static Response deleteUser(String userName) {
        Response res = given()
                .pathParam("username", userName)
                .when()
                .delete(EndPoints.DELETE_URL);
        return res;
    }

}
