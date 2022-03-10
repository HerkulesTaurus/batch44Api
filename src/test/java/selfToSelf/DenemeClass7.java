package selfToSelf;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class DenemeClass7 extends DummyBaseUrl {

    @Test
    public void test7(){

        // URL OLUSTUR
        // http://dummy.restapiexample.com/api/v1/employees

        spec02.pathParams("1", "api", "2", "v1","3","employees");

        Response response = given().spec(spec02).when().get("/{1}/{2}/{3}");

        // 1) Status kodunun 200,
        Assert.assertEquals(200, response.statusCode());
        response.then().assertThat().statusCode(200);

        // 2) 10’dan büyük tüm id'leri ekrana yazdırın ve 10’dan büyük 14 id olduğunu,

        JsonPath json = response.jsonPath();

        List<Integer> idList = json.getList("data.findAll{it.id>10}.id");
        System.out.println("ID List" + idList);

        // 3) 30’dan küçük tüm yaşları ekrana yazdırın ve bu yaşların içerisinde en büyük yaşın 23 olduğunu

        // 4) Maası 350000 den büyük olan tüm employee name'leri ekrana yazdırın

        //     ve bunların içerisinde "Charde Marshall" olduğunu test edin

    }
}

