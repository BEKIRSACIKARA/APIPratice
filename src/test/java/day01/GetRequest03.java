package day01;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest03 {

    /* Matchers ile dataları doğrulayınız
            "id": 5,
            "email": "charles.morris@reqres.in",
            "first_name": "Charles",
            "last_name": "Morris",
            "avatar": "https://reqres.in/img/faces/5-image.jpg"
     */
    @Test
     //Matchers ile dataları doğrulama
    public void test03() {
        String url = "https://reqres.in/api/users";

        Response response = given().when().get(url);
        response.then().body("data[4].email", Matchers.equalTo("charles.morris@reqres.in")
                , "data[4].first_name", Matchers.equalTo("Charles")
                , "data[4].last_name", Matchers.equalTo("Morris")
                , "data[4].avatar", Matchers.equalTo("https://reqres.in/img/faces/5-image.jpg"));


    }
}