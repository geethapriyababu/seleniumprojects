package com.cucumber.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.functionallibrary.BaseClass;

public class MyAccount extends BaseClass{
	@FindBy(xpath="//a[@title='Log me out']")
	private WebElement signOut;
	
	@FindBy(xpath="//span[text()='Geetha priya Babu']")
	private WebElement firstLastName;
	
	@FindBy(xpath="//h1[text()='My account']")
	private WebElement myAccText;
	
	@FindBy(xpath="//p[contains(text(),'Welcome')]")
	private WebElement welcomeText;
	
	@FindBy(xpath="//a[@title='Women']")
	private WebElement women;
	
	@FindBy(xpath="//a[@title='T-shirts']")
	private WebElement tshirt;
	
	@FindBy(className="cat-name")
	private WebElement tshirtText;
	
	@FindBy(id="selectProductSort")
	private WebElement sort;
	
	@FindBy(xpath="//img[@itemprop='image']")
	private WebElement img;
	
	@FindBy(className="icon-plus")
	private WebElement plus;
	
	@FindBy(id="group_1")
	private WebElement size;
	
	@FindBy(id="color_14")
	private WebElement color;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addCart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement checkOut;
	
	@FindBy(id="search_query_top")
	private WebElement search;
	
	@FindBy(name="submit_search")
	private WebElement submitSearch;
	
	@FindBy(xpath="//ul//li//strong[text()='Printed']")
	private List<WebElement> searchList;
	
	public List<WebElement> getSearchList() {
		return searchList;
	}

	public WebElement getSubmitSearch() {
		return submitSearch;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	public WebElement getFirstLastName() {
		return firstLastName;
	}

	public WebElement getMyAccText() {
		return myAccText;
	}

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	public WebElement getWomen() {
		return women;
	}

	public WebElement getTshirt() {
		return tshirt;
	}

	public WebElement getTshirtText() {
		return tshirtText;
	}

	public WebElement getSort() {
		return sort;
	}

	public WebElement getImg() {
		return img;
	}

	public WebElement getPlus() {
		return plus;
	}

	public WebElement getSize() {
		return size;
	}

	public WebElement getColor() {
		return color;
	}

	public WebElement getAddCart() {
		return addCart;
	}

	public WebElement getCheckOut() {
		return checkOut;
	}

		
	public MyAccount() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
