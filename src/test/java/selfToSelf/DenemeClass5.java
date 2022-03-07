package selfToSelf;

import base_url.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class DenemeClass5 extends DummyBaseUrl {

    // http://dummy.restapiexample.com/api/v1/employee/12 URL'E GiT.
    // 1) Matcher CLASS ile
    // 2) JsonPath ile dogrulayin.

    @Test
    public void test05(){

        spec02.pathParams("birinci","api",
                     "ikinci","v1",
                             "ucuncu","employee",
                             "dorduncu","12");

        Response response = given().spec(spec02).when().get("/{birinci}/{ikinci}/{ucuncu}/{dorduncu}");

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        //Matcher Class
        response.
                then().
                assertThat().
                body("data.employee_name", Matchers.equalTo("Quinn Flynn"),
                        "data.employee_salary", Matchers.equalTo(342000),
                        "data.employee_age", Matchers.equalTo(22));

        //Json Path

        JsonPath json = response.jsonPath();

        System.out.println(json.getString("data.employee_name"));
        System.out.println(json.getString("data.employee_salary"));
        System.out.println(json.getString("data.employee_age"));


        Assert.assertEquals("Quinn Flynn", json.getString("data.employee_name"));
        Assert.assertEquals(342000, json.getInt("data.employee_salary"));
        Assert.assertEquals(22, json.getInt("data.employee_age"));

    }
}
