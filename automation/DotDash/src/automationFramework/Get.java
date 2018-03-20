package automationFramework;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get {

	@Test
	
	public void GetCode() {		
        RestAssured.baseURI = "http://192.168.1.164/dotdash";		
		RequestSpecification httpRequest = RestAssured.given();		
		Response response = httpRequest.request(Method.GET, "/fake-API-call.php");		
		int statusCode = response.getStatusCode();		
	    Assert.assertEquals(200, statusCode);	    
	    System.out.println("The actual code is "  +  statusCode );
	}
}
