package com.cucumber.stepdefinition;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.functionallibrary.BaseClass;
import com.cucumber.functionallibrary.JdbcClass;
import com.cucumber.pom.HomePage;
import com.cucumber.pom.LoginIn;
import com.cucumber.pom.MyAccount;
import com.cucumber.pom.PersonalInfo;
import com.cucumber.pom.ShoppingSummary;
import com.mysql.jdbc.Driver;

public class JDBCConnection extends JdbcClass {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Acer\\eclipse-workspace\\CucumberDay1\\Driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
		signIn.click();
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

		RandomStringUtils r = new RandomStringUtils();
		String alphaNum = r.randomAlphanumeric(8);
		String concatS1 = alphaNum.concat("@gmail.com");
		WebElement emailId = driver.findElement(By.id("email_create"));
		emailId.sendKeys(concatS1);
		boolean matches = concatS1.matches(regex);
		WebElement submit = driver.findElement(By.id("SubmitCreate"));
		submit.click();
		try
		{
			JdbcClass jdbc=new JdbcClass();
			ResultSet rs = jdbc.jdbcConnection();
			do
			{
			
			if (rs.getString("title").contains("Mr")) {
				WebElement male = driver.findElement(By.id("id_gender1"));
				male.click();
			}
			else
			{
				WebElement female = driver.findElement(By.id("id_gender2"));
				female.click();
			}
			
			WebElement fname = driver.findElement(By.id("customer_firstname"));
			fname.sendKeys(rs.getString(2));
			WebElement lname = driver.findElement(By.id("customer_lastname"));
			lname.sendKeys(rs.getString(3));
			WebElement pwd = driver.findElement(By.id("passwd"));
			pwd.sendKeys(rs.getString(4));
			/*String dob = jdbcConnection(5,query);
			System.out.println(dob);
			String yr = dob.substring(0,3);
			System.out.println(yr);
			String mon = dob.substring(5,6);
			System.out.println(mon);
			String date = dob.substring(8);
			System.out.println(date);
			selectDropDown(pg.getDays(), date, "value");
			selectDropDown(pg.getMonths(), mon, "value");
			selectDropDown(pg.getYears(), yr, "value");*/
		/*	if (rs.getString(6).contains("Yes")) {
				pg.getChkList().get(0).click();
			}
			if (rs.getString(7).contains("Yes")) {
				pg.getChkList().get(1).click();
			}*/
			WebElement company = driver.findElement(By.id("company"));
			company.sendKeys(rs.getString(8));
			WebElement address = driver.findElement(By.id("address1"));
			address.sendKeys(rs.getString(9));
			WebElement city = driver.findElement(By.id("city"));
			city.sendKeys(rs.getString(10));
			WebElement state = driver.findElement(By.id("id_state"));
			Select s=new Select(state);
			s.selectByVisibleText(rs.getString(11));
			WebElement pincode = driver.findElement(By.id("postcode"));
			pincode.sendKeys(rs.getString(12));
			WebElement addinfo = driver.findElement(By.id("other"));
			addinfo.sendKeys(rs.getString(13));
			WebElement ph = driver.findElement(By.id("phone"));
			ph.sendKeys(rs.getString(14));
			WebElement mobile = driver.findElement(By.id("phone_mobile"));
			mobile.sendKeys(rs.getString(15));
			WebElement aliasadd = driver.findElement(By.id("alias"));
			aliasadd.sendKeys(rs.getString(16));
			WebElement register = driver.findElement(By.xpath("//span[text()='Register']"));
			register.click();
			WebElement search = driver.findElement(By.id("search_query_top"));
			search.sendKeys("T-shirts");
			WebElement submit1 = driver.findElement(By.name("submit_search"));
			submit1.click();
			WebElement img = driver.findElement(By.xpath("//img[@itemprop='image']"));
			img.click();
			WebElement icon = driver.findElement(By.className("icon-plus"));
			icon.click();
			WebElement size = driver.findElement(By.id("group_1"));
			Select s1=new Select(size);
			s1.selectByVisibleText("M");
			WebElement color = driver.findElement(By.id("color_14"));
			color.click();
			WebElement addCart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
			addCart.click();
			WebElement checkOut = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
			checkOut.click();
			WebElement proceed = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
			proceed.click();
			proceed.click();
			/*WebElement aliasadd = driver.findElement(By.id("alias"));
			ss.getProceed().click();*/
			WebElement tc = driver.findElement(By.id("cgv"));
			tc.click();
			WebElement proceedChk = driver.findElement(By.name("processCarrier"));
			proceedChk.click();
			WebElement payment = driver.findElement(By.className("bankwire"));
			payment.click();
			WebElement confirm = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
			confirm.click();
			WebElement signOut = driver.findElement(By.xpath("//a[@title='Log me out']"));
			signOut.click();
			}
			while(rs.next());
			
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			driver.quit();
		}
	}					

	
		
		
		


		
		
		
		


}
