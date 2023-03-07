package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TestExample extends RootClass {

    @Test(description = "Проверка получения email у пользователей")
    public void testStart() {


        Response response = getResponse("https://gorest.co.in/public/v2/users");
        List<String> email = response.path("findAll {it}.email");
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getTime());
        System.out.println(response.getHeader("content-type"));
        assertEquals(email.size(), 10);
        assertEquals(response.statusCode(), 200);
    }


}
