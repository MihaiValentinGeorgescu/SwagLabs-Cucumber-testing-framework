package step_Definition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AfterLoginPage;
import pages.LoginPage;
import utility.DriverFactory;

public class LoginSteps extends DriverFactory {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the OrangeHRM login page")
    public void navigateToLoginPage() {
        getDriver(); // Ensure WebDriver is initialized
        loginPage = new LoginPage(getDriver());
        navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the user enters valid credentials")
    public void enterValidCredentials() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
    }

    @When("clicks the Login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be logged in successfully")
    public void verifySuccessfulLogin() {
        AfterLoginPage afterLoginPage = new AfterLoginPage(getDriver());

        if (afterLoginPage.isYourElementDisplayed()) {
            System.out.println("Element on the next page is displayed. Login flow is successful.");
        } else {
            System.out.println("Element on the next page is NOT displayed. Login flow failed.");
        }
    }

    @After
    public void closeBrowser() {
        quitDriver();
    }
}
