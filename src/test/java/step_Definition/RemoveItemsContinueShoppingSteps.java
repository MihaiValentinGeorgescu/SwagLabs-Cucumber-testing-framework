package step_Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.DriverFactory;

import static org.junit.Assert.assertTrue;

public class RemoveItemsContinueShoppingSteps extends DriverFactory {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User logs in to the website to shop")
    public void loginToPage(){
        getDriver(); // Ensure WebDriver is initialized
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
        loginPage.loginAndClickButton("standard_user","secret_sauce");
    }

    @When("Shops an item and presses on the cart link")
    public void shopItems(){
        loginPage.addToCart("Sauce Labs Backpack");
        loginPage.clickCartButton();
    }

    @And("User removes item and continues shopping")
    public void removeItems() throws InterruptedException {
        loginPage.remove_item_button("Sauce Labs Backpack");
        Thread.sleep(2000);
    }

    @Then("Cart is empty")
    public void checkCartIsEmpty() throws InterruptedException {
        boolean isCartEmpty = loginPage.check_cart_is_empty();

        // Perform assertions based on the result
        System.out.printf("Is cart empty? " + isCartEmpty);
    }

}
