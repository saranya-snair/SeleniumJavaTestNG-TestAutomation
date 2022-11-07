package stibo.seleniumjava.base;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import stibo.seleniumjava.driverfactory.DriverManager;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class BaseTest {
    protected WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void startDriver( String browser) throws IOException {
        driver= new DriverManager().initializeDriver(browser);
    }
    @AfterMethod
    public void quitDriver(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            File screenShotFile=new File(".\\FailedCasesScreenshot"+File.separator+result.getTestClass().getRealClass().getSimpleName()+ "_" +
                    result.getMethod().getMethodName()+".png");
            takeScreenshot(screenShotFile);
            Allure.addAttachment(result.getTestClass().getRealClass().getSimpleName()+ "_" +
                    result.getMethod().getMethodName(), new ByteArrayInputStream(takeScreenshot(screenShotFile)));
        }
        driver.quit();
    }
    private byte[] takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
        return Files.readAllBytes(destFile.toPath());
    }

}
