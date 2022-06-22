package seng426.team14.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {

	protected WebDriver driver;

	/**
	 * constructor
	 */
	public Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	} 
	
	public Page() {
		
	}
	

	public void setDriver(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	} 
	
}
