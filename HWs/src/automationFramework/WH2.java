package automationFramework;

import java.io.IOException;
import java.io.Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WH2 {
	public static WebDriver driver;
	
	@BeforeTest
	  public void beforeMethod() { 
		ChromeOptions capability = new ChromeOptions();
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capability.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver(capability);
		driver.get("https://devwcs2.frontgate.com/ShoppingCartView");	
		driver.manage().window().maximize();
	  }
	
  @Test
  public void f() {
	  ReadFile readObj = new ReadFile();
	  String filePath = "C:\\Users\\ShuaaAbdoh\\Downloads";
	 
	  try {
		String data = readObj.readExcel(filePath,"homework2.xlsx","sheet1");
		String []dataArray = data.split("\n");
		for(int i=0;i<dataArray.length;i++) {
			String []userinfo = dataArray[i].split(",");
			System.out.println("length:"+userinfo.length);
			System.out.println("email:"+userinfo[0]+"password:"+userinfo[1]);
			System.out.println("email:"+userinfo[i]+"password:"+userinfo[i]);
			driver.findElement(By.xpath("//*[@id=\"gwt-sign-in-modal\"]")).sendKeys(userinfo[0]);
			driver.findElement(By.xpath("//*[@id=\"passwordReset\"]")).sendKeys(userinfo[1]);
			driver.findElement(By.xpath("/html/body/div[2]/div[5]/div/div/main/div[23]/div/div[2]/div[1]/div[2]/div[2]/div/div[3]/button")).click();	
		}
		
	} 
	  catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
