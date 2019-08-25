package tests;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_request_2_GET_authorization_test
{
    @Test
    public void authorizationTest()
    {
        //-------------------------------------------------------------------------------//
        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/authentication/CheckForAuthentication";
        //-------------------------------------------------------------------------------//
        //Basic authentication
        PreemptiveBasicAuthScheme authScheme = new  PreemptiveBasicAuthScheme();
        authScheme.setUserName("ToolsQA");
        authScheme.setPassword("TestPassword");
        RestAssured.authentication = authScheme; // kind authentication
        //-------------------------------------------------------------------------------//
        // It means witch kind request specification (request object)
        RequestSpecification httpRequest = RestAssured.given();

        //(Response object) it will send and stored into the variable
        Response response = httpRequest.request(Method.GET, "/"); //root //landing page

        //-----------------------------------------------------------------------------------//
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode, 200);
        //----------------------------------------------------------------------------------//
        //Converting into the string from the JSON and printing the response
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);



    }
}
