package step_Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.DriverFactory;

public class ShopSteps extends DriverFactory {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User logs in with valid credentials to the website saucedemo")
    public void userLogsIn() throws InterruptedException {
        getDriver();
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
        loginPage.loginAndClickButton("standard_user","secret_sauce");
        Thread.sleep(2000);
    }

    @When("User shops and presses cart button")
    public void shopAndPressOnCartButton(){
        loginPage.addToCart("Sauce Labs Backpack");
        loginPage.clickCartButton();
    }

    @And("User presses chekout button and completes the form for checkout and presses contiue button")
    public void checkoutCompleteFormAndContinue(){
        loginPage.clickCheckoutButton();
        loginPage.insert_text_first_name();
        loginPage.insert_text_last_name();
        loginPage.insert_text_postal_code();
        loginPage.press_continue_checkout_info_button();
    }

    @Then("User clicks finish button and sees final image for Pony Express Sauce Labs")
    public void clickFinishButtonPonyExpressImageValidation(){
        loginPage.press_finish_shopping_button();
        if(loginPage.check_pony_final_image_after_shopping()){
            System.out.println("ok");
        }else{
            System.out.printf("not ok");
        }
    }
}
