package appModules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.AddressBookPage;
import pageObjects.HomePage;

public class AddContactPerson_Action {
	public static void execute(WebDriver driver, String UserName,
			String PassWord, String contactName, String contactEmail,
			String contactMobile) throws Exception {
		Login_Action.execute(driver, "magl", "mgl_Aa123456");
		Thread.sleep(3000);
		Assert.assertTrue(driver.getPageSource().contains("收件箱"));
		// driver.switchTo().frame(arg0)
		HomePage homePage = new HomePage(driver);
		homePage.addressLink().click();
		AddressBookPage AddressBookPage = new AddressBookPage(driver);
		WebElement MainFrame = driver.findElement(By.id("mainFrame"));
		driver.switchTo().frame(MainFrame);
		Thread.sleep(3000);
		AddressBookPage.createContactPersonButton().click();
		Thread.sleep(1000);
		AddressBookPage.contactPersonName().sendKeys(contactName);
		AddressBookPage.contactPersonEmail().sendKeys(contactEmail);
		AddressBookPage.contactPersonMobile().sendKeys(contactMobile);
		AddressBookPage.saveButton().click();
		Thread.sleep(5000);
	}
}
