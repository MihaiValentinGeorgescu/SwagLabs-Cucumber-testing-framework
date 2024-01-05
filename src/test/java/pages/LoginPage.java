package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
//        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean checkElementAfterInvalidLogin(){
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));

        // Check if the element is displayed
        if (errorElement.isDisplayed()) {
            System.out.println("The error element is displayed.");
            return true;

        } else {
            System.out.println("The error element is not displayed.");
        }
        return false;
    }
}
