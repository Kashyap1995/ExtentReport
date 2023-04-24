package Reportpack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentdemo {
	ExtentReports extent;

	
	@BeforeTest
	public void config() {
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Result");
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "KD");
				
	}
	
	@Test
	public void initialdemo()
	{
	
	extent.createTest("Initial Demo");
	System.setProperty("webdriver.gecko.driver","C:\\Users\\Plutus-Dev\\Desktop\\Kashyapqa\\Selenium\\geckodriver.exe");
	WebDriver driver = new FirefoxDriver();
	driver.get("https://rahulshettyacademy.com/");
	System.out.println(driver.getTitle());
//	driver.close();
//	test.fail("Result do not match");
	extent.flush();
	
	
	}
}
