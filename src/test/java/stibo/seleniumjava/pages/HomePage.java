package stibo.seleniumjava.pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import stibo.seleniumjava.base.BasePage;
import java.util.Iterator;
import java.util.Set;

public class HomePage extends BasePage {
    //Locators
    @FindBy(css= "#coiPage-1") private WebElement overlayCookies;
    @FindBy(xpath ="//div[@id='coiPage-1']//div[@class='coi-banner__page-footer']//button[contains(text(),'Accept all')]" ) private WebElement acceptCookies;
   // @FindBy(css= "#coiPage-1 > div.coi-banner__page-footer > div.coi-button-group > button.coi-banner__accept") private WebElement acceptCookies;
    @FindBy(css= "a.sb-nav-logo") private WebElement stiboSystemsLogo;
    @FindBy(css = "a.sb-big-hero-content-link-orange.hover_style_swipe_solid") private WebElement bookDemo;

    //Methods
    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage acceptCookies(){
        wait.until(ExpectedConditions.visibilityOf(acceptCookies)).click();
        return this;}
    @Step
    @Description("Verify that the Home page is loaded")
    public HomePage verifyHomePageLoaded(){
        wait.until(ExpectedConditions.visibilityOf(stiboSystemsLogo));
        return this;
    }
    @Step
    @Description("Book a Demo from Home page which will take user to contact us page")
    public void navigateToBookDemo(){
        String homePageWindow= driver.getWindowHandle();
        wait.until(ExpectedConditions.visibilityOf(bookDemo)).click();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        while(iterator.hasNext()){
            String contactUsWindow= iterator.next();
            if(!homePageWindow.equalsIgnoreCase(contactUsWindow))
            driver.switchTo().window(contactUsWindow);
        }
    }
}
