package org.jira;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestJiraListner implements ITestListener {  

	public static WebDriver driver;

	public void onTestStart(ITestResult result) {  
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestFailure(ITestResult result) {
		boolean jirapolicy = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(JiraPolicy.class)==null;

		if(jirapolicy){

			//Raise a ticket
			System.out.println("Bug is raised in Jira");
			JiraServiceProvider sp = new JiraServiceProvider("https://xillidev.atlassian.net/", "shameerali@xilligence.com", "nmKAnlWP1qoY4ktSRhH73BE2", "PRT");

			String issueSummary1 = result.getMethod().getConstructorOrMethod().getMethod().getName()
					+ "got failed due to some assertion or exception";
			String issueSummary = issueSummary1.replaceAll("_", " ");
			System.out.println("issueSummary is " + issueSummary);

			String issueDesc = result.getThrowable().getMessage() + "\n";
			issueDesc.concat(ExceptionUtils.getFullStackTrace(result.getThrowable()));

			System.out.println("issueDesc is "+issueDesc);
			try {
				sp.createJiraTicket1("Bug", issueSummary, issueDesc, "Ajas Latheef");
				System.out.println("Passed");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
