package step_Definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utility.DriverFactory;

public class SortItemsSteps extends DriverFactory {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("User logs in on the website")
    public void userLogsIn(){
        getDriver();
        loginPage = new LoginPage(getDriver());
        navigateTo("https://www.saucedemo.com/v1/index.html");
        loginPage.loginAndClickButton("standard_user","secret_sauce");
    }

    @When("User presses sort button")
    public void userPressesSortButton(){
        loginPage.clickProductSortContainer();
        loginPage.setProductSortLOHI();
    }

    @Then("User sees items sorted")
    public void checkItemsAreSorted(){
        if(loginPage.itemsSortedLOHI()){
            System.out.println("ok");
        }else{
            System.out.printf("not ok");
        }
    }
}
