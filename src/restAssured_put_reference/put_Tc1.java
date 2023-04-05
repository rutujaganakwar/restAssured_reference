package restAssured_put_reference;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

import java.time.LocalDate;

import org.testng.Assert;

public class put_Tc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare base URI
		RestAssured.baseURI="https://reqres.in/";
		
		//configure the request body and resource
		String put_response = given().header("Content-Type","application/json").body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"zion resident\"\r\n"
				+ "}").when().put("https://reqres.in/api/users/2").then().extract().response().asString();
        System.out.println(put_response);
		//create Json path object to extract response body parameter
		JsonPath jsp = new JsonPath(put_response);
		
		//extract responsebody parameter
		String res_name = jsp.getString("name");
		System.out.println(res_name);
		String res_job = jsp.getString("job");
		System.out.println(res_job);
		String res_updatedAt = jsp.getString("updatedAt");
		System.out.println(res_updatedAt);
		
		//validate responsebody parameter
		Assert.assertEquals(res_name, "morpheus");
		Assert.assertEquals(res_job, "zion resident");

		
		String actual_date= res_updatedAt.substring(0,10);
		System.out.println(actual_date);
		String curr_date= LocalDate.now().toString();
		Assert.assertEquals(actual_date, curr_date);
		
		
		
	}

}
