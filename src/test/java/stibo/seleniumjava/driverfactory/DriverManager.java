package stibo.seleniumjava.driverfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import stibo.seleniumjava.utilities.LoadConfig;

import static io.github.bonigarcia.wdm.config.DriverManagerType.CHROME;
import static io.github.bonigarcia.wdm.config.DriverManagerType.FIREFOX;

public class DriverManager {
    public WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "CHROME" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "FIREFOX" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            case "SAFARI" -> {
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
            }
            default -> throw new IllegalStateException("B" + browser);
        }
        driver.get(LoadConfig.getInstance().getBaseUrl());
        driver.manage().window().maximize();
        return driver;
    }
}
