package step_Definition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AfterLoginPage;
import pages.LoginPage;
import utility.DriverFactory;

public class LogOutScenarioSteps extends DriverFactory {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("the user is on the swaglabs login page")
    public void navigateToLoginPage() {
        getDriver(); // Ensure WebDriver is initialized
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
    }

    @When("the user enters invalid credentials")
    public void enterValidCredentials() {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        loginPage.enterUsername("standard_usser");
        loginPage.enterPassword("secret_sausce");
    }

    @When("clicks the Login button for invalid credentials")
    public void clickLoginButton() throws InterruptedException {
        loginPage.clickLoginButton();
        Thread.sleep(2000);
    }

    @Then("the user should be see error login")
    public void verifySuccessfulLogin() throws InterruptedException {
        AfterLoginPage afterLoginPage = new AfterLoginPage(getDriver());

        if(loginPage.checkElementAfterInvalidLogin()){
            System.out.printf("yes");
        }else{
            System.out.printf("no");
        }
        Thread.sleep(2000);
    }

    @After
    public void closeBrowser() {
        quitDriver();
    }
}
