package com.cucumber.pom;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.functionallibrary.BaseClass;

public class PersonalInfo extends BaseClass {
	
	@FindBy(xpath="//h1[text()='Create an account']")
	private WebElement createAcc;
	
	@FindBy(name="id_gender")
	private List<WebElement> g;
	
	@FindBy(id="id_gender1")
	private WebElement male;
	
	@FindBy(id="id_gender2")
	private WebElement female;

	@FindBy(id="customer_firstname")
	private WebElement fname;
	
	@FindBy(id="customer_lastname")
	private WebElement lname;
	
	@FindBy(id="passwd")
	private WebElement pwd;
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="days")
	private WebElement days;
	
	@FindBy(id="months")
	private WebElement months;
	
	@FindBy(id="years")
	private WebElement years;
	
	@FindBy(xpath="//input[@type='checkbox']")
	private List<WebElement> chkList;
	
	@FindBy(id="firstname")
	private WebElement uname;
	
	@FindBy(id="lastname")
	private WebElement lastname;
	
	@FindBy(id="company")
	private WebElement company;
	
	@FindBy(id="address1")
	private WebElement address;
	
	@FindBy(id="city")
	private WebElement cty;
	
	@FindBy(id="postcode")
	private WebElement pinCode;
	
	@FindBy(id="other")
	private WebElement addInfo;
	
	@FindBy(id="phone")
	private WebElement ph;
	
	@FindBy(id="phone_mobile")
	private WebElement mobile;
	
	@FindBy(id="alias")
	private WebElement aliasAdd;
	
	@FindBy(id="id_state")
	private WebElement state;
	
	@FindBy(id="id_country")
	private WebElement country;
	
	@FindBy(xpath="//span[text()='Register']")
	private WebElement register;

	public WebElement getCreateAcc() {
		return createAcc;
	}
	
	public List<WebElement> getG() {
		return g;
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getLname() {
		return lname;
	}

	public WebElement getPwd() {
		return pwd;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getMale() {
		return male;
	}

	public WebElement getFemale() {
		return female;
	}

	public WebElement getDays() {
		return days;
	}

	public WebElement getMonths() {
		return months;
	}

	public WebElement getYears() {
		return years;
	}

	public List<WebElement> getChkList() {
		return chkList;
	}

	public WebElement getUname() {
		return uname;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getCompany() {
		return company;
	}

	public WebElement getAddress() {
		return address;
	}

	public WebElement getCty() {
		return cty;
	}

	public WebElement getPinCode() {
		return pinCode;
	}

	public WebElement getAddInfo() {
		return addInfo;
	}

	public WebElement getPh() {
		return ph;
	}

	public WebElement getMobile() {
		return mobile;
	}

	public WebElement getAliasAdd() {
		return aliasAdd;
	}

	public WebElement getState() {
		return state;
	}

	public WebElement getCountry() {
		return country;
	}

	public WebElement getRegister() {
		return register;
	}
	
	public PersonalInfo() {
		PageFactory.initElements(driver, this);
	}
	
	

}
