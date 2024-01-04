package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.DriverFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;

    @FindBy(name = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']//button[@type='submit']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameField.click();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
