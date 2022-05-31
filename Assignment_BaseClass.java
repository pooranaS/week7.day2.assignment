package week7.day2.assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import week6.day2.assignment.ReadExcelData;

public class Assignment_BaseClass {
	public RemoteWebDriver driver;

	public String fileName;
	
	SoftAssert softAssert = new SoftAssert();
	
	@DataProvider
	public String[][] testData() throws IOException {

		String[][] data = ReadExcel.readData(fileName);
		return data;
		
	}
	
	@Parameters({"URL","browserName"})
	@BeforeMethod
	public void startBrowser(String url , String browserName) {
		
		if(browserName.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if(browserName.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void endBrowser() {

		driver.close();
	}

}
