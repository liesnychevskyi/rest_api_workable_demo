package tests;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_request_1_GET_print_all_headers
{
    @Test
    public void googleGetAllHeaders()
    {
        //--------------------------------------------------------------------------//
        //Specify base URI
        RestAssured.baseURI = "https://maps.googleapis.com";

        // It means witch kind request specification (request object)
        RequestSpecification httpRequest = RestAssured.given();

        //(Response object) it will send and stored into the variable
        Response response = httpRequest.request(Method.GET, "/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
        //---------------------------------------------------------------------------------//
        //Validation part
        //----------------------------------------------------------------------------------//

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        Headers allHeaders = response.headers();  // Capture all the headers  from response in map type

        for(Header header : allHeaders)
        {
            System.out.println(header.getName() + "    " + header.getValue()); // get name and value of header

        }
        //-----------------------------------------------------------------------------------//
    }
}
