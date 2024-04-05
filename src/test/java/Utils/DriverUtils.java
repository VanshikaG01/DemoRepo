package Utils;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;






public class DriverUtils {
	static WebDriver driver;
	static WebDriverWait wait;
	public static void createDriver() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\2000116494\\Downloads\\selenium\\Practice\\src\\test\\resources\\chromedriver.exe");
	
	driver = new ChromeDriver();
  
   
   driver.get("https://webdriveruniversity.com/");
   driver.manage().window().maximize();
   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
   wait = new WebDriverWait(driver, 10);
   
   
   
}
	public static  WebDriver getDriver() {
		if(driver== null) {
			createDriver();
		}
		return driver;
		
	}
	public static WebDriverWait getWait() {
		return wait;
	}
}
