package testScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageObjects.LoginPage;

public class TestMailLogin {
	public WebDriver driver;
	String baseurl = "http://mail.x.com.cn/";

	@Test
	public void TestLogin() throws Exception {
		driver.get(baseurl);
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName().sendKeys("a");
		loginPage.password().sendKeys("b");
		loginPage.loginButton().click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains("收件箱"));
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
