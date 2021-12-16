package org.pom;

import java.io.IOException;

import org.openqa.selenium.WebElement;

public class Utilization extends BaseClass{
	public static void main(String[] args) throws IOException {
		browserLaunch("https://adactinhotelapp.com/");
		//C:\Users\Dell\eclipse-workspace\Pom\testdata\login.xlsx
		//create object
		Login a = new Login();
		
		//user name
		WebElement username = a.getUsername();
		String excelData = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx", "Sheet1", 0, 0);
		enterText(username,excelData);
		
		//password
		WebElement password = a.getPassword();
		String excelData2 = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx", "Sheet1", 1, 0);
		enterText(password, excelData2);
		
		//click login
		WebElement login = a.getLogin();
		click(login);
		
		//create object
		SearchHotel b = new SearchHotel();
		
		//location
		WebElement location = b.getLocation();
		String excelData3 = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx","Sheet1" , 2, 0);
		selectByValue(location,excelData3);
		
		WebElement no_of_rooms = b.getNo_of_rooms();
		String excelData4 = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx", "Sheet1", 5, 0);
		selectByValue(no_of_rooms, excelData4);
		
		WebElement check_in_date = b.getCheck_in_date();
		check_in_date.clear();
		String excelData5 = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx", "Sheet1", 6, 0);
		enterText(check_in_date, excelData5);
		
		
		WebElement check_out_date = b.getCheck_out_date();
		check_out_date.clear();
		String excelData6 = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx", "Sheet1", 7, 0);
		enterText(check_out_date, excelData6);
		
		WebElement adults_per_room = b.getAdults_per_room();
		String excelData7 = excelData("C:\\Users\\Dell\\eclipse-workspace\\Pom\\testdata\\login.xlsx", "Sheet1", 8, 0);
		selectByValue(adults_per_room, excelData7);
		
		WebElement search = b.getSearch();
		search.click();
		
	}

}
