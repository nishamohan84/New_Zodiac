package org.iit.healthcare.mmp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	protected WebDriver driver;
	protected Properties pro;
	
	 @BeforeClass
	 public void launch() throws IOException
	 {
		 loadProperties();

	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
	 driver.manage().window().maximize();
	 }
	 
	 public void loadProperties() throws IOException
	 {
	 File f=new File("config/mmp.properties");
	 FileInputStream fis=new FileInputStream(f.getAbsolutePath());
	 pro=new Properties();
	 pro.load(fis);
	 }

}
