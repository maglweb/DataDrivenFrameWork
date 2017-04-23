package appModules;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPage;

public class Login_Action {
	public static void execute(WebDriver driver, String userName,
			String passWord) throws Exception {
		driver.get("http://mail.litsoft.com.cn");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.userName().sendKeys(userName);
		loginPage.password().sendKeys(passWord);
		loginPage.loginButton().click();
		Thread.sleep(5000);
	}
}
