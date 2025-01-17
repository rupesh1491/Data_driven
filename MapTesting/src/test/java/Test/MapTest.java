package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BasePage;
import utils.ExtentManager;
import utils.TestUtils;

public class MapTest extends BasePage{

	public MapTest() {
        super();
    }

    @BeforeMethod
    public void setupTest() {
        // No setup needed in this class
    }

    @Test
    public void testGoogleSearch() {
        // Navigate to Google
        driver.get(prop.getProperty("url"));
        logger.log(Status.INFO, "Navigated to URL: " + prop.getProperty("url"));

        // Perform Google login (if required)

        // Search for "phone"
        TestUtils.findElement(driver, "searchBox").sendKeys("phone");
       // TestUtils.findElement(driver, "firstSearchResult").submit();
        logger.log(Status.INFO, "Performed search for 'phone'");

        // Click on the first search result
        TestUtils.clickElement(driver, "firstSearchResult");
        logger.log(Status.INFO, "Clicked on the first search result");

        // Perform actions on the clicked page

        // Close the browser
      //  //closeBrowser();
       // logger.log(Status.INFO, "Closed the browser");
    }

    @AfterMethod
    public void teardownTest() {
        // No teardown needed in this class
    	 closeBrowser();
         logger.log(Status.INFO, "Closed the browser");
    }
}
