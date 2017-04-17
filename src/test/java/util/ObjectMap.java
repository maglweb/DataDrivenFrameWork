package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class ObjectMap {
	Properties properties;

	public ObjectMap(String profile) {
		properties = new Properties();
		try {
			FileInputStream in = new FileInputStream(profile);
			properties.load(in);
			in.close();
		} catch (IOException e) {
			System.out.println("读取对象文件出错");
			e.printStackTrace();
		}
	}

	public By getLocator(String ElementNameInpropFile) throws Exception {
		// 根据变量ElementNameInpropFile，从属性配置文件中读取对应的配置对象
		String locator = properties.getProperty(ElementNameInpropFile);
		// 将配置对象中定位类型存到locatorType变量，将定位表达式的值存入locatorValue变量中
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		/*
		 * 在Eclipse中的配置文件均默认ISO-8859-1编码存储，使用getBytes方法可以将字符串编码转换为UTF-8
		 * 来解决文件读取中为乱码的问题
		 */
		locatorValue = new String(locatorValue.getBytes("ISO-8859-1"), "UTF-8");
		// 输出locatorType变量值和locatorValue变量值，验证是否赋值正确
		System.out.println("获取的定位类型" + locatorType + "\t 获取的定位表达式"
				+ locatorValue);

		// 根据locatorType的变量值内容判断返回何种方式的by对象
		if (locatorType.toLowerCase().equals("id")) {
			return By.id(locatorValue);
		} else if (locatorType.toLowerCase().equals("name")) {
			return By.name(locatorValue);
		} else if (locatorType.toLowerCase().equals("classname")
				|| locatorType.toLowerCase().equals("class")) {
			return By.className(locatorValue);
		} else if (locatorType.toLowerCase().equals("tagname")
				|| locatorType.toLowerCase().equals("tag")) {
			return By.tagName(locatorValue);
		} else if (locatorType.toLowerCase().equals("linktext")
				|| locatorType.toLowerCase().equals("link")) {
			return By.linkText(locatorValue);
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			return By.partialLinkText(locatorValue);
		} else if (locatorType.toLowerCase().equals("cssselector")
				|| (locatorType.toLowerCase().equals("css"))) {
			return By.cssSelector(locatorValue);
		} else if (locatorType.toLowerCase().equals("xpath")) {
			return By.xpath(locatorValue);
		} else {
			throw new Exception("输入的locatorType未在程序中被定义:" + locatorType);
		}
	}
}
