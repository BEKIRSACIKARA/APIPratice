package day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Accounts;
import pojos.Customer;
import pojos.User;
import utilities.GMIBankBaseURL;
import utilities.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static javax.swing.text.DefaultStyledDocument.ElementSpec.ContentType;

public class GetRequest09 extends GMIBankBaseURL {
    /*
    https://www.gmibank.com/api/tp-customers/59511
    {
        "id": 59511,
        "firstName": "ismail",
        "lastName": "özk",
        "middleInitial": "a",
        "email": "ismailoezkan93@gmail.com",
        "mobilePhoneNumber": "111-111-1115",
        "phoneNumber": "123-456-7891",
        "zipCode": "16",
        "address": "schweiz",
        "city": "adana",
        "ssn": "398-56-4356",
        "createDate": "2020-10-20T22:00:00Z",
        "zelleEnrolled": true,
        "country": null,
        "state": "",
        "user": {
            "id": 58645,
            "login": "ismail16",
            "firstName": "LadyGaga",
            "lastName": "TeamTryCatch",
            "email": "ismailoezkan93@gmail.com",
            "activated": true,
            "langKey": "en",
            "imageUrl": null,
            "resetDate": null
        },
        "accounts": []
    }
     */
    @Test
    public void test01() {
        //set the url
        spec01.pathParams("first", "tp-customers", "second", 59511);
        //set the expectedData
        Accounts accounts = new Accounts();
        User userpojo = new User(58645, "ismail16", "LadyGaga", "TeamTryCatch", "ismailoezkan93@gmail.com", true, "en", null, null);
        Customer expectedData = new Customer(59511, "ismail", "özk", "a", "ismailoezkan93@gmail.com", "111-111-1115", "123-456-7891", "16",
                "schweiz", "adana", "398-56-4356", "2020-10-20T22:00:00Z", true, null, "", userpojo,accounts);
        System.out.println("expectedData = " + expectedData);

//  send the request and get the result
        Response response = given().spec(spec01).headers("Authorization", "Bearer " + generateToken()).
                when().get("/{first}/{second}");
        response.prettyPrint();

// Do assertio
        Customer actualData = response.as(Customer.class);
        System.out.println("actualData = " + actualData);

    }
}