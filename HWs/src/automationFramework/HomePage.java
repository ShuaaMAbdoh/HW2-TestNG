package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locator
	By LogoImage = By.xpath("/html/body/div[8]/header/div[1]/div[3]/div[1]/a/img");
	By Email = By.xpath("/html/body/div[8]/header/div[1]/div[3]/div[4]/div[1]/div[1]/button");
	By Account = By.xpath("/html/body/div[8]/header/div[1]/div[3]/div[4]/div[1]/div[2]/div/a/span");
	By EmailInput = By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[1]/input");
	By PasswordInput = By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[2]/input");
	By TitleSignUp=  By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[2]/div/h2");
	By CancelButton= By.xpath("/html/body/div[14]/div/button");

	public void ClickOnCancel() {
		driver.findElement(CancelButton).click();
	}
	
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
		driver.findElement(EmailInput).sendKeys("example@email.com");
	}
	
	public void EnterPassword() {
		driver.findElement(PasswordInput).sendKeys("123456Qwe@");
	}
	
	public String GetTitle() {
		return driver.findElement(TitleSignUp).getText().toString();
	}
}
