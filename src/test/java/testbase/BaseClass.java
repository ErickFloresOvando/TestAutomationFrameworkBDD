package testbase;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageobjects.AddCustomerPage;
import pageobjects.LoginPage;
import org.apache.logging.log4j.Logger;   //Log4j

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class BaseClass {

    protected WebDriver driver;
    protected LoginPage lp;
    protected AddCustomerPage addCustomerPage;
    protected Logger logger;
    protected Properties p;

    public void setupBrowser() throws IOException
    {
        //Read config.properties file
        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);

        // Log4J2
        logger = LogManager.getLogger(this.getClass());
        logger.info("Launching Chrome browser");

        //Browser
        String browser = p.getProperty("browser");


        switch (browser.toLowerCase())
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                //WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                //WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new RuntimeException("Browser not supported: " + browser);
        }

        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    // Utility to generate unique emails
    public static String randomstring() {
        String generatedString1 = RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }
    //testing Push

}