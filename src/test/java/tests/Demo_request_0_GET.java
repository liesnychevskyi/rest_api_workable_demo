package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_request_0_GET
{
    @Test
    void googleMapTest()
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
        //Converting into the string from the JSON and printing the response
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        //Capture details of headers from response
        //===================================================================================//
        String contentType = response.header("Content-Type"); // Capturing details of Content-Type
        System.out.println("Content_Type is:  " + contentType);
        Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

        String contentEncoding = response.header("Content-Encoding"); // Capturing details of Content-Encoding
        System.out.println("Content_Encoding is:  " + contentEncoding);
        Assert.assertEquals(contentEncoding, "gzip");

        //etc...
        //-----------------------------------------------------------------------------------//

    }
}