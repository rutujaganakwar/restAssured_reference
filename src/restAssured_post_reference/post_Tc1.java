package restAssured_post_reference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;

import org.testng.Assert;

public class post_Tc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declare base URI
		RestAssured.baseURI="https://reqres.in/";
		
		//configure the request body and resource
		String postresponsebody =given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").when().post("/api/users").then().extract().response().asString();
		System.out.println(postresponsebody);
		
		//create Jsonpath object to extract response body parameter
		JsonPath jsp = new JsonPath(postresponsebody);
		//extract response body parameter
		String res_name =jsp.getString("name");
		System.out.println(res_name);
		
		String res_job =jsp.getString("job");
		System.out.println(res_job);
		
		String res_id =jsp.getString("id");
		System.out.println(res_id);
		
		String res_createdAt =jsp.getString("createdAt");
		//System.out.println(res_createdAt);

		
		//validate response body parameter
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "leader");
		Assert.assertNotEquals(res_id,0);
		
		//date parameter validation
		String actual_date= res_createdAt.substring(0,10);
		System.out.println(actual_date);
		String curr_date= LocalDate.now().toString();
		Assert.assertEquals(actual_date, curr_date);
		
	}

}
