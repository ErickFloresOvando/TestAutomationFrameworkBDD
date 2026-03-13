package stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import pageobjects.AddCustomerPage;
import pageobjects.LoginPage;
import testbase.BaseClass;

import org.apache.logging.log4j.LogManager;  //Log4j

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException {
        // Call the method from the parent BaseClass
        setupBrowser();
    }

    @Given("User launch Chrome browser")
    public void user_launch_chrome_browser() {
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        logger.info("Opening URL :{}" , url);
        driver.get(url);
    }

    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String email, String password) {
        logger.info("Entering email as {} and password {}", email, password);
        lp.setUserName(email);
        lp.setPassword(password);

    }

    @When("Click on Login")
    public void click_on_login() {

        logger.info("Clicking on Login");
        lp.clickLogin();

    }

    @Then("Page Title should be {string}")
    public void page_title_should_be(String title) {

        if (driver.getPageSource().contains("Login was successful")) {
            logger.info("Test FAILED");
            driver.quit();
            Assert.assertTrue(false);

        }else {
            logger.info("Test PASSED");
            Assert.assertEquals(driver.getTitle(), title);
        }

    }

    @When("User click on Log out link")
    public void user_click_on_log_out_link() {
        logger.info("Clicking on Log out");
        lp.clickLogout();

    }

    @Then("close browser")
    public void close_browser() {
        logger.info("Closing Browser");
        driver.quit();
    }


    // Customer feature step definitions .......
    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {

        addCustomerPage = new AddCustomerPage(driver);
        Assert.assertEquals(addCustomerPage.getPageTitle(),"Dashboard / nopCommerce administration");

    }

    @When("User click on customers Menu")
    public void user_click_on_customers_menu() {
       addCustomerPage.clickOnCustomersMenu();
    }

    @When("click on customers Menu Item")
    public void click_on_customers_menu_item() {
        addCustomerPage.clickOnCustomersMenuItem();
    }

    @When("click on Add new button")
    public void click_on_add_new_button() {
        addCustomerPage.clickOnAddCustomer();
    }

    @Then("User can view Add new customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals(addCustomerPage.getPageTitle(),"Add a new customer / nopCommerce administration");
    }

    @When("User enter customer info")
    public void user_enter_customer_info() {
        String email = randomstring() + "@gmail.com";
        addCustomerPage.setEmail(email);
        addCustomerPage.setPassword("test123");
        addCustomerPage.setCustomerRoles("Guests");

    }

    @When("click on Save button")
    public void click_on_save_button() {
        
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}