package framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	public static ExtentReports extentReport;
	
	
	public static ExtentReports getInstance() {
		

			ExtentHtmlReporter html = new ExtentHtmlReporter("src\\main\\resources\\ExtentReports\\LLC_QA.html");
			html.config().setDocumentTitle("Automation FrameWork");
			html.config().setReportName(" SurfBoardCentral : ");
			html.config().setTheme(Theme.STANDARD);
			extentReport = new ExtentReports();
			extentReport.attachReporter(html);


		return extentReport;
		
		
	}

}
