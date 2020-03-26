package com.cucumber.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.functionallibrary.BaseClass;

public class ShoppingSummary extends BaseClass{

	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceed;
	
	@FindBy(name="processAddress")
	private WebElement chkOut;
	
	@FindBy(id="cgv")
	private WebElement tc;
	
	@FindBy(name="processCarrier")
	private WebElement chk;
	
	@FindBy(xpath="//span[@class='price']//strong")
	private WebElement price;
	
	@FindBy(xpath="(//Strong)[9]")
	private WebElement accOwner;
	
	@FindBy(xpath="(//Strong)[11]")
	private WebElement bankName;
	
	@FindBy(xpath="//*[@id='center_column']/div/br[contains(text(),'insert')][5]")
	private WebElement refno;
	
	public WebElement getPrice() {
		return price;
	}

	public WebElement getAccOwner() {
		return accOwner;
	}

	public WebElement getBankName() {
		return bankName;
	}

	public WebElement getRefno() {
		return refno;
	}

	public List<WebElement> getBillingAdd() {
		return billingAdd;
	}

	public List<WebElement> getDeliveryAdd() {
		return deliveryAdd;
	}

	@FindBy(className="bankwire")
	private WebElement payment;
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	private WebElement confirm;

	@FindBy(xpath="//ul[@class='address alternate_item box']//li")
	private List<WebElement> billingAdd;
	
	@FindBy(xpath="//ul[@class='address item box']//li")
	private List<WebElement> deliveryAdd;
	
	
	/*@FindBy(tagName="li")
	private List<WebElement> g;
	*/
	public WebElement getProceed() {
		return proceed;
	}

	public WebElement getChkOut() {
		return chkOut;
	}

	public WebElement getTc() {
		return tc;
	}

	public WebElement getChk() {
		return chk;
	}

	public WebElement getPayment() {
		return payment;
	}

	public WebElement getConfirm() {
		return confirm;
	}
	
	public ShoppingSummary() {
		PageFactory.initElements(driver, this);
	}

}
