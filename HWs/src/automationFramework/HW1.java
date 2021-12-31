package automationFramework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class HW1 {
	
    public String baseUrl = "https://www.ballarddesigns.com/";
    String driverPath = "C:\\\\Selenium\\\\chromedriver.exe";
    public static WebDriver driver;

  @Test
  public void verifyHomepageTitle() {
       
      boolean isLogoDisplayed =driver.findElement(By.className("logo-anchor")).isDisplayed();
	  if(isLogoDisplayed) {
		System.out.println("Logo is displayed");  
	  }  
  }
  
  @Test
  public void clickOnSignIn() {
	  driver.findElement(By.xpath("//*[@id=\"bdheader\"]/div/div[1]/div[2]")).click();
	  //there's error here access denied
  }
  
  @Test
  public void testLogIn() {
	  //there's error here access denied
	  String email = "examle@email.com";
	  String password = "123456qwe";
	  driver.findElement(By.id("login-form-email")).sendKeys(email);
	  driver.findElement(By.id("login-form-password")).sendKeys(password);
	  driver.findElement(By.className("signin")).click();
	  
	  
	  String linkTitle = driver.findElement(By.xpath("xpath")).getText().toString();
	  Assert.assertEquals(linkTitle, "My Account");
	  
	  String welcomeTitle = driver.findElement(By.xpath("xpath")).getText().toString();
	  Assert.assertEquals(welcomeTitle, "Welcome, User");
  }
  
  @BeforeTest
  public void beforeMethod() {
      System.setProperty("webdriver.chrome.driver",driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
  }
  
  @AfterTest
  public void afterMethod() {
	 // driver.close();
  }
}

