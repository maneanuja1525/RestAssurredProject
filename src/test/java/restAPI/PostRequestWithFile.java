package restAPI;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostRequestWithFile {

	@Test
	public void test1() throws IOException {
		

		RestAssured.baseURI="http://localhost:3000/employees/";
		byte[] databytes=Files.readAllBytes(Paths.get("data.json"));
		
		RequestSpecification request=RestAssured.given();
		Response response=request.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(databytes)
				.post("/create");

		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);

		int ResponseCode = response.getStatusCode();
		Assert.assertEquals(ResponseCode, 201);

		JsonPath Jpath =response.jsonPath();
		System.out.println("id"+Jpath.get("id"));
	}

}
