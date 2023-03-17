package org.extentreport;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class TestListener implements ITestListener {
	
	static Date d = new Date();
	
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {

		
		ExtentTest test = extent.createTest("TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
    
	}
	
	
	
	//  ------ Success Report Customization --------

	public void onTestSuccess(ITestResult result) {
		
			
	String methodName=result.getMethod().getMethodName();
	
	String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";
	
	Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);

	testReport.get().pass(m);		
		try {
			 ExtentManager.captureScreenshot();
			} catch (SQLException e) {
		 e.printStackTrace();
			} catch (Exception e) {			
		 e.printStackTrace();
			 }
	}

	
//  ------ Failed Report Customization --------
	
	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();

		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " IS FAILED"+"</b>";
			
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			testReport.get().log(Status.FAIL, m);

		String excepionMessage= result.getThrowable().getMessage();
		
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
		
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
					
		try {	
			ExtentManager.captureScreenshot();			
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.image_path).build());				 
			System.out.println("Screenshot path isssss "+ ExtentManager.image_path);		
			System.out.println("Screenshot added successfully");
			System.out.println("**********************************");
			System.out.println("Screenshot added successfully");
			
		} catch (IOException e) {

		} catch (Exception e) {		
			e.printStackTrace();		
		}
	}

  public void onTestSkipped(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";	
		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().log(Status.SKIP, m);
			
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}


}
