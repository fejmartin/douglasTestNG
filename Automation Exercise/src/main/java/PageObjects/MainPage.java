package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;


    private By acceptCookiesBtn = By.xpath("//button[@class='button button__primary uc-list-button__accept-all']");
    private By btnParfum =   By.linkText("PARFUM");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getParfumElement() {
        return driver.findElement(btnParfum);
    }


    public WebElement getAcceptCookiesBtn() {
        return driver.findElement(acceptCookiesBtn);
    }

    public void navigateToParfumPage() {
        getParfumElement().isDisplayed();
        getParfumElement().isEnabled();
        getParfumElement().click();
    }


    public void acceptCookies() {

        getAcceptCookiesBtn().isDisplayed();
        getAcceptCookiesBtn().isEnabled();
        getAcceptCookiesBtn().click();
    }


}
