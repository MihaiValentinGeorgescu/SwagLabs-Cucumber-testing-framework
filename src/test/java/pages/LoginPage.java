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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement productSortContainer;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[@value='az']")
    private WebElement productSortAZ;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[@value='za']")
    private WebElement productSortZA;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[@value='lohi']")
    private WebElement productSortLOHI;

    @FindBy(xpath = "//select[@class='product_sort_container']//option[@value='hilo']")
    private WebElement productSortHILO;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> priceElements;

    List<Double> prices = new ArrayList<>();

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> nameElements;

    List<String> names = new ArrayList<>();

    @FindBy(xpath = "//a[@class='shopping_cart_link fa-layers fa-fw']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='btn_action checkout_button']")
    private WebElement checkoutButton;

    @FindBy(xpath = "//div[@class='checkout_info']//input[@id='first-name']")
    private WebElement checkout_info_first_name;

    @FindBy(xpath = "//div[@class='checkout_info']//input[@id='last-name']")
    private WebElement checkout_info_last_name;

    @FindBy(xpath = "//div[@class='checkout_info']//input[@id='postal-code']")
    private WebElement checkout_info_postal_code;

    @FindBy(xpath = "//div[@class='checkout_buttons']//input[@type='submit']")
    private WebElement checkout_info_continue_button;

    @FindBy(xpath = "//div[@class='cart_footer']//a[@class='btn_action cart_button']")
    private WebElement overview_submit_button;

    @FindBy(xpath = "//img[@class='pony_express']")
    private WebElement finish_shopping_image;

    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Backpack')]")
    private WebElement sauce_labs_backpack;

    @FindBy(xpath = "//div[@class='inventory_details_desc_container']//button[@class='btn_primary btn_inventory']")
    private WebElement sauce_labs_add_to_cart_universal_button;

    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Bike Light')]")
    private WebElement sauce_labs_bikelight;

    @FindBy(xpath = "")
    private WebElement sauce_labs_bikelight_add_to_cart;

    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Bolt T-Shirt')]")
    private WebElement sauce_labs_boltTshirt;

    @FindBy(xpath = "")
    private WebElement sauce_labs_boltTshirt_add_to_cart;

    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Fleece Jacket')]")
    private WebElement sauce_labs_fleece_jacket;

    @FindBy(xpath = "")
    private WebElement sauce_labs_fleece_jacket_add_to_cart;

    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name' and contains(text(), 'Sauce Labs Onesie')]")
    private WebElement sauce_labs_onesie;

    @FindBy(xpath = "")
    private WebElement sauce_labs_onesie_add_to_cart;

    @FindBy(xpath = "//a[@id='item_4_title_link']//div[@class='inventory_item_name' and contains(text(), 'Test.allTheThings() T-Shirt (Red)')]")
    private WebElement sauce_labs_tshirt_red;

    @FindBy(xpath = "")
    private WebElement sauce_labs_tshirt_red_add_to_cart;

    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    private WebElement shopping_cart_badge;

    @FindBy(xpath = "//button[@class='btn_secondary btn_inventory']")
    private WebElement remove_item_button_cart;

    @FindBy(xpath = "//button[@class='inventory_details_back_button']")
    private WebElement inventory_details_back_button;

    @FindBy(xpath = "//a[@class='btn_secondary']")
    private WebElement continue_shopping_button;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Onesie']")
    private WebElement remove_Sauce_Labs_Onesie;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']")
    private WebElement remove_Sauce_Labs_Bike_Light;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bolt T-Shirt']")
    private WebElement remove_Sauce_Labs_Bolt_T_Shirt;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Fleece Jacket']")
    private WebElement remove_Sauce_Labs_Fleece_Jacket;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")
    private WebElement remove_Sauce_Labs_Backpack;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Test.allTheThings() T-Shirt (Red)']")
    private WebElement remove_T_Shirt_Red;


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

    public void clickProductSortContainer(){
        click(productSortContainer);
    }

    public void sortAZ(){
        click(productSortAZ);
    }

    public void setProductSortZA(){
        click(productSortZA);
    }

    public void setProductSortLOHI(){
        click(productSortLOHI);
    }

    public void setProductSortHILO(){
        click(productSortHILO);
    }

    public boolean itemsSortedLOHI(){
        for (WebElement priceElement : priceElements) {
            // Extracting and converting the price text to a Double
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }

        // Check if the prices are sorted in ascending order
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                System.out.println("Items are not sorted in ascending order.");
                return false;
            }
        }

        System.out.println("Items are sorted in ascending order.");
        return true;
    }

    public boolean itemsSortedHILO(){
        for (WebElement priceElement : priceElements) {
            // Extracting and converting the price text to a Double
            String priceText = priceElement.getText().replace("$", "");
            prices.add(Double.parseDouble(priceText));
        }

        // Check if the prices are sorted in ascending order
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                System.out.println("Items are not sorted in ascending order.");
                return false;
            }
        }

        System.out.println("Items are sorted in ascending order.");
        return true;
    }

    public boolean itemsSortedAZ(){
        for (WebElement nameElement : nameElements) {
            // Extracting the product name text
            names.add(nameElement.getText());
        }

        // Check if the names are sorted
        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) > 0) {
                System.out.println("Items are not sorted by name.");
                return false;
            }
        }

        System.out.println("Items are sorted by name.");
        return true;
    }

    public boolean itemsSortedZA(){
        for (WebElement nameElement : nameElements) {
            // Extracting the product name text
            names.add(nameElement.getText());
        }

        // Check if the names are sorted
        for (int i = 0; i < names.size() - 1; i++) {
            if (names.get(i).compareTo(names.get(i + 1)) < 0) {
                System.out.println("Items are not sorted by name.");
                return false;
            }
        }

        System.out.println("Items are sorted by name.");
        return true;
    }

    public void addToCart(String itemType) {
        switch (itemType) {
            case "Sauce Labs Backpack":
                click(sauce_labs_backpack);
                click(sauce_labs_add_to_cart_universal_button);
                break;
            case "Sauce Labs Bike Light":
                click(sauce_labs_bikelight);
                click(sauce_labs_add_to_cart_universal_button);
                break;
            case "Sauce Labs Bolt T-Shirt":
                click(sauce_labs_boltTshirt);
                click(sauce_labs_add_to_cart_universal_button);
                break;
            case "Sauce Labs Fleece Jacket":
                click(sauce_labs_fleece_jacket);
                click(sauce_labs_add_to_cart_universal_button);
                break;
            case "Sauce Labs Onesie":
                click(sauce_labs_onesie);
                click(sauce_labs_add_to_cart_universal_button);
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                click(sauce_labs_tshirt_red);
                click(sauce_labs_add_to_cart_universal_button);
                break;
            default:
                System.out.println("Unsupported item type: " + itemType);
                break;
        }
    }

    public void clickCartButton(){
        click(shoppingCart);
    }

    public void clickCheckoutButton(){
        click(checkoutButton);
    }

    public void insert_text_first_name(){
        click(checkout_info_first_name);
        checkout_info_first_name.sendKeys("test name");
    }

    public void insert_text_last_name(){
        click(checkout_info_last_name);
        checkout_info_last_name.sendKeys("test last name");
    }

    public void insert_text_postal_code(){
        click(checkout_info_postal_code);
        checkout_info_postal_code.sendKeys("12345");
    }

    public void press_continue_checkout_info_button(){
        click(checkout_info_continue_button);
    }

    public void press_checkout_button(){
        click(checkoutButton);
    }

    public void press_finish_shopping_button(){
        click(overview_submit_button);
    }

    public boolean check_pony_final_image_after_shopping(){
        if(finish_shopping_image.isDisplayed()){
            return true;
        }
        return false;
    }

    public void remove_item_button(String itemType){
        switch (itemType) {
            case "Sauce Labs Backpack":
                click(remove_Sauce_Labs_Backpack);
                click(remove_item_button_cart);
                click(inventory_details_back_button);
                click(continue_shopping_button);
                break;
            case "Sauce Labs Bike Light":
                click(remove_Sauce_Labs_Bike_Light);
                click(remove_item_button_cart);
                click(inventory_details_back_button);
                click(continue_shopping_button);
                break;
            case "Sauce Labs Bolt T-Shirt":
                click(remove_Sauce_Labs_Bolt_T_Shirt);
                click(remove_item_button_cart);
                click(inventory_details_back_button);
                click(continue_shopping_button);
                break;
            case "Sauce Labs Fleece Jacket":
                click(remove_Sauce_Labs_Fleece_Jacket);
                click(remove_item_button_cart);
                click(inventory_details_back_button);
                click(continue_shopping_button);
                break;
            case "Sauce Labs Onesie":
                click(remove_Sauce_Labs_Onesie);
                click(remove_item_button_cart);
                click(inventory_details_back_button);
                click(continue_shopping_button);
                break;
            case "Test.allTheThings() T-Shirt (Red)":
                click(remove_T_Shirt_Red);
                click(remove_item_button_cart);
                click(inventory_details_back_button);
                click(continue_shopping_button);
                break;
            default:
                System.out.println("Unsupported item type: " + itemType);
                break;
        }
    }

    public boolean check_cart_is_empty(){
        return shopping_cart_badge.isDisplayed();
    }
}
