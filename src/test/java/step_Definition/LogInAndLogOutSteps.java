package step_Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utility.DriverFactory;

import javax.sound.midi.Soundbank;

public class LogInAndLogOutSteps extends DriverFactory {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("The user enters the page")
    public void navigateToPage() {
        getDriver(); // Ensure WebDriver is initialized
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
    }

    @When("The user enters valid credentials then clicks on the log in button")
    public void enterCredentialsAndLogin() throws InterruptedException {
        loginPage.loginAndClickButton("standard_user", "secret_sauce");
        Thread.sleep(2000);
    }

    @And("Then user clicks on menu and logs out")
    public void logOut() throws InterruptedException {
        loginPage.clickBurgerButton();
        Thread.sleep(2000);
        loginPage.clickLogOutButton();
        Thread.sleep(2000);
    }

    @Then("the user should get back the before screen")
    public void checkLogOutText() throws InterruptedException {
        if (loginPage.checkLogOutState()) {
            System.out.printf("OK");
        } else {
            System.out.printf("NO");
        }
    }

}
