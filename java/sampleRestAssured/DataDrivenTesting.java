package sampleRestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class DataDrivenTesting 
{
	//@DataProvider(name = "DataforPost")
	public Object[][] dataforPOST()
	{
		return new Object[][] {
			{"Sandy","kooli"},
			{"kiran" , "mestri"}
			
		};
				    
	
	}
	//@Test(dataProvider = "DataforPost")
	public void test_POST(String name , String Job)
	{
		//creating the body in json format using java map
		//      Map<String, Object>	map= new HashMap<String, Object>();
		//      map.put("\"name\"", "yugandhar");
		//      map.put("\"job\"", "Software");
		//      System.out.println(map);
		JSONObject request= new JSONObject();
		request.put("name", name);
		request.put("job", Job);
		//System.out.println(request);	
		System.out.println(request.toJSONString());
		
		given()
		.header("Content-Tyep","application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201).log().all();


	}
	
		
		}		    
		
	
	
		
	
 

