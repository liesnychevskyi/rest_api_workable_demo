package tests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Demo_request_captureAllBody {
    @Test
    void googleValidateJsonRequest() {
        //-------------------------------------------------------------------------------//
        //Specify base URI
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

        // It means witch kind request specification (request object)
        RequestSpecification httpRequest = RestAssured.given();

        //(Response object) it will send and stored into the variable
        Response response = httpRequest.request(Method.GET, "/Delhi");
        //----------------------------------------------------------------------------------//
        //Converting into the string from the JSON and printing the response
        String responseBody = response.getBody().asString();
        System.out.println("Response body is: " + responseBody);
        //-----------------------------------------------------------------------------------//

        JsonPath jsonPath = response.jsonPath(); // Capture json body

        // get value
        System.out.println(jsonPath.get("City"));
        System.out.println(jsonPath.get("Temperature"));
        System.out.println(jsonPath.get("Humidity"));
        System.out.println(jsonPath.get("WeatherDescription"));
        System.out.println(jsonPath.get("WindSpeed"));
        System.out.println(jsonPath.get("WindDirectionDegree"));
        // validate value
        Assert.assertEquals(jsonPath.get("Temperature"), "30.18 Degree celsius");
        Assert.assertEquals(jsonPath.get("Temperature"), "");
        Assert.assertEquals(jsonPath.get("Temperature"), "");
        Assert.assertEquals(jsonPath.get("Temperature"), "");


    }
}