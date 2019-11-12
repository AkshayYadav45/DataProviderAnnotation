package pkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataproviderDemo {
	WebDriver driver;
	
	@Test(dataProvider="Browser")
	public void openBrowser(String s) {
		if(s.contentEquals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		else if(s.contentEquals("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		
		else {
			System.out.println("There are no any browser available ");
		}
		driver.get("https://www.google.com/");
	}
	
	@DataProvider(name="Browser")
	public Object[][] dataPass(){
		Object[][] ob=new Object[2][1];
		ob[0][0]="Chrome";
		ob[1][0]="firefox";
	return ob;		
	}
}
