package Trial;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class TrialAndError {
	@Test
	public void test_2()
	{
		baseURI="https://reqres.in/api";
		given().
		get("/users?page=2").
		then().
		statusCode(200);
	}

}
