package com.BlzAPI;


import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;;

public class getAPIValdation {
	@Test
	public void validationapispaceX() {
		RestAssured.baseURI = "https://api.spacexdata.com/v4/launches";
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/latest");
		System.out.println("Response Body is =>  " + response.asString());
		Assert.assertEquals(200, response.statusCode());
	}
}
