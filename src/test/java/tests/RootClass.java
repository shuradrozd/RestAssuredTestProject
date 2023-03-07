package tests;

import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static io.restassured.RestAssured.given;

public class RootClass {
    @BeforeClass
    public static void init() {

        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .build(), System.getProperty("user.dir")
                        + "/target/allure-results/");
    }
    @BeforeTest
    public void setFilter() {
        RestAssured.filters(new AllureRestAssured());
    }
    @Step("Send GET request with [endPointNames: {endPointNames}]")
    protected Response getResponse(String endName) {
        Response response =
                given().
                        when().
                        get(endName);
        return response;
    }
}
