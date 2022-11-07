package stibo.seleniumjava.tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import stibo.seleniumjava.helpers.DemoData;
import stibo.seleniumjava.base.BaseTest;
import stibo.seleniumjava.pages.ContactUsPage;
import stibo.seleniumjava.pages.HomePage;
import stibo.seleniumjava.utilities.LoadData;

import java.io.IOException;
import java.io.InputStream;

public class ContactUsPageTests extends BaseTest {
    DemoData demoData;
    @BeforeClass
    public void loadData() throws IOException {
        demoData=new DemoData();
        InputStream is=getClass().getClassLoader().getResourceAsStream("DemoData.json");
        demoData= LoadData.deserializeJson(is,demoData);
    }
    @Description("Verify validation error message for 'Last Name' field in Demo Request form when clicking send button without entering lastname field")
    @Test( description = "Verify that the validation error message for Last name field is as expected")
    public void VerifyValidationErrorMessageLastName(){
        HomePage home=new HomePage(driver);
        home.acceptCookies()
        .navigateToBookDemo();
        ContactUsPage contactUs=new ContactUsPage(driver);
        contactUs.enterBookingMessage(demoData.getBookingMessage())
        .selectCountry(demoData.getCountry())
        .submitDemoRequest();
        Assert.assertEquals(contactUs.getValidationErrorMessageLastName(), demoData.getValidationErrorLastName(),
                "Verified the validation error message :"+contactUs.getValidationErrorMessageLastName()+" for Last Name field");
    }
    @Description("Verify navigation back to homepage on clicking Stibo Systems logo ")
    @Test(priority = 2,description = "Verify that the user is navigated back to Home page when clicking Stibo Systems navigation logo")
    public void VerifyNavigationBackToHomePage(){
        HomePage home=new HomePage(driver);
        home.acceptCookies()
        .navigateToBookDemo();
        ContactUsPage contactUs=new ContactUsPage(driver);
        contactUs.clickStiboSystemsLogo();
        home.verifyHomePageLoaded();
    }
}
