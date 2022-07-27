package org.iit.healthcare.mmp;

import java.util.HashMap;

import org.iit.healthcare.mmp.patientmodule.pages.HomePage;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleAppointmentTest extends BaseClass{

	
	@Test 
	public void validateScheduleAppointment() throws InterruptedException
	{
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp=lp.login(pro.getProperty("uname"), pro.getProperty("pwd"));
		hp.navigateToModule("Schedule Appointment");
		ScheduleAppPage spage=new ScheduleAppPage(driver);
		
		String date=AppLibrary.getAppDate(50,"MMMM/dd/yyyy");
		 String FormattedDate=AppLibrary.getAppDate(50,"MM/dd/yyyy");
		 HashMap<String,String>ActualHMap=spage.ScheduleAppointment(date, "11Am", "Fever", pro.getProperty("doc"));
		 		
		Assert.assertEquals(ActualHMap.get("date"),FormattedDate);
		Assert.assertEquals(ActualHMap.get("time"), "11Am");
		Assert.assertEquals(ActualHMap.get("Sym"), "Fever");
		Assert.assertEquals(ActualHMap.get("doctor"), "Beth");
	}	 
		
		 
	


	
	

	
	
		
		 

		
		 


}
