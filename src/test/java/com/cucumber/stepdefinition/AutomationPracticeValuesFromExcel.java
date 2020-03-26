package com.cucumber.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import com.cucumber.functionallibrary.BaseClass;
import com.cucumber.pom.*;


public class AutomationPracticeValuesFromExcel extends BaseClass {

	public static void main(String[] args) throws Exception {

		browserConfig("chrome");
		getUrl("http://automationpractice.com/index.php");

		HomePage hp = new HomePage();
		click(hp.getSignIn());
		readDataFromExcel();
		Thread.sleep(5000);
		driver.quit();

	}

	public static void readDataFromExcel() throws Exception {

		MyAccount ma = new MyAccount();
		PersonalInfo pg = new PersonalInfo();

		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheet("Sheet3");
		int numberOfRows = sheetAt.getPhysicalNumberOfRows();
		Row row = sheetAt.getRow(0);
		int noofCells = row.getPhysicalNumberOfCells();
		for (int i = 1; i < noofCells; i++) {
			
				homePage();
			
			String gender = sheetAt.getRow(0).getCell(i).getStringCellValue();

			if (gender.contains("Mr"))
				pg.getG().get(0).click();
			else
				pg.getG().get(1).click();

			String fname = sheetAt.getRow(1).getCell(i).getStringCellValue();
			String lname = sheetAt.getRow(2).getCell(i).getStringCellValue();
			String pwd = sheetAt.getRow(3).getCell(i).getStringCellValue();

			Date dateValue = sheetAt.getRow(4).getCell(i).getDateCellValue();
			Calendar cal = Calendar.getInstance();
			cal.setTime(dateValue);
			int date = cal.get(Calendar.DATE);
			String ddValue = String.valueOf(date);
			int month = cal.get(Calendar.MONTH) + 1;
			String mmValue = String.valueOf(month);
			int year = cal.get(Calendar.YEAR);
			String yyValue = String.valueOf(year);

			String newsletter = sheetAt.getRow(5).getCell(i).getStringCellValue();
			if (newsletter.contains("Yes")) {
				pg.getChkList().get(0).click();
			}
			String offers = sheetAt.getRow(6).getCell(i).getStringCellValue();
			if (offers.contains("Yes")) {
				pg.getChkList().get(1).click();
			}
			String company = sheetAt.getRow(7).getCell(i).getStringCellValue();
			String address = sheetAt.getRow(8).getCell(i).getStringCellValue();
			String city = sheetAt.getRow(9).getCell(i).getStringCellValue();
			String state = sheetAt.getRow(10).getCell(i).getStringCellValue();
			double pincode = sheetAt.getRow(11).getCell(i).getNumericCellValue();
			long l2 = (long) pincode;
			String value = String.valueOf(l2);
			String addinfo = sheetAt.getRow(12).getCell(i).getStringCellValue();
			double ph = sheetAt.getRow(13).getCell(i).getNumericCellValue();
			long l = (long) ph;
			String phValue = String.valueOf(l);
			double mobile = sheetAt.getRow(14).getCell(i).getNumericCellValue();
			long l1 = (long) mobile;
			String mobileValue = String.valueOf(l1);
			String alias = sheetAt.getRow(15).getCell(i).getStringCellValue();

			sendKeys(pg.getFname(), fname);
			sendKeys(pg.getLname(), lname);
			sendKeys(pg.getPwd(), pwd);
			selectDropDown(pg.getDays(), ddValue, "value");
			selectDropDown(pg.getMonths(), mmValue, "value");
			selectDropDown(pg.getYears(), yyValue, "value");
			sendKeys(pg.getCompany(), company);
			sendKeys(pg.getAddress(), address);
			sendKeys(pg.getCty(), city);
			selectDropDown(pg.getState(), state, "visibletext");
			sendKeys(pg.getPinCode(), value);
			sendKeys(pg.getAddInfo(), addinfo);
			sendKeys(pg.getPh(), phValue);
			sendKeys(pg.getMobile(), mobileValue);
			sendKeys(pg.getAliasAdd(), alias);

			click(pg.getRegister());
			placeOrderUsingSearch();
			
			ShoppingSummary ss=new ShoppingSummary();		
			String txt1 = getElementText(ss.getPrice());		
			String txt2=getElementText(ss.getAccOwner());
			String txt3=getElementText(ss.getBankName());
			//String txt4=getElementText(ss.getRefno());
			//System.out.println(txt4);
			
			Cell cell = row.getCell(i);
			if(cell==null)
			{
				System.out.println("Cell Created");
				cell=row.createCell(i);
			}
			sheetAt.getRow(20).createCell(i).setCellValue(txt1);
			sheetAt.getRow(21).createCell(i).setCellValue(txt2);
			sheetAt.getRow(22).createCell(i).setCellValue(txt3);	
		
		
			click(ma.getSignOut());
			

		}
		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
		wb.close();


	}
	
	public static void placeOrderUsingSearch() throws Exception {

		
		MyAccount ma=new MyAccount();
		ShoppingSummary ss=new ShoppingSummary();
		Assert.assertTrue(displayed(ma.getSearch()));
		Assert.assertTrue(enabled(ma.getSearch()));
		sendKeys(ma.getSearch(),"T-shirts");
		click(ma.getSubmitSearch());
		click(ma.getImg());
		click(ma.getPlus());
		selectDropDown(ma.getSize(),"M","visibletext");
		click(ma.getColor());
		click(ma.getAddCart());
		click(ma.getCheckOut());
		click(ss.getProceed());
		click(ss.getProceed());
		scrollDownByPixel(0, 500);
		ss.getTc().click();
		click(ss.getChk());
		click(ss.getPayment());
		click(ss.getConfirm());
		
		//setDataToExcel();
	}

	public static void setDataToExcel() throws Exception {
		ShoppingSummary ss=new ShoppingSummary();		
		String txt1 = getElementText(ss.getPrice());		
		System.out.println(txt1);
		String txt2=getElementText(ss.getAccOwner());
		System.out.println(txt2);
		String txt3=getElementText(ss.getBankName());
		System.out.println(txt3);
		//String txt4=getElementText(ss.getRefno());
		//System.out.println(txt4);
		
		File f = new File("E:\\POI\\Test.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheet("Sheet3");
		int numberOfRows = sheetAt.getPhysicalNumberOfRows();
			Row row = sheetAt.getRow(20);
			int noofCells = row.getPhysicalNumberOfCells();
			for(int j=1;j<noofCells;j++)
			{
			Cell cell = row.getCell(j);
			if(cell==null)
			{
				System.out.println("Cell Created");
				cell=row.createCell(j);
			}
			sheetAt.getRow(20).createCell(j).setCellValue(txt1);
			sheetAt.getRow(21).createCell(j).setCellValue(txt2);
			sheetAt.getRow(22).createCell(j).setCellValue(txt3);	
		
		}
		FileOutputStream fout = new FileOutputStream(f);
		wb.write(fout);
		wb.close();
	}
	
	public static void homePage() {
		LoginIn lp = new LoginIn();
		jsExecutor(lp.getEmail());
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

		RandomStringUtils r = new RandomStringUtils();
		String alphaNum = r.randomAlphanumeric(8);
		String concatS1 = alphaNum.concat("@gmail.com");
		lp.getEmail().sendKeys(concatS1);
		boolean matches = concatS1.matches(regex);
		click(lp.getSubmit());

	}

}
