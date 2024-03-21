package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	private static ExtentReports extent;

    public static ExtentReports createInstance(String fileName) {
        String outputDirectory = System.getProperty("user.dir") + File.separator + "extent-reports";
        File dir = new File(outputDirectory);
        if (!dir.exists()) {
            dir.mkdirs(); // Create directory if it doesn't exist
        }
        
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(outputDirectory + File.separator + fileName);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }
	}


