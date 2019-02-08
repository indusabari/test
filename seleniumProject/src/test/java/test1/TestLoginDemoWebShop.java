package test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TestLoginDemoWebShop {
	
	public WebDriver driver;
	@BeforeClass
	
	public void beforemethod(String value,ITestContext result)
	{
		System.out.println("result.getName()=="+result.getName()+"String value="+value);
	 driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();	
	}
	
	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password)
	{
		
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@AfterClass
	public void aftermethod()
	{
		driver.quit();
	}
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		/*Object obj[][]={
				{"indumathi@gmail.com","test123"},
		        {"indumathi@gmail.com","test123"}
		        };
		return obj;*/
		
		return TestReadExcel.testdata();
	}

}
