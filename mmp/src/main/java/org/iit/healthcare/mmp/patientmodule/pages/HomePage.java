package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	

	
	public void navigateToModule(String modulename)
	{
	driver.findElement(By.xpath("//span[normalize-space()='"+modulename+"']")).click();

	}
}
