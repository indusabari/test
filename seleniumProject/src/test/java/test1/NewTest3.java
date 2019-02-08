package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest3 {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.manage().window().maximize();
	  driver.navigate().to("https://www.cleartrip.com/");
	  
	  WebDriverWait wait = new WebDriverWait(driver, 100);
	  wait.until(ExpectedConditions.alertIsPresent());
	  
	  try {

		   // Check the presence of alert
		   Alert alert = driver.switchTo().alert();

		   // if present consume the alert
		   alert.accept();

		  } catch (NoAlertPresentException ex) {
		     //code to do if not exist.
		  }
	  
	 driver.findElement(By.id("FromTag")).sendKeys("HYD");
	  
	  
  }
}
