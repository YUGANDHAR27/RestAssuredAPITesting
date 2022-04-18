package sampleRestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;

public class JsonSchemaValidator
{
	@Test
	public void jsonSchemaVaidation()
		{

			given().get("https://reqres.in/api/users/2").then().assertThat()
            .body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);

		}
}
