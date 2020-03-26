package com.cucumber.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableDefinition {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Acer\\eclipse-workspace\\CucumberDay1\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://en.wikipedia.org/wiki/Programming_languages_used_in_most_popular_websites");

		/*
		 * List<WebElement> table = driver.findElements(By.tagName("Table")); WebElement
		 * table1 = table.get(0); WebElement tableHead =
		 * table1.findElement(By.tagName("thead")); WebElement tableRow =
		 * tableHead.findElement(By.tagName("tr")); List<WebElement> tableTh =
		 * tableRow.findElements(By.tagName("th")); for (WebElement xx : tableTh) {
		 * System.out.print(xx.getText() + "\t"); } System.out.println(); WebElement
		 * tableBody = driver.findElement(By.tagName("tbody")); List<WebElement>
		 * tableRow1 = tableBody.findElements(By.tagName("tr")); for (WebElement tdata :
		 * tableRow1) { List<WebElement> tdata1 = tdata.findElements(By.tagName("td"));
		 * for (WebElement yy : tdata1) { System.out.print(yy.getText() + "\t"); }
		 * System.out.println();
		 * 
		 * }
		 */
		/*
		 * WebElement tbody = driver.findElement(By.tagName("tbody")); 
		 * List<WebElement>
		 * trows = tbody.findElements(By.tagName("tr")); 
		 * for (WebElement trow : trows) {
		 * List<WebElement> tdatas = trow.findElements(By.tagName("td")); 
		 * String vv =* tdatas.get(0).getText(); if (vv.equalsIgnoreCase("Google.com[2]")) { for
		 * (WebElement uu : tdatas) { System.out.print(uu.getText() + "\t"); } } }
		 */
		/*WebElement tbody = driver.findElement(By.tagName("tbody"));
		List<WebElement> trows = tbody.findElements(By.tagName("tr"));
		for (WebElement trow : trows) {
			List<WebElement> tdatas = trow.findElements(By.tagName("td"));
			for (int i = 0; i < tdatas.size(); i++) {
				String text = tdatas.get(0).getText();
				if (text.equalsIgnoreCase("Google.com[2]")) {
					System.out.println(tdatas.get(i).getText());
				}
			}

		}
*/
		/*List<WebElement> tt = driver.findElements(By.xpath("//table[1]//tbody//tr//a[text()='Yahoo']//..//..//td"));
		for (WebElement string : tt) {
			System.out.print(string.getText()+"\t");
		}*/
		
		List<WebElement> tt = driver.findElements(By.xpath("//table[1]//tbody//tr[3]//td"));
		for (WebElement string : tt) {
			System.out.print(string.getText()+"\t");
		}
		driver.quit();
	}
}
