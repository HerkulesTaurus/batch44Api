package get_http_request.day11;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import test_data.DummyTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class PostRequest02 extends DummyBaseUrl {

    //1. islem DummyTestData class ında method ları request ve response u tanımladık

    /* http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
    {
        "name":"Ali Can",
        "salary":"2000",
        "age":"40",
     }
     gönderildiğinde,

     Status kodun 200 olduğunu ve dönen response body nin,
     {
        "status": "success",
        "data": {
        "id":…
     },
        "message": "Successfully! Record has been added."
     }

     olduğunu test edin */


    @Test
    public void test02(){
        // 1- URL OLUSTUR
        spec02.pathParams("bir", "api","iki", "v1", "uc","create");
        
                
        // 2- EXPECTED DATA
        DummyTestData obje = new DummyTestData();
        
        // REQUEST icin
        HashMap<String, Object> requestBoddyMap = obje.setUpRequestBody();
        
        // EXPECTEDDATA icin  
        HashMap<String, Object> expectedDataMap = obje.setUpExpectedData();
        System.out.println("expectedDataMap = " + expectedDataMap);
        
        // 3- REQUEST VE RESPONSE
        Response response = given().accept(ContentType.JSON)
                .spec(spec02)
                .body(requestBoddyMap)
                .when()
                .post("/{bir}/{iki}/{uc}");

        // POST isleminde Map kullandigimizda toString'e gerek yok
        // toString sadece JSONObject de kullaniliyor
        response.prettyPrint();

        // 4- DOGRULAMA
        
        // DE-Serialization
        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println("actualDataMap = " + actualDataMap);

        Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());

        Assert.assertEquals(expectedDataMap.get("status"), actualDataMap.get("status"));
        Assert.assertEquals(expectedDataMap.get("message"), actualDataMap.get("message"));

        // JSON PATH

        JsonPath json = response.jsonPath();

        Assert.assertEquals(expectedDataMap.get("statusCode"), response.getStatusCode());

        Assert.assertEquals(expectedDataMap.get("status"), json.getString("status"));
        Assert.assertEquals(expectedDataMap.get("message"), json.getString("message"));





    }
}
