package restAPI;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutRequest {

	@Test
	public void test1() {
		

		RestAssured.baseURI="http://localhost:3000/employees/";
		Map<String, Object> mapobject=new HashMap<String, Object>();
		mapobject.put("name", "Anuja");
		mapobject.put("salary", "50000");
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(mapobject)
				.put("/4");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 200);

		JsonPath Jpath =response.jsonPath();
		System.out.println("id"+Jpath.get("id"));

	}
}
