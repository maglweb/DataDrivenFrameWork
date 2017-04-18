package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ObjectMap;

public class LoginPage {
	private WebElement element;

	private WebDriver driver;

	// 指定页面元素定位表达式配置文件的绝对路径
	private ObjectMap objectMap = new ObjectMap(
			"C:\\WorkSpace\\Git\\DataDriven\\objectMap.properties");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// 返回登录页面中的用户名输入框页面元素对象
	public WebElement userName() throws Exception {
		// 使用ObjectMap类中的getLocator方法获取配置文件中关于用户名的定位表达式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("mail.loginPage.username"));
		return element;
	}

	// 返回登录页面中的密码输入框页面元素对象
	public WebElement password() throws Exception {
		// 使用ObjectMap类中的getLocator方法获取配置文件中关于密码的定位表达式和定位表达式
		element = driver.findElement(objectMap
				.getLocator("mail.loginPage.password"));
		return element;
	}

	// 返回登录页面中的登录按钮页面元素对象
	public WebElement loginButton() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.loginPage.loginButton"));
		return element;
	}
}
