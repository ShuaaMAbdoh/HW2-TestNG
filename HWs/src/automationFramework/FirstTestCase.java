package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import automationFramework.HomePage;

public class WebDriverTask {

	public static void main(String[] args) {
		
		String baseUrl ="https://www.lancome-usa.com";
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		
		org.openqa.selenium.WebDriver driver = new ChromeDriver();
		HomePage home = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		
		System.out.println("Successfully opened the website");
		WebDriverWait wait = new WebDriverWait(driver, 60);// 1 minute
		
		home.ClickOnCancel();
		home.VerifyLogo();
		home.VerifyEmail();
		home.VerifyMyAccount();	
		home.ClickMyAccount();
		String title=home.GetTitle();
		System.out.println(title);
		Assert.assertEquals(title, "CREATE ACCOUNT");
		home.EnterEmail();
		home.EnterPassword();
	}
}
