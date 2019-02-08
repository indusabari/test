package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NewTest2 {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.manage().window().maximize();
	  driver.navigate().to("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	  
	  WebElement Zanzibar=driver.findElement(By.xpath("//span[text()='Zanzibar']"));
	  WebElement from=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[1]/ul/li[1]/div/div/span"));
	  WebElement to=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_priceChecker']/div[1]"));
	  
	  Actions act = new Actions(driver);
	  
	  act.doubleClick(Zanzibar).perform();
	  act.dragAndDrop(from, to).perform();
	  
	  WebDriverWait wait = new WebDriverWait(driver, 100);
	  wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"),
			  "Drop a package here to check price"));
	  
	  String text = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
	  System.out.println("The Result:"+text);
	  
	  
	
	  
  }
}
