package stibo.seleniumjava.driverfactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class DriverManager {
    public WebDriver initializeDriver(String browser){
        switch (browser.toUpperCase()) {
            case "CHROME" -> {
                return new ChromeDriver();
            }

            case "FIREFOX" -> {
                return new FirefoxDriver();
            }

            case "SAFARI" -> {
                return new SafariDriver();
            }

            default -> throw new IllegalStateException("Browser not valid" + browser);
        }
    }
}
