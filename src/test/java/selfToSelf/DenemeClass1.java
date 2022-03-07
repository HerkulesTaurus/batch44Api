package selfToSelf;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DenemeClass1 {

    @Test
    public void test09(){

        String url="https://restful-booker.herokuapp.com/booking/2";

        Response response = given().when().get(url);

        response.prettyPeek();

        response.prettyPrint();

        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(200).
                statusLine("HTTP/1.1 200 OK");

        response.
                then().
                assertThat().
                body("firstname", equalTo("Jim"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(569),
                        "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2019-11-30"),
                        "bookingdates.checkout", equalTo("2020-11-23"));

        response.then().assertThat().
                headers("Server", equalTo("Cowboy"),
                        "Connection", equalTo("keep-alive"),
                        "X-Powered-By", equalTo("Express"),
                        "Content-Type", equalTo("application/json; charset=utf-8"),
                        "Content-Length", equalTo(169),
                        "Etag", equalTo("W/'a9-nhWU32KAniJyg17Jj/lhrzZtg+Q'"),
                        "Via", equalTo("1.1 vegur"));


    }
}
