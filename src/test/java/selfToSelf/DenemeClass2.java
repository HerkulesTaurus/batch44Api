package selfToSelf;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;

public class DenemeClass2 {

    @Test
    public void test02(){

        String url="http://dummy.restapiexample.com/api/v1/employees";

        Response response = given().when().get(url);

        response.prettyPeek();

        response.prettyPrint();

        response.
                then().
                assertThat().
                statusLine("HTTP/1.1 200 OK").
                statusCode(200).
                contentType("application/json");


        response.
                then().
                assertThat().
                body("data", hasSize(24),
                        "data.employee_age", hasItem(23),
                        "data.employee_salary",hasItems(675000,470600,725000));


    }

}
