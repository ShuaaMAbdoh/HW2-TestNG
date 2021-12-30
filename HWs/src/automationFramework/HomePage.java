package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;
	
	//Constructor that will be automatically called as soon as the object of the class is created
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator
	By LogoImage = By.xpath("/html/body/div[8]/header/div[1]/div[3]/div[1]/a/img");
	By Email = By.xpath("/html/body/div[8]/header/div[1]/div[3]/div[4]/div[1]/div[1]/button");
	By Account = By.xpath("/html/body/div[8]/header/div[1]/div[3]/div[4]/div[1]/div[2]/div/a/span");
	By EmailInput = By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[1]/input");
	By PasswordInput = By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[2]/input");


	public void VerifyLogo() {
		driver.findElement(LogoImage).isDisplayed();
	}
	
	public void VerifyEmail() {
		driver.findElement(Email).isDisplayed();
	}
	
	public void VerifyMyAccount() {
		driver.findElement(Account).isDisplayed();
	}
	
	public void ClickMyAccount() {
		driver.findElement(Account).click();
	}
	
	public void EnterEmail() {
		driver.findElement(EmailInput).sendKeys("email@example.com");
	}
	
	public void EnterPassword() {
		driver.findElement(PasswordInput).sendKeys("password");
	}
}
