package automationFramework;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import automationFramework.AddTask.Task;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Count {
	WebDriver driver;
	String baseURL;
	public class Task {
		private String id;
		private String status;
		@SerializedName("task name") private String task_name;
		private String category;
		@SerializedName("due date") private String due_date;
		}
	
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "geckodriver");
		driver = new FirefoxDriver();
		baseURL = "http://192.168.1.164/dotdash1/index.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@After
	public void tearDown() throws Exception {
	 driver.quit();
	}

	@Test
	public void test() {
		
		driver.get(baseURL);
		
		int count = driver.findElements(By.xpath("//input[@type='checkbox']")).size()-1;
		
		System.out.println("All tasks equals " + count);
		
		
		RestAssured.baseURI = "http://192.168.1.164/dotdash1";		
		RequestSpecification httpRequest = RestAssured.given();		
		Response response = httpRequest.request(Method.GET, "/fake-API-call.php");
		String responseBody = response.getBody().asString();
		// System.out.println("Response body is" + responseBody);
			
	
		
		Task[] tasks = new Gson().fromJson(responseBody, Task[].class);
			
		for (int i = 0 ; i < tasks.length; i++) {
		 
       }
		System.out.println(tasks.length);
		assertEquals(count, tasks.length);
	}
	
      
}	
		
		
	
