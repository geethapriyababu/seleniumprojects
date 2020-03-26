package com.cucumber.functionallibrary;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static Actions ac;
	public static Alert alert;

	public static WebDriver browserConfig(String browserName) {
		String path = System.getProperty("user.dir");
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", path + ("\\Driver\\chromedriver.exe"));
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("gecko")) {
				System.setProperty("webdriver.gecko.driver", path + ("\\Driver\\gecko.exe"));
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.internetexplorer.driver", path + "\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver;
	}

	
	public static void getUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean displayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayed;
	}

	public static boolean enabled(WebElement element) {
		boolean enabled = false;
		try {
			enabled = element.isEnabled();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return enabled;
	}

	public static boolean selected(WebElement element) {
		boolean selected = false;
		try {
			selected = element.isSelected();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return selected;
	}

	public static String getElementText(WebElement wb) {
		String txt = null;
		try {
			displayed(wb);
			enabled(wb);
			txt = wb.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}

	public static String getAttributeValue(WebElement wb) {
		String attrTxt = null;
		try {
			attrTxt = wb.getAttribute("value");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return attrTxt;
	}

	public static void getTitle() {
		try {
			String title = driver.getTitle();
			System.out.println(title);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getcurrentUrl() {
		try {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clear(WebElement wb) {
		try {
			displayed(wb);
			enabled(wb);
			wb.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void visibilityOfElement(WebElement wb) {
		WebDriverWait wd = new WebDriverWait(driver, 50);
		wd.until(ExpectedConditions.visibilityOf(wb));
	}

	public static void click(WebElement wb) {
		try {
			displayed(wb);
			enabled(wb);
			visibilityOfElement(wb);
			wb.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void selectDropDown(WebElement element, String option, String type) {
		try {
			// visibilityOfElement(element);
			Select sc = new Select(element);
			if (type.equalsIgnoreCase("value")) {
				sc.selectByValue(option);
			} else if (type.equalsIgnoreCase("visibletext")) {
				sc.selectByVisibleText(option);
			} else if (type.equalsIgnoreCase("index")) {
				sc.selectByIndex(Integer.parseInt(option));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getFirstSelectedOption(WebElement element, String option) {

		Select sc = new Select(element);
		WebElement fs = sc.getFirstSelectedOption();
		String text = fs.getText();
		return text;
	}

	public static void jsExecutor(WebElement wb) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollDownByPixel(int x, int y) {
		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollTo(" + x + "," + y + ")");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollToBottom() {
		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollToRight() {
		js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollBy(0,document.body.scrollWidth)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void mouseHover(WebElement wb) {
		ac = new Actions(driver);
		try {
			displayed(wb);
			enabled(wb);
			ac.moveToElement(wb).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void doubleClick(WebElement wb) {
		ac = new Actions(driver);
		try {
			displayed(wb);
			enabled(wb);
			ac.doubleClick(wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void rightClick(WebElement wb) {
		ac = new Actions(driver);
		try {
			displayed(wb);
			enabled(wb);
			ac.contextClick(wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dragdrop(WebElement wb1, WebElement wb2) {
		ac = new Actions(driver);
		try {
			displayed(wb1);
			enabled(wb1);
			ac.dragAndDrop(wb1, wb2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void takeScreenshot() throws Exception {
		try {
			String timestamp = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
			File des = new File("C:\\Users\\Acer\\eclipse-workspace\\SeleniumDay2\\screenshots\\" + timestamp + ".png");
			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(temp, des);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void simpleAlert() {
		try {
			alert.accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void confirmAlert() {
		try {

			alert.dismiss();
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void promptAlert(WebElement wb) {
		try {
			wb.click();
			String txt = alert.getText();
			System.out.println(txt);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void navigation(String navigate) {
		try {
			if (navigate.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (navigate.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (navigate.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}

			else if (navigate.contains("http")) {
				driver.navigate().to(navigate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendKeys(WebElement wb, String value) {
		try {
			displayed(wb);
			enabled(wb);
			clear(wb);
			wb.sendKeys(value);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static void sendkeys(String value,WebElement wb) { ac = new
	 * Actions(driver); try { displayed(wb); enabled(wb); clear(wb); ac.sendKeys(wb,
	 * value).build().perform(); } catch(Exception e) { e.printStackTrace(); } }
	 */
}
