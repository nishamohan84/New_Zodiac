package org.iit.healthcare.mmp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AppLibrary {
	
	 public static String getAppDate(int days,String format)
	 {
		 Calendar cal=Calendar.getInstance();
		 SimpleDateFormat sdf=new SimpleDateFormat(format);
		 String date=sdf.format(cal.getTime());
		 cal.add(Calendar.DATE, days);
		 date=sdf.format(cal.getTime());
		 return date;
	 }

}
