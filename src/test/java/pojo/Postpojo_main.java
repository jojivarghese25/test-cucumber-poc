package pojo;

import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;


public class Postpojo_main {

	@Test
	public void post() {
		Postbyusingpojo ps= new Postbyusingpojo();
		
		 RestAssured.baseURI="http://localhost:8083"; RestAssured.basePath="/api";
		 
		  Response response=RestAssured.given()
		  .log().all().contentType(ContentType.JSON).body(ps.PostMethod()) 
		  .when()
		  .post("/users/registerUser")
		  .then() .log().all().statusCode(201).assertThat()
		  .body("message", equalTo("Data inserted successfully")).extract().response();
		  
		  /*JsonPath js= new JsonPath(response.asString());
		  String msg=js.getString("message");
		  Assert.assertEquals(msg,"Data inserted successfully");*/
		  
				  
		  
		
		
		/*
		 * RequestSpecification request = RestAssured.given();
		 * request.header("Content-Type", "application/json");
		 * request.body(ps.PostMethod());
		 * request.post("http://localhost:8083/api/users/registerUser").then().
		 * statusCode(201);
		 */
		
	}
}
