package org.pom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	//URL
	public static void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//locator
	public static WebElement locator(String type, String attributeValue) {
		if(type.equals("id")) {
			WebElement element = driver.findElement(By.id(attributeValue));
			return element;
		}
		else if(type.equals("name")) {
			WebElement findElement = driver.findElement(By.name(attributeValue));
			return findElement;
		}
		else {
			WebElement findElement = driver.findElement(By.xpath(attributeValue));
			return findElement;
		}
	}
	//send keys
	public static void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}
	//click
	public static void click(WebElement element) {
		element.click();
	}
	//drop down by index
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	//drop down by value
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	//read data from excel
	public static String excelData(String path, String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File(path);
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		if(cellType==1) {
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String format = simpleDateFormat.format(dateCellValue);
			return format;
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long)numericCellValue;
			String valueOf = String.valueOf(l);
			return valueOf;
		}
	}
	
	
	
	
}
