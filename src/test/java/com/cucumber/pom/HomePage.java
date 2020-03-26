package com.cucumber.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.functionallibrary.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(xpath="//strong[text()='0123-456-789']")
	private WebElement callNow;
	
	@FindBy(xpath="//a[text()='Contact us']")
	private WebElement contactUs;
	
	@FindBy(xpath="//a[@class='login']")
	private WebElement signIn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	private WebElement logo;
	
	@FindBy(id="search_query_top")
	private WebElement search;
	
	@FindBy(xpath="(//a[@class='sf-with-ul'])[1]")
	private WebElement womenMenu;
	
	@FindBy(xpath="(//a[@class='sf-with-ul'])[3]")
	private WebElement dressMenu;
	
	@FindBy(xpath="(//a[@title='T-shirts'])[2]")
	private WebElement tshirtMenu;

	public WebElement getCallNow() {
		return callNow;
	}
	
	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getLogo() {
		return logo;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getWomenMenu() {
		return womenMenu;
	}

	public WebElement getDressMenu() {
		return dressMenu;
	}

	public WebElement getTshirtMenu() {
		return tshirtMenu;
	}

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

}
