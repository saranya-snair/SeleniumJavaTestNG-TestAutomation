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

public class HomePageTests extends BaseTest {
    DemoData demoData;
    @BeforeClass
    public void loadData() throws IOException {
        demoData=new DemoData();
        InputStream is=getClass().getClassLoader().getResourceAsStream("DemoData.json");
        demoData= LoadData.deserializeJson(is,demoData);
    }
    @Description("Verify that the text 'Book a free product demo today' is present in Contact us page")
    @Test(description = "Verify that the landing page for Book a Demo link has text : 'Book a free product demo today' ")
    public void VerifyBookDemoFormText(){
        HomePage home=new HomePage(driver);
        home.acceptCookies()
        .verifyHomePageLoaded()
        .navigateToBookDemo();
        ContactUsPage contact=new ContactUsPage(driver);
        Assert.assertEquals(contact.getBookDemoFormTitleText(),demoData.getBookDemoFormText(),"Verified " +
              "text on the book demo form");
    }
}
