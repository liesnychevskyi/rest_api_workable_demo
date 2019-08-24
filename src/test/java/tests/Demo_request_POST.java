package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_request_POST
{
    @Test
    void registrationSuccessful()
    {
        //--------------------------------------------------------------------------//
        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/customer";

        // It means witch kind request specification (request object)
        RequestSpecification httpRequest = RestAssured.given();

        //Response object of POST request
        //(Request payload sending along with post request)
        JSONObject requastParams = new JSONObject(); // Json object
        requastParams.put("FirstName", "Srtavcvfvcvrxyz");  // Putting parameters to JSON body
        requastParams.put("LastName", "Gorotocvrowww");// Putting parameters to JSON body
        requastParams.put("UserName", "Srojsdl"); // Putting parameters to JSON body
        requastParams.put("Password", "stfgfan12345"); // Putting parameters to JSON body
        requastParams.put("Email", "emailvv123@gmail.com"); // Putting parameters to JSON body

        httpRequest.header("Content-Type", "application/json"); //header specification of type
        httpRequest.body(requastParams.toJSONString()); // Attach above data to the request

        //(Response object) it will send and stored into the variable
        Response response = httpRequest.request(Method.POST, "/register");
        //---------------------------------------------------------------------------------//
        //Validation part
        //----------------------------------------------------------------------------------//
        //Converting into the string from the JSON and printing the response
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 201); // validation

        // We take data from the response body and validate
        String successCode = response.jsonPath().get("SuccessCode");
        System.out.println("Success code is:  " + successCode);
        Assert.assertEquals(successCode, "OPERATION_SUCCESS");
        //-----------------------------------------------------------------------------------//


    }
}
