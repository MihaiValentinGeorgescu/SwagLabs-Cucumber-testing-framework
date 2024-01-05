package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage {
    @FindBy(xpath = "//button[@style='position: absolute; left: 0px; top: 0px; width: 100%; height: 100%; margin: 0px; padding: 0px; border: none; opacity: 0; font-size: 8px; cursor: pointer;']")
    private WebElement burgerButton;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement logOutButton;

    @FindBy(xpath = "//img[@class='bot_column']")
    private WebElement loginImage;

    public void clickBurgerButton(){
        burgerButton.click();
    }

    public void clickLogOutButton(){
        logOutButton.click();
    }

    public boolean checkLogOutState(){
        if(loginImage.isDisplayed()){
            return true;
        }
        return false;
    }
}
