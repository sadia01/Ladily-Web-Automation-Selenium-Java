package utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import drivers.BaseDriver;
import drivers.PageDriver;


public class Listeners extends BaseDriver implements ITestListener {
	
	ExtentTest test;
	ExtentReports extent = ExtentFactoryReport.getReportObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@Override
	public void onTestStart(ITestResult result) 
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
	

		extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
	
		extentTest.get().fail(result.getThrowable());
		
		try 
		{
			driver = PageDriver.getCurrentDriver();
		} 
		catch (Exception e1) 
		{
		    e1.printStackTrace();
		}

		

		//Attach Screenshot to the Report
		String filePath = null;
		
		try 
		{
			
			filePath = getScreenshot(result.getMethod().getMethodName(),PageDriver.getCurrentDriver());
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
		
	}

	
	@Override
	public void onFinish(ITestContext context) 
	{

		extent.flush();
		
	}

}
