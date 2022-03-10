package get_http_request.day09;

import base_url.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class GetRequest21TestData extends JsonPlaceHolderBaseUrl {

    // https://jsonplaceholder.typicode.com/todos/2
    // 1) Status kodunun 200,
    // 2) respose body'de,
    //         "completed": değerinin false
    //         "title": değerinin "quis ut nam facilis et officia qui"
    //         "userId" sinin 1 ve
    //    header değerlerinden
    //         "via" değerinin "1.1 vegur" ve
    //         "Server" değerinin "cloudflare" olduğunu test edin…


    @Test
    public void test21(){

        // 1- URL OLUSTUR
        spec04.pathParams("1","todos","2", 2);

        // 2- EXPECTED DATA OLUSTUR
        JsonPlaceHolderTestData expectedDataObje =new JsonPlaceHolderTestData();
        HashMap<String, Object> expectedData = (HashMap<String, Object>) expectedDataObje.setUpTestData();
        System.out.println(("TETS DATANİN İCİNDEKİ EXPECTED DATA :"+expectedData));

        // 3- REQUEST VE RESPONSE

        Response response = given().spec(spec04).when().get("/{1}/{2}");
        response.prettyPrint();

        // 4- DOGRULAMA

        // 1. YOL METCHERS CLASS
        response.then().assertThat().statusCode((Integer) expectedData.get("statusCode"));


    }

}
