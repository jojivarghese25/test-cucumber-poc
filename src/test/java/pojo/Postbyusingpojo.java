package pojo;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

import postpojo.Post_body;


public class Postbyusingpojo {
	
	public String PostMethod() {
		
		JSONObject requestParams = new JSONObject();
		
		Post_body post = new Post_body();
		requestParams.put("userId", "899001");
		requestParams.put("emailId", "pavani@gmail.com");
		requestParams.put("firstName", "payally");
		requestParams.put("lastName", "joann");
		requestParams.put("phoneNumber", "11234536789");
		
		return requestParams.toJSONString();
		
	}
	}


