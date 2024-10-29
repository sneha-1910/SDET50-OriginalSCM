package PracticePackage;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

public class Sample3 {
	
	@Test
	public void Sample()
	{
		String baseURI = "https://reqres.in/";
		
		JsonObject obj=new JsonObject();
		
			obj.put("name":"sneha");
			obj.put("id":"19");
		
		
		given().body(obj).contentType(ContentType.Json)
		when().post("/api/users?page=2")
		.then().StatusCode("200").log().all();
		
	}
}

	  
  


