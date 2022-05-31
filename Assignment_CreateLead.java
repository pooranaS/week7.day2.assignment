package week7.day2.assignment;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_CreateLead extends Assignment_BaseClass {
	
	@BeforeTest
	public void setFileName() {
		fileName = "CreateLead_TestData";
	}
	
	@Test(dataProvider = "testData")
	public void runCreateLead(String username, String password, String cName, String fName, String lName) {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.name("submitButton")).click();
		boolean displayed = driver.findElement(By.xpath("//div[text()='View Lead']")).isDisplayed();
		Assert.assertTrue(displayed);

	}

}
