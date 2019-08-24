package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_request_GET
{
    @Test
    void getWeatherDetails()
    {
        //--------------------------------------------------------------------------//
        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

        // It means witch kind request specification (request object)
        RequestSpecification httpRequest = RestAssured.given();

        //(Response object) it will send and stored into the variable
        Response response = httpRequest.request(Method.GET, "/Moscow");

        //Converting into the string from the JSON and printing the response
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200); // validation

        //Status line verification
        String statusLine = response.getStatusLine();
        System.out.println("Status line is: " + statusLine);
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK"); // validation
        //------------------------------------------------------------------------//


    }
}
