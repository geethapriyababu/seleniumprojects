package com.cucumber.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.functionallibrary.BaseClass;

public class LoginIn extends BaseClass {
	
	@FindBy(xpath="//h1[text()='Authentication']")
	private WebElement auth;
	
	@FindBy(xpath="(//h3[@class='page-subheading'])[1]")
	private WebElement createAcc;
	
	@FindBy(xpath="(//h3[@class='page-subheading'])[2]")
	private WebElement alreadyReg;
	
	@FindBy(id="email_create")
	private WebElement email;
	
	@FindBy(id="SubmitCreate")
	private WebElement submit;
	
	@FindBy(id="email")
	private WebElement mailId;
	
	@FindBy(name="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement logIn;

	public WebElement getMailId() {
		return mailId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogIn() {
		return logIn;
	}

	public WebElement getAuth() {
		return auth;
	}

	public WebElement getCreateAcc() {
		return createAcc;
	}

	public WebElement getAlreadyReg() {
		return alreadyReg;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	public LoginIn() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
