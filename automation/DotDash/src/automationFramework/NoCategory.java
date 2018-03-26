package automationFramework;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NoCategory {
	
	public class Task {
		private String id;
		private String status;
		@SerializedName("task name") private String task_name;
		private String category;
		@SerializedName("due date") private String due_date;
	}

	@Before
	public void setUp() throws Exception {
	
	}

	@After
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void test() {
		RestAssured.baseURI = "http://192.168.1.164/dotdash1";		
		RequestSpecification httpRequest = RestAssured.given();		
		Response response = httpRequest.request(Method.GET, "/fake-API-call.php");
		String responseBody = response.getBody().asString();
		
		Task[] tasks = new Gson().fromJson(responseBody, Task[].class);
	    	
		int taskCategory = 0;
		
	  for (int i = 0; i < tasks.length; i++)
	     if (tasks[i].category.isEmpty()){
	    	 taskCategory++;
	    }

	  System.out.println("Number of tasks without category is " + taskCategory);
	}
}
		  
	

	