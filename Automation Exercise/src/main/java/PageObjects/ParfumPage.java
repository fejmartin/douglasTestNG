package PageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class ParfumPage {
    private WebDriver driver;

    // FILTERS MENU
    private By highlightsMenu = By.xpath("//div[@class='facet']//*[text()='Highlights']");
    private By markeMenu = By.xpath("//div[@class='facet']//*[text()='Marke']");
    private By produktartMenu = By.xpath("//div[@class='facet']//*[text()='Produktart']");
    private By furWenMenu = By.xpath("//div[@class='facet']//*[text()='Für Wen']");
    private By gerschenkFurMenu = By.xpath("//div[@class='facet']//*[text()='Geschenk für']");


    // APPLY FILTER BUTTON
    private By applyFilterBtn = By.xpath("//button[@class='button button__primary facet__close-button']");
    private By searchInput = By.xpath("//input[@class='input__input typeAhead-search-box__input-text typeAhead-input-text']");
    private By moreFiltersBtn = By.xpath("//button[text()='Mehr Filter anzeigen']");

    // PRODUCT DETAILS
    private By products = By.xpath("//div[@class='product-grid-column col-sm-6 col-md-4 col-lg-3']");
    private By markeText = By.xpath("./div/a/div[3]/div[1]/div[@class='text top-brand']");
    private By neuText = By.xpath("./div/div/div[@class='eyecatcher eyecatcher--round eyecatcher--new']");
    private By saleText = By.xpath("./div/div/div[@class='eyecatcher eyecatcher--round eyecatcher--discount']");
    private By produktartText = By.xpath("./div/a/div[3]/div[1]/div[@class='text category']");


    public ParfumPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnApplyFilter() {
        driver.findElement(applyFilterBtn).click();
    }

    public void clickOnMarke() {
        driver.findElement(markeMenu).click();
    }

    public void clickOnProduktart() {
        driver.findElement(produktartMenu).click();
    }

    public void clickOnFurWen() {
        driver.findElement(furWenMenu).click();
    }


    public void clickOnGeschenkFur() {
        driver.findElement(gerschenkFurMenu).click();
    }

    public void selectFilter(String text) {
        if(!text.equals("null")) {

            driver.findElement(By.xpath("//div[contains(text(),'" + text + "')][1]")).click();
            driver.findElement(applyFilterBtn).click();
        }
    }

    public void clickOnHighlights() {
        hoverSearchInput();
        driver.findElement(highlightsMenu).isDisplayed();
        driver.findElement(highlightsMenu).isEnabled();
        driver.findElement(highlightsMenu).click();
    }

    public void hoverSearchInput() {
        Actions a = new Actions(this.driver);
        a.moveToElement(this.driver.findElement(searchInput)).perform();
    }

    public void verifyFilter(String filter) {
        if(!filter.equals("null")) {
            WebElement filterActive = this.driver.findElement(By.xpath("//a[contains(text(),'" + filter + "')]"));

        }
    }

    public void assertProductList(String marke, String produktart, String highlights) {
        List<WebElement> listOfProducts = driver.findElements(products);
        for (WebElement product : listOfProducts) {

            if (!marke.equals("null")) {
                Assert.assertEquals(product.findElement(markeText).getText(), marke.toUpperCase());
            }
            if (!produktart.equals("null")) {
                Assert.assertEquals(product.findElement(produktartText).getText(), produktart);
            }
            if (!highlights.equals("null")) {
                String highlightsElement= null;
                if(highlights.equals("NEU")){
                    highlightsElement = product.findElement(neuText).getText();
                    Assert.assertEquals(highlightsElement, highlights.toUpperCase());
                }else if (highlights.equals("Sale"))  {
                    highlightsElement = product.findElement(saleText).getText();
                    Assert.assertEquals(highlightsElement, highlights.toUpperCase());
                }

            }
        }
    }

    public void verifyHighlightsMenu() {
        if (!this.driver.findElement(highlightsMenu).isEnabled()) {
            this.driver.findElement(moreFiltersBtn).click();
        }
    }
}