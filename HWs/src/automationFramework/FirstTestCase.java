package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class FirstTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		org.openqa.selenium.WebDriver driver = new ChromeDriver();
		driver.get("https://www.lancome-usa.com");
		driver.findElement(By.xpath("//html/body/div[14]/div/button")).click();
		String s=driver.findElement(By.xpath("//html/body/div[8]/header/div[1]/div[1]/div/div/section/div[2]/div[1]/div[3]/a/center/span")).getText().toString();
		System.out.println("Successfully opened the website"+s);
		driver.quit();
	}
}
