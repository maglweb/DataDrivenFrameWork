package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import util.ObjectMap;

public class AddressBookPage {
	private WebDriver driver;
	private WebElement element = null;
	private ObjectMap objectMap = new ObjectMap(
			"C:\\WorkSpace\\Git\\DataDriven\\objectMap.properties");

	public AddressBookPage(WebDriver driver) {
		this.driver = driver;
	}

	// 获取新建联系人按钮
	public WebElement createContactPersonButton() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.addressBook.createContactPerson"));
		return element;
	}

	// 获取新建联系人界面中的姓名输入框
	public WebElement contactPersonName() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.addressBook.contactPersonName"));
		return element;
	}

	// 获取新建联系人界面中的电子邮件输入框
	public WebElement contactPersonEmail() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.addressBook.contactPersonName"));
		return element;
	}

	// 获取新建联系人界面中的手机号输入框
	public WebElement contactPersonMobile() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.addressBook.contactPersonName"));
		return element;
	}

	// 获取新建联系人界面中保存信息的"保存"按钮
	public WebElement saveButton() throws Exception {
		element = driver.findElement(objectMap
				.getLocator("mail.addressBook.saveButton"));
		return element;
	}
}
