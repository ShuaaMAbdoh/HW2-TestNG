package automationFramework;
import automationFramework.Constant;
import java.io.IOException;
import java.io.Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WH2 {
	public static WebDriver driver;
	Constant constant = new Constant();

  @Test
  public void f() {
	  ReadFile readObj = new ReadFile();
	  String filePath = "C:\\Users\\ShuaaAbdoh\\Documents\\HWs\\HWs";
		String baseUrl =constant.baseUrlHW2;
		System.setProperty("webdriver.chrome.driver",constant.webdriver);
		
		org.openqa.selenium.WebDriver driver = new ChromeDriver();
		HomePage home = new HomePage(driver);
		driver.manage().window().maximize();
		driver.get(baseUrl);
		home.ClickOnCancel();
		home.ClickMyAccount();
	 
	  try {
		String data = readObj.readExcel(filePath,"homework2.xlsx","sheet1");
		String []dataArray = data.split("\n");
		for(int i=0;i<dataArray.length;i++) {
			String []userinfo = dataArray[i].split(",");
			System.out.println("length:"+userinfo.length);
			System.out.println("email:"+userinfo[0]+"password:"+userinfo[1]);
			//System.out.println(userinfo[i]+"\t");
			driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[1]/input")).sendKeys(userinfo[0]);
			driver.findElement(By.xpath("/html/body/div[8]/div[2]/div/div[2]/div[2]/div[1]/div/div/form/div[2]/input")).sendKeys(userinfo[1]);
			
			String errorMessage =home.InvalidEmailMessage();
			System.out.println(errorMessage);
			Assert.assertEquals(errorMessage, "Email address is invalid");
		}
		
	} 
	  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
