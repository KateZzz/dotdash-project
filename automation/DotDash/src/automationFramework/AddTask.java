package automationFramework;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddTask {
	
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
		baseURL = "http://192.168.1.164/dotdash/index.php";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		
		RestAssured.baseURI = "http://192.168.1.164/dotdash";		
		RequestSpecification httpRequest = RestAssured.given();		
		Response response = httpRequest.request(Method.GET, "/fake-API-call.php");
		String responseBody = response.getBody().asString();
		//System.out.println("Response body is" + responseBody);
			
		int statusCode = 0;
			
		Task[] tasks = new Gson().fromJson(responseBody, Task[].class);
			
		for (int i = 0 ; i < tasks.length; i++) {
			if (tasks[i].task_name.equals("AddTaskTest"))
				{ statusCode++; }
		}

		Assert.assertEquals(1, statusCode);

	}

	@Test
	public void test() {
	    driver.get(baseURL);
		driver.findElement(By.name("data")).sendKeys("AddTaskTest");
		driver.findElement(By.xpath("/html/body/div[4]/input[2]")).click();
	}
	
}

	
	
	
