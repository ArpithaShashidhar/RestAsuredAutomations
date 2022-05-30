package Test1;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAndPostExamples {
	
	@Test
	public void testGet()
	{
		
		baseURI="https://reqres.in/api" ;
		
				given().
			    get("/users?page=2").
				then().
				statusCode(200).
				body("data[4].first_name", equalTo("George")).
				body("data.first_name", hasItems("George","Rachel"));
	}
	
	@Test
	public void testPost()
	{
		Map<String, Object> map=new HashMap<String, Object>();
		
		map.put("name", "Arpitha");
		map.put("Job", "Test Lead");
		
		//System.out.println(map);
				
		JSONObject request=new JSONObject(map);
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api" ;
				
		
		given().
	  header("Content-Type","application/json").
	  contentType(ContentType.JSON).
	  accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
		
		
	}
	

}
