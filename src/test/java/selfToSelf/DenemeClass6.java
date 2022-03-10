package selfToSelf;

import base_url.DummyBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class DenemeClass6 extends DummyBaseUrl {

    // http://dummy.restapiexample.com/api/v1/employees
    // url ine bir istek gönderildiğinde,
    // status kodun 200,
    // gelen body de,
    // 6. çalışanın isminin "Brielle Williamson" olduğunu ,
    // 17. çalışanın maaşının "725000" olduğunu ,
    // Toplam 24 tane çalışan olduğunu,
    // "Rhona Davidson" ın employee lerden biri olduğunu
    // "21", "23", "61" yaşlarında employeeler olduğunu test edin
    // JSONPATH KULLARAK

    @Test
    public void test06(){

        spec02.pathParams("first","api",
                     "second","v1",
                             "third","employees");

        Response response = given().spec(spec02).when().get("/{first}/{second}/{third}");

        response.prettyPrint();


        JsonPath json = response.jsonPath();

        Assert.assertEquals(200, response.statusCode());

        // 6. çalışanın isminin "Rhona Davidson" olduğunu ,

        Assert.assertEquals("Rhona Davidson", json.getString("data[7].employee_name"));

        // 17. çalışanın maaşının "725000" olduğunu ,

        Assert.assertEquals(725000, json.getInt("data[16].employee_salary"));

        // Toplam 24 tane çalışan olduğunu,
        Assert.assertEquals(24, json.getList("data.id").size());

        //"Jena Gaines" ın employee lerden biri olduğunu

        Assert.assertEquals("Garrett Winters", json.getString("data[1].employee_name"));


        // "21", "23", "61" yaşlarında employee ler olduğunu test edin
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(23);
        list.add(61);

        Assert.assertTrue(json.getList("data.employee_age").containsAll(list));

        // 2. yol
        List<Integer> ages = Arrays.asList(21,23,61);
        Assert.assertTrue(json.getList("data.employee_age").containsAll(ages));
    }
}
