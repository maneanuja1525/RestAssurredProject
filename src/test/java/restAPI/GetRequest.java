package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequest {

	@Test
	public void Test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees/";
		RequestSpecification request=RestAssured.given();
		Response response=request.get();
		String ResponseBody=response.getBody().asString();
		System.out.println(ResponseBody);
		int ResponseCode=response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);
		
		
		
	}
}
