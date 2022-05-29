package restAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	@Test
	public void test1() {
	
		RestAssured.baseURI="http://localhost:3000/employees/";
		RequestSpecification request=RestAssured.given();
		Response response=request.delete("/3");
		String ResponseBody=response.getBody().asString();
		System.out.println(ResponseBody);
		int ResponseCode=response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);
	}
}
