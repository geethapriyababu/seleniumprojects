package com.cucumber.stepdefinition;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.cucumber.functionallibrary.BaseClass;
import com.cucumber.pom.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationPracticeDefinition extends BaseClass {

	public static WebDriver driver;

	@Given("^User launches the browser$")
	public void user_launches_the_browser() throws Throwable {

		driver = browserConfig("chrome");

	}

	@Given("^User hit the given application url$")
	public void user_hit_the_given_application_url() throws Throwable {
		getUrl("http://automationpractice.com/index.php");

	}

	@When("^User clicks on SignIn link displayed in the home page$")
	public void user_clicks_on_SignIn_link_displayed_in_the_home_page() throws Throwable {
		HomePage hp = new HomePage();
		hp.getSignIn().click();

	}

	@Then("^User verifies username field is enabled$")
	public void user_verifies_username_field_is_enabled() throws Throwable {
		LoginIn lp = new LoginIn();
		Assert.assertTrue(displayed(lp.getMailId()));
	}

	@Then("^User verifies password field is enabled$")
	public void user_verifies_password_field_is_enabled() throws Throwable {
		LoginIn lp = new LoginIn();
		Assert.assertTrue(enabled(lp.getPassword()));
	}
	
	@When("^User enters the \"([^\"]*)\"$")
	public void user_enters_the(String arg1) throws Throwable {
		LoginIn lp = new LoginIn();
		sendKeys(lp.getMailId(),arg1);
	    
	}

	@When("^User enters the '(\\d+)'$")
	public void user_enters_the(int arg1) throws Throwable {
	    
		LoginIn lp = new LoginIn();
		sendKeys(lp.getPassword(),Integer.toString(arg1));
	}

	@When("^User enters \"([^\"]*)\" in the search field$")
	public void user_enters_in_the_search_field(String arg1) throws Throwable {
		MyAccount ma = new MyAccount();
		sendKeys(ma.getSearch(),arg1);
	    
	}


	@When("^User click on SignIn button$")
	public void user_click_on_SignIn_button() throws Throwable {
		LoginIn lp = new LoginIn();
		click(lp.getLogIn());
	}

	@Then("^User verifies whether username is present in the my account page$")
	public void user_verifies_whether_username_is_present_in_the_my_account_page() throws Throwable {
		MyAccount ma = new MyAccount();
		displayed(ma.getFirstLastName());
	}

	@Then("^User verifies search field is displayed$")
	public void user_verifies_search_field_is_displayed() throws Throwable {
		MyAccount ma = new MyAccount();

		Assert.assertTrue(displayed(ma.getSearch()));
	}

	@Then("^User verifies search field is enabled$")
	public void user_verifies_search_field_is_enabled() throws Throwable {

		MyAccount ma = new MyAccount();

		Assert.assertTrue(enabled(ma.getSearch()));
	}

	@When("^User enters T-Shirts in the search field$")
	public void user_enters_T_Shirts_in_the_search_field() throws Throwable {
		MyAccount ma = new MyAccount();
		sendKeys(ma.getSearch(), "T-shirts");
	}

	@When("^User clicks on search button$")
	public void user_clicks_on_search_button() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getSubmitSearch());

	}

	@When("^User clicks on the image$")
	public void user_clicks_on_the_image() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getImg());
	}

	@When("^User clicks on the plus symbol$")
	public void user_clicks_on_the_plus_symbol() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getPlus());
	}

	@When("^User selects the M value from the size dropdownlist$")
	public void user_selects_the_M_value_from_the_size_dropdownlist() throws Throwable {
		MyAccount ma = new MyAccount();
		selectDropDown(ma.getSize(), "M", "visibletext");
	}

	@When("^User clicks on the color icon$")
	public void user_clicks_on_the_color_icon() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getColor());
	}

	@When("^User clicks on Addtocart button$")
	public void user_clicks_on_Addtocart_button() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getAddCart());
	}

	@When("^User clicks on the Proceed to Checkout button$")
	public void user_clicks_on_the_Proceed_to_Checkout_button() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getCheckOut());
	}

	@When("^User clicks on the proceed to checkout button in the summary page$")
	public void user_clicks_on_the_proceed_to_checkout_button_in_the_summary_page() throws Throwable {
		ShoppingSummary ss = new ShoppingSummary();
		click(ss.getProceed());
	}

	@When("^User clicks on the terms and conditions checkbox$")
	public void user_clicks_on_the_terms_and_conditions_checkbox() throws Throwable {
		ShoppingSummary ss = new ShoppingSummary();
		ss.getTc().click();
	}

	@When("^User clicks on the procedd to checkout button in the shipping page$")
	public void user_clicks_on_the_procedd_to_checkout_button_in_the_shipping_page() throws Throwable {
		ShoppingSummary ss = new ShoppingSummary();
		click(ss.getChk());
	}

	@When("^User clicks on the pay by bankwire in the payment page$")
	public void user_clicks_on_the_pay_by_bankwire_in_the_payment_page() throws Throwable {
		ShoppingSummary ss = new ShoppingSummary();
		click(ss.getPayment());
	}

	@When("^User clicks on the confirm button$")
	public void user_clicks_on_the_confirm_button() throws Throwable {
		ShoppingSummary ss = new ShoppingSummary();
		click(ss.getConfirm());
	}

	@Then("^User verifies order is complete$")
	public void user_verifies_order_is_complete() throws Throwable {

	}

	@When("^User clicks on the logout button$")
	public void user_clicks_on_the_logout_button() throws Throwable {
		MyAccount ma = new MyAccount();
		click(ma.getSignOut());
	}

	@Then("^User verifies the browser is quit$")
	public void user_verifies_the_browser_is_quit() throws Throwable {
		driver.quit();

	}

}
