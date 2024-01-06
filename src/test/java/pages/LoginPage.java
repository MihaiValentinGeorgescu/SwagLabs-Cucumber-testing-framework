package pages;

import commonMethods.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.DriverFactory;

public class LoginPage extends CommonMethods {
    private WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//img[@class='bot_column']")
    private WebElement loginImage;

    @FindBy(xpath = ".//button")
    private WebElement burgerButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logOutButton;

    @FindBy(xpath = "//a[@id='about_sidebar_link']")
    private WebElement aboutLink;

    @FindBy(xpath = "//span/img")
    private WebElement imageAboutPage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {

        WebDriverWait wait = new WebDriverWait(driver, 10);
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

        if (errorElement.isDisplayed()) {
            System.out.println("The error element is displayed.");
            return true;

        } else {
            System.out.println("The error element is not displayed.");
        }
        return false;
    }

    public void loginAndClickButton(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public boolean checkLogOutState(){
        if(loginImage.isDisplayed()){
            return true;
        }
        return false;
    }

    public void clickBurgerButton(){
//        burgerButton.click();
        try {
            // Wait for the button to be clickable
            WebElement burgerButtonElement = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='bm-burger-button']")));

            WebElement menuButton = burgerButtonElement.findElement(By.xpath(".//button"));
            menuButton.click();
        } catch (ElementNotInteractableException e) {
            // Handle the exception or log an error message
            System.out.println("Error: Unable to click the burger button.");
            e.printStackTrace();
        }
    }

    public void clickLogOutButton(){
        logOutButton.click();
    }

    public void clickAboutLinkButton(){
        aboutLink.click();
    }

    public boolean checksAboutPageExistance(){
        if(imageAboutPage.isDisplayed()){
            return true;
        }
        return false;
    }
}
