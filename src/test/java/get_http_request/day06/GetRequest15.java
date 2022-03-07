package get_http_request.day06;

import base_url.GMIBankBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest15 extends GMIBankBaseUrl {

    //https://www.gmibank.com/api/tp-customers/85694
    //        "id": 85694,
    //    "firstName": "Winona",
    //    "lastName": "Abernathy",
    //    "middleInitial": "S",
    //    "email": "winonaabernathy@gmail.com",
    //    "mobilePhoneNumber": "222-230-1890",
    //    "phoneNumber": "271-169-8836",
    //    "zipCode": "09848-7861",
    //    "address": "1956 Hackett Mission",
    //    "city": "Fairfax",
    //    "ssn": "779-99-4600",
    //    "createDate": "2021-03-03T06:00:00Z",
    //    "zelleEnrolled": false,
    //    "country": {
    //        "id": 3,
    //        "name": "USA",
    //        "states": null

    @Test
    public void test15(){

        spec03.pathParams("bir", "tp-customers", "iki", "85694");

        //http://www.gmibank.com/api
        Response response = given()
                .spec(spec03)
                .header("Authorization", "Bearer " + generateToken())
                .when().get("/{bir}/{iki}");

        response.prettyPrint();

        //Matcher Class

        response.then().body("user.login", equalTo("dino.kohler"),
                                "user.firstName", equalTo("Winona"),
                                "user.lastName", equalTo("Abernathy"),
                                "user.email", equalTo("winonaabernathy@gmail.com"));

        //JSON PATH
        JsonPath json = response.jsonPath();
        Assert.assertEquals("dino.kohler", json.get("user.login"));
        Assert.assertEquals("Winona", json.get("firstName"));
        Assert.assertEquals("Abernathy", json.get("lastName"));
        Assert.assertEquals("winonaabernathy@gmail.com", json.get("email"));






    }
}
