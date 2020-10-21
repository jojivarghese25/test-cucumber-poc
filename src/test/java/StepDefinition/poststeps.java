package StepDefinition;

import io.cucumber.java.en.*;
import static org.hamcrest.Matchers.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojo.Postbyusingpojo;


public class poststeps {
	Response response;
	JsonPath json;
	Postbyusingpojo post;
	
	
	@Given("Initialize base url and base path")
	public void initialize_base_url_and_base_path() {
	    
		RestAssured.baseURI="http://localhost:8083"; 
		RestAssured.basePath="/api";
	}

	@Then("call the pojo class")
	public void call_the_pojo_class() {
	    
		
		post= new Postbyusingpojo();
		 
	}

	@Then("Get the Response for post method")
	public void get_the_response_for_post_method() {
		 response=RestAssured.given()
				.log().all().contentType(ContentType.JSON).body(post.PostMethod()) 
				.when()
				 .post("/users/registerUser")
				 .then()
				 .log().all().statusCode(201).extract().response();
	}

	@And("Validate the Response using jsonpath")
	public void validate_the_response_using_jsonpath() {
		 json = new JsonPath(response.asString());
		  String actualmsg=json.getString("message");
		  String expectedmsg="Data inserted successfully";
		 
		  Assert.assertEquals(actualmsg, expectedmsg);
		  System.out.println("post validation passed");
	}

}
