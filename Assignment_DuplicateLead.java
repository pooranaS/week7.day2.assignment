package week7.day2.assignment;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Assignment_DuplicateLead extends Assignment_BaseClass{
	@BeforeTest
	public void setFileName() {
		fileName = "DuplicateLead_TestData";
	}
	
	@Test(dataProvider = "testData")
	
	public void runDuplicateLead(String username, String password, String phoneNumber) throws InterruptedException {

		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phoneNumber);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Duplicate Lead")).click();
		driver.findElement(By.name("submitButton")).click();
		boolean displayed = driver.findElement(By.xpath("//div[text()='View Lead']")).isDisplayed();
		softAssert.assertFalse(displayed);
		softAssert.assertAll(); //This case will fail.ExpectedFalse but it returns true.Using this for assignment purpose

	}
}
