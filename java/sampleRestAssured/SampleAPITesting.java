package sampleRestAssured;



import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

import org.json.simple.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SampleAPITesting 
{
	//@Test
	void Test_01() 
	{
		Response response =get("https://reqres.in/api/users?page=2");
		System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode, 200);		
	}
	//@Test
	void Test_02()
	{
		given().get("https://reqres.in/api/users?page=2").then().log().all().body("data.id[0]", equalTo(7)).
		body("data.email", hasItem("michael.lawson@reqres.in")).statusCode(200);

	}
	//@Test
	public void test_POST()
	{
		//creating the body in json format using java map
		//      Map<String, Object>	map= new HashMap<String, Object>();
		//      map.put("\"name\"", "yugandhar");
		//      map.put("\"job\"", "Software");
		//      System.out.println(map);
		JSONObject request= new JSONObject();
		request.put("name", "yugandhar");
		request.put("job", "Software");
		//System.out.println(request);	
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Tyep","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201);


	}
	//@Test
	public void test_PUT() 
	{
		JSONObject request= new JSONObject();
	request.put("name", "yugandhar");
	request.put("job", "Software");
	//System.out.println(request);	
	System.out.println(request.toJSONString());
	
	given()
	.header("Content-Tyep","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(request.toJSONString())
	.when()
	.put("https://reqres.in/api/users/2")
	.then()
	.statusCode(200).log().all();



		
	}
	//@Test
	public void test_PATCH() 
	{
		JSONObject request= new JSONObject();
	request.put("name", "yugandhar");
	request.put("job", "Software");
	//System.out.println(request);	
	System.out.println(request.toJSONString());
	
	given()
	.header("Content-Tyep","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(request.toJSONString())
	.when()
	.patch("https://reqres.in/api/users/2")
	.then()
	.statusCode(200).log().all();



		
	}
	//@Test
	public void test_DELETE() 
	{
	when()
	.delete("https://reqres.in/api/users/2")
	.then()
	.statusCode(204).log().all();



		
	}

	
	}





