package stibo.seleniumjava.pages;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import stibo.seleniumjava.base.BasePage;
import stibo.seleniumjava.utilities.LoadConfig;

public class ContactUsPage extends BasePage {
    //Locators
    @FindBy(xpath= "//h2[contains(text(),'Book a free product demo today.')]") private WebElement bookDemo;
    @FindBy(css= "a.sb-nav-logo") private WebElement stiboSystemsLogo;
    @FindBy(css="textarea[name='message']") private WebElement messageTextField;
    @FindBy(css="select[name='country']") private WebElement countryDropdown;
    @FindBy(css="input[value='Send']") private WebElement sendButton;
    @FindBy(xpath="//div[@class='hs_lastname hs-lastname hs-fieldtype-text field hs-form-field']//label[@class='hs-error-msg']")
    private WebElement lastNameErrorMessage;

    //Methods
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public String getBookDemoFormTitleText(){
        return wait.until(ExpectedConditions.visibilityOf(bookDemo)).getText();
    }
    @Step
    public ContactUsPage enterBookingMessage(String message){
        wait.until(ExpectedConditions.visibilityOf(messageTextField)).sendKeys(message);
        return this;
    }
    @Step
    public ContactUsPage selectCountry(String countryName){
        Select country=new Select(countryDropdown);
        country.selectByVisibleText(countryName);
        return this;
    }
    @Step
    public ContactUsPage submitDemoRequest(){
        wait.until(ExpectedConditions.visibilityOf(sendButton)).click();
        return this;
    }
    @Step
    public String getValidationErrorMessageLastName(){
        String errorMessage=lastNameErrorMessage.getText();
        return errorMessage;
    }
    @Step
    public void clickStiboSystemsLogo(){
        wait.until(ExpectedConditions.visibilityOf(stiboSystemsLogo)).click();
    }
}
