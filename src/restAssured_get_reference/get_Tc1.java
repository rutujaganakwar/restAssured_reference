package restAssured_get_reference;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;

public class get_Tc1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//declare base URI
		RestAssured.baseURI="https://reqres.in/";
		
		//configure request body and resource
		given().log().all()
		
		.when().get("https://reqres.in/api/users?page=2")
		
		.then().log().all().extract().response().asString();

	}

}
