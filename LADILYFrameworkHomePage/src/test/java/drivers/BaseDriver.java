package drivers;

import java.io.File;

import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseDriver {
	
	public static String baseURL = "https://bssoln-001-site3.atempurl.com/";
	public static WebDriver driver = null;

	@BeforeSuite
	public static void setDriver() {
		
		String browser = System.getProperty("browser","chrome");
		if(browser.contains("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if(browser.contains("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		
		PageDriver.getInstance().setDriver(driver);


	}
	// Take ScreenShot
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) PageDriver.getCurrentDriver();;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
		
	}

	@AfterSuite
	public static void tearDown() {
		if (driver != null) {
			
			PageDriver.getCurrentDriver().quit();
		}
          
	}

}
