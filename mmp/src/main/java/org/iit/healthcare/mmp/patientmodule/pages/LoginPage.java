package org.iit.healthcare.mmp.patientmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(name="submit")
	WebElement btnSubmit;
	
	public HomePage login(String uname,String pwd)
	{
		 username.sendKeys(uname);
		 password.sendKeys(pwd);
		 btnSubmit.click();
		 return new HomePage(driver);
	
	}

}
