package step_Definition;

import commonMethods.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.DriverFactory;

import java.util.Date;

public class ClickAboutLinkSteps extends DriverFactory {

    private WebDriver driver;
    public LoginPage loginPage;

    public CommonMethods commonMethods;

    @Given("User logs in")
    public void logIn() throws InterruptedException {
        getDriver();
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
        loginPage.loginAndClickButton("standard_user","secret_sauce");
        Thread.sleep(2000);
    }

    @Then("User clicks on burger menu")
    public void clicksOnBurgerIcon() throws InterruptedException {
        loginPage.clickBurgerButton();
        Thread.sleep(2000);
    }

    @And("User clicks on about link")
    public void clicksOmAboutLink() throws InterruptedException {
        Thread.sleep(2000);
        loginPage.clickAboutLinkButton();
    }

    @Then("User sees About page")
    public void userSeesAboutPage() throws InterruptedException {
        Thread.sleep(2000);
        if(loginPage.checksAboutPageExistance()){
            System.out.printf("ok");
        }else{
            System.out.printf("not ok");
        }
    }

}
