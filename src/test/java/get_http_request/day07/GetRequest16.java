package get_http_request.day07;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class GetRequest16 extends JsonPlaceHolderBaseUrl {

    //   https://jsonplaceholder.typicode.com/todos/7
    //
    //   {
    //   "userId": 1,
    //   "id": 7,
    //   "title": "illo expedita consequatur quia in",
    //   "completed": false
    //}

    @Test
    public void test16() {

        // 1- URL Olusturma
        spec04.pathParams("bir","todos", "iki", 7);

        //2- Expected(Beklenen) Data Olusturma
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 1);
        expectedData.put("id", 7);
        expectedData.put("title", "illo expedita consequatur quia in");
        expectedData.put("completed", false);

        System.out.println("Expected Data :"+ expectedData);
        // Expected Data: {id=7, completed=false, title=illo expedita consequatur quia in, userId=1}


        //3- Request ve Response
        // https://jsonplaceholder.typicode.com
        Response response = given().spec(spec04).when().get("/{bir}/{iki}");
        // "/{bir}/{iki}" ==> adrese bunu /ekle todos/7
        // https://jsonplaceholder.typicode.com/todos/7

        response.prettyPrint();

        // DATA yı JSON FORMATİ  ==> JAVA'YA De-Serialization
        // DATA yı JAVA'dan      ==> JSON'a Serialization

        Map<String, Object> actualData = response.as(HashMap.class);    //De-Serialization

        System.out.println("ACTUAL DATA :"+ actualData);

        Assert.assertEquals(expectedData.get("userId"), actualData.get("userId"));
        Assert.assertEquals(expectedData.get("id"), actualData.get("id"));
        Assert.assertEquals(expectedData.get("title"), actualData.get("title"));
        Assert.assertEquals(expectedData.get("completed"), actualData.get("completed"));

    }
}
