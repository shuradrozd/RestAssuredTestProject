package tests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RootClass {

    protected Response getResponse(String endName) {
        Response response =
                given().
                        when().
                        get(endName);
        return response;
    }
}
