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

public class AddTask2 {
	
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
		public void testTwo() {
			 
				driver.get(baseURL);
				driver.findElement(By.name("data")).sendKeys("AddTaskTest2");
				driver.findElement(By.xpath("/html/body/div[4]/span/select[2]")).click();
				driver.findElement(By.cssSelector("#extra > select:nth-child(2) > option:nth-child(3)")).click();
				driver.findElement(By.name("due_month")).click();
				driver.findElement(By.cssSelector("#extra > select:nth-child(3) > option:nth-child(3)")).click();
				driver.findElement(By.name("due_year")).click();
				driver.findElement(By.cssSelector("#extra > select:nth-child(4) > option:nth-child(2)")).click();
				driver.findElement(By.cssSelector(".advance-controls > input:nth-child(2)")).click();
				
			}
	}


