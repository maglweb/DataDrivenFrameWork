package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ObjectMap;

public class HomePage {
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap(
			"C:\\WorkSpace\\Git\\DataDriven\\objectMap.properties");
	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// 获取登录后主页中的通讯录连接
	public WebElement addressLink() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.homePage.addressbook"));
		return element;
	}
	// 如果要在Homepage页面操作更多的连接或元素，可以根据需要自定义
}
