package test_data;

import org.json.JSONObject;

import java.util.HashMap;

public class HerOkuAppTestData {

    // https://restful-booker.herokuapp.com/booking/47
    //       {
    //           "firstname": "Ali",
    //           "lastname": "Can",
    //           "totalprice": 500,
    //           "depositpaid": true,
    //           "bookingdates": {
    //                               "checkin": "2022-02-01",
    //                              "checkout": "2022-02-11"
    //          }
    //       }

    public HashMap<String, Object> setUpTestData() {

        HashMap<String, Object> bookingDates = new HashMap<>();
        bookingDates.put("checkin", "2022-03-01");
        bookingDates.put("checkout", "2022-03-11");

        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname ", "Ali");
        expectedData.put("lastname ", "Can");
        expectedData.put("totalprice ", 500);
        expectedData.put("depositpaid ", true);
        expectedData.put("bookingdates", bookingDates); // map in ismini yazdik  ==> bookindate in altında ıkı altdal var onları burda yaptık

        return expectedData;


            /*
   https://restful-booker.herokuapp.com/booking
   { "firstname": "Ali",
              "lastname": "Can",
              "totalprice": 500,
              "depositpaid": true,
              "bookingdates": {
                  "checkin": "2022-03-01",
                  "checkout": "2022-03-11"
               }
*/

    }

    public JSONObject setUpTestAndRequestData() {
        JSONObject bookingdates = new JSONObject();
        bookingdates.put("checkin", "2022-03-01");
        bookingdates.put("checkout", "2022-03-11");

        JSONObject expectedRequest = new JSONObject();
        expectedRequest.put("firstname", "Ali");
        expectedRequest.put("lastname", "Can");
        expectedRequest.put("totalprice", 500);
        expectedRequest.put("depositpaid", true);
        expectedRequest.put("depositpaid", bookingdates);

        return expectedRequest;






    }

}
