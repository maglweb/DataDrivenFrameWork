package testScripts;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import pageObjects.LoginPage;
import util.Constant;
import util.ExcelUtil;

public class TestMailLogin {
	public WebDriver driver;
	String baseurl = Constant.Url;

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

	@BeforeClass
	public void BeforeClass() {
		// 使用Constant类中的常量，设定测试数据文件的文件路径和测试数据所在的Sheet名称
		ExcelUtil.setExcelFile(Constant.TestDataExcelFilePath,
				Constant.TestDataExcelFileSheet);
	}
}
