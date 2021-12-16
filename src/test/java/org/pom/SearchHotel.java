package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotel extends BaseClass{
	public SearchHotel() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="room_nos")
	private WebElement no_of_rooms;
	
	@FindBy(xpath="//input[@id='datepick_in']")
	private WebElement check_in_date;
	
	@FindBy(id="datepick_out")
	private WebElement check_out_date;
	
	@FindBy(id="adult_room")
	private WebElement adults_per_room;
	
	@FindBy(id="Submit")
	private WebElement search;
	
	public WebElement getLocation() {
		return location;
	}

	public WebElement getNo_of_rooms() {
		return no_of_rooms;
	}

	public WebElement getCheck_in_date() {
		return check_in_date;
	}

	public WebElement getCheck_out_date() {
		return check_out_date;
	}

	public WebElement getAdults_per_room() {
		return adults_per_room;
	}

	public WebElement getSearch() {
		return search;
	}
	
	

}
