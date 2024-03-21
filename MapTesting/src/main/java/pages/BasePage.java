package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentManager;

public class BasePage {
	 protected WebDriver driver;
	    protected WebDriverWait wait;
	    protected Properties prop;
	    protected ExtentReports extent;
	    protected ExtentTest logger;

	    public BasePage() {
	    	extent = ExtentManager.createInstance("report.html");
	        //System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	        prop = new Properties();
	        try {
	            prop.load(new FileInputStream("src/main/java/config/Configuration.properties"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        extent = ExtentManager.createInstance("extent.html");
	        logger = extent.createTest("Test Case Name");
	    }
	    
	    public void closeBrowser() {
	        extent.flush();
	        driver.quit();
	    }

}
