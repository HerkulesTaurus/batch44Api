package selfToSelf;

import base_url.RegresinBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DenemeClass3 extends RegresinBaseUrl {

    // https://reqres.in/api/users URL request olustur.
    // body icerisindeki idsi 4 olan datayi
    // 1) Matcher CLASS ile
    // 2) JsonPath ile dogrulayin.

    @Test
    public void test01(){

        spec01.pathParams("parametre1","api","parametre2","users");

        Response response = given().spec(spec01).when().get("/{parametre1}/{parametre2}");

        response.prettyPrint();

        response.then().statusCode(200).contentType(ContentType.JSON);

        //Matcher Class
        response.then().assertThat().body("data[3].email", Matchers.equalTo("eve.holt@reqres.in"),
                                     "data[3].first_name", Matchers.equalTo("Eve"),
                                             "data[3].last_name", Matchers.equalTo("Holt"),
                                             "data[3].avatar", Matchers.equalTo("https://reqres.in/img/faces/4-image.jpg"));
        //JsonPath
        JsonPath json = response.jsonPath();

        System.out.println(json.getString("data[3].email"));
        System.out.println(json.getString("data[3].first_name"));
        System.out.println(json.getString("data[3].last_name"));
        System.out.println(json.getString("data[3].avatar"));

        Assert.assertEquals("Eve", json.getString("data[3].first_name"));
        Assert.assertEquals("eve.holt@reqres.in", json.getString("data[3].email"));
        Assert.assertEquals("Holt", json.getString("data[3].last_name"));
        Assert.assertEquals("https://reqres.in/img/faces/4-image.jpg", json.getString("data[3].avatar"));

    }

}
