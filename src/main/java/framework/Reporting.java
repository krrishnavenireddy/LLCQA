package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Reporting extends Driver implements ITestListener {
	
	public static ExtentReports extent = ExtentManager.getInstance();
	public static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	
	

	public void onTestStart(ITestResult result) {
		
		ExtentTest test = extent.createTest(result.getTestClass().getName() +"::"+ result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {

		String logText = "<b> Test Method" + result.getMethod().getMethodName() +" Sucessful</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		extenttest.get().log(Status.PASS, m);
		
	}

	public void onTestFailure(ITestResult result) {


		String logText = "<b> Test Method" + result.getMethod().getMethodName() +"Failed</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		extenttest.get().log(Status.FAIL, m);
		try {

			ScreenshotUtils.captureScreenshot();
			extenttest.get().fail("<b><font color=red>Screenshot of failure</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtils.screenshotName.get()).build());
		} catch (IOException e) {
			logger.info("Cannot take screenshot");
		}


	}

	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
