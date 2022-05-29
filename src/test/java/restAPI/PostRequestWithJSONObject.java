package restAPI;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithJSONObject {
	
	@Test
	public void test1() {
		
		RestAssured.baseURI="http://localhost:3000/employees/";
		JSONObject jobject=new JSONObject();
		jobject.put("name", "sayali");
		jobject.put("Salary", "20000");
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(jobject.toString())
				.post("/create");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 201);

		JsonPath Jpath =response.jsonPath();
		System.out.println("id"+Jpath.get("id"));
	}
	
}
