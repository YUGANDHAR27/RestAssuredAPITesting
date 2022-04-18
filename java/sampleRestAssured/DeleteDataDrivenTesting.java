package sampleRestAssured;

import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DeleteDataDrivenTesting 
{

	@DataProvider(name = "Delete")
	public Object[] dataforPOST()
	{
		return new Object[] {
				126,497

		};


	}
	@Test(dataProvider = "Delete")
	public void test_DELETE(int userID) 
	{
		when()
		.delete("https://reqres.in/api/users/"+userID)
		.then()
		.statusCode(204).log().all();




	}

}
