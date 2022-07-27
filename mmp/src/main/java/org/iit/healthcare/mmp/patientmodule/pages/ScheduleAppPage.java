package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.List;

import org.iit.healthcare.mmp.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppPage {
	
	protected WebDriver driver;
	
	public ScheduleAppPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	String doctorName;
	
	 By newAppointmentButton=By.xpath("//input[@value='Create new appointment']");
	 By doctorNameBy=By.xpath("//h4[normalize-space()='Dr."+doctorName+"']/ancestor::ul/following-sibling::button");
	 By datepicker=By.id("datepicker");
	 By datepickerYear=By.xpath("//span[@class='ui-datepicker-year']");
	 By navigateButton=By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
	 By datepickermonth=By.xpath("//span[@class='ui-datepicker-month']");
	 By allthedates=By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td");
	// String exp_dt;
	// By datePickerID=By.linkText(exp_dt);
	 By timedropdown= By.xpath("//select[@id='time']");
	 By continueButton=By.xpath("//button[@id='ChangeHeatName']");
	 By symptomsId=By.xpath("//textarea[@id='sym']");
	 By submitButton=By.xpath("//input[@value='Submit']");
	 By actualdateXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[1]");
	 By actualtimeXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[2]");
	 By actualAppointmentXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[3]");
	 By actualdoctorXpath=By.xpath("//table[@class='table']/tbody/tr[1]/td[4]");


	public HashMap<String, String> ScheduleAppointment(String date,String time,String sym,String doctorName) throws InterruptedException
	 {
		 HashMap<String,String>hMap=new HashMap<String,String>();
		 
		 driver.findElement(newAppointmentButton).click();
		 this.doctorName=doctorName;
		 driver.findElement(By.xpath("//h4[normalize-space()='Dr."+this.doctorName+"']/ancestor::ul/following-sibling::button")).click();
		 
		 driver.switchTo().frame("myframe");
		 driver.findElement(datepicker).click();

		 	String expectedDate=date;
	 		
	 		String date_array[]=expectedDate.split("/");
	 		String exp_mon=date_array[0];
	 		String exp_dt=date_array[1]; //03
	 		//s.replaceFirst("^0+(?!$)", "")
	 		String exp_yr=date_array[2];
	 		
		 String act_year=driver.findElement(datepickerYear).getText();
		 while(!(exp_yr.equals(act_year)))
		 {
			 driver.findElement(navigateButton).click();
			 act_year=driver.findElement(datepickerYear).getText();
		 }
		 
		 String act_mon=driver.findElement(datepickermonth).getText();
		 while(!(exp_mon.equals(act_mon)))
		 {
			 driver.findElement(navigateButton).click();
			  act_mon=driver.findElement(datepickermonth).getText();
		 }
		 
//			// driver.findElement(By.linkText(exp_dt)).click();  //---Not working
			List<WebElement>alldates= driver.findElements(allthedates);
			for(WebElement D:alldates)
			{
				String dt=D.getText();
				if(dt.equals(exp_dt))
				{
					D.click();
				}
			}
		 
		Select dropdown=new Select (driver.findElement(timedropdown));
		dropdown.selectByVisibleText(time);
		
		driver.findElement(continueButton).click();
		Thread.sleep(3000);
		driver.findElement(symptomsId).sendKeys(sym);
		driver.findElement(submitButton).click();
		
		String actualDate=driver.findElement(actualdateXpath).getText();
		String ActualTime=driver.findElement(actualtimeXpath).getText();
		String ActualSym=driver.findElement(actualAppointmentXpath).getText();
		String ActualDoctor=driver.findElement(actualdoctorXpath).getText();
		
		hMap.put("date", actualDate);
		hMap.put("time", ActualTime);
		hMap.put("Sym", ActualSym);
		hMap.put("doctor", ActualDoctor);
		return hMap;
		
	 }

}
