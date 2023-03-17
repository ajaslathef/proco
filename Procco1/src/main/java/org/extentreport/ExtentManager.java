package org.extentreport;

import java.io.File;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.common.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager extends BaseClass{
	
	   public static ExtentReports extent;
       public static String  screenshotPath;
       public static String  fileName;
       public  static String image_path;
       
public static ExtentReports createInstance(String fileName) {
	
    ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
   
    
    htmlReporter.config().setTheme(Theme.STANDARD);
    htmlReporter.config().setDocumentTitle(fileName);
    htmlReporter.config().setEncoding("utf-8");
    htmlReporter.config().setReportName(fileName);
    
    extent = new ExtentReports();
    extent.attachReporter(htmlReporter);
    extent.setSystemInfo("Automation Tester", "Ajas Latheef");
    extent.setSystemInfo("Organization", "Xilligence");
    extent.setSystemInfo("Build no", "DEMO");
    
    
    return extent;
}


public static void captureScreenshot( ) throws Exception, SQLException {
	Date d = new Date();
	String fileName = d.toString().replace(":", "_").replace(" ", "_");
	File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshot, new File("./reports/screenshot/"+fileName+".jpg"));
	
	 image_path ="../reports/screenshot/"+fileName+".jpg";
	System.out.println("Screenshot path is "+image_path);
	
	return ;	
}


}
