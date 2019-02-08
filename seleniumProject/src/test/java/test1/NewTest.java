package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f(ITestContext result) {
	  
	  System.out.println(result.getName());
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.manage().window().maximize();
	  driver.navigate().to("https://www.hdfcbank.com/");
	  
	  Actions action = new Actions(driver);
	  action.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
	  action.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
	  action.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
	  action.click().build().perform();
	  driver.quit();
	  
  }
  
  
}
