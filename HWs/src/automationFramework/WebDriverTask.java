package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automationFramework.HomePage;

public class WebDriverTask {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		org.openqa.selenium.WebDriver driver = new ChromeDriver();
		HomePage home = new HomePage(driver);
		driver.manage().window().maximize();
		String baseUrl ="https://www.lancome-usa.com";
		driver.get(baseUrl);
		System.out.println("Successfully opened the website");
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute 
		driver.findElement(By.xpath("/html/body/div[14]/div/button")).click();
		home.VerifyLogo();
		home.VerifyEmail();
		home.VerifyMyAccount();	
		home.ClickMyAccount();
		String title=driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[2]/div/h2")).getText().toString();
		System.out.println(title);
		Assert.assertEquals(title, "CREATE ACCOUNT");
		
		home.EnterEmail();
		home.EnterPassword();
	}
}
