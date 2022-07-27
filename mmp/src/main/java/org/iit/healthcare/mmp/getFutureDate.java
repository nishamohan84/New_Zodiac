package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getFutureDate {

	public static void main(String[] args)
	{	
		String actual_Date=getFutureDate(3);
		System.out.println(actual_Date);
	}

	

	
	public static String getFutureDate(int days)
	{
	
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
		String date=sdf.format(cal.getTime()); //07/25/2022
		//System.out.println("Today's date:"+date);
		cal.add(Calendar.DATE, days);
		date=sdf.format(cal.getTime());
		return date;
		
	}	
		

}


