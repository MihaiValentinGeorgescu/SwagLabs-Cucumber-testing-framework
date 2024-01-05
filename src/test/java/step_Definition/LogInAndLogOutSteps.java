package step_Definition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.ProductsPage;
import utility.DriverFactory;

public class LogInAndLogOutSteps extends DriverFactory {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Given("The user enters the page")
    public void navigateToPage(){
        getDriver(); // Ensure WebDriver is initialized
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
    }

    

}
