package Mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;
import java.time.Duration;



public class AmazonGridTest {

    WebDriver driver;
    WebDriverWait wait;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            cap.setBrowserName("MicrosoftEdge");
        }

        cap.setCapability("pageLoadStrategy", "normal");

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                cap
        );

        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void verifyAmazonLaunch() {

        driver.get("https://www.amazon.in");

        String currentUrl = driver.getCurrentUrl();
        String title = driver.getTitle();

        System.out.println(
            "[" + ((RemoteWebDriver) driver).getCapabilities().getBrowserName() +
            "] URL: " + currentUrl
        );

        // CI-SAFE assertion
        Assert.assertTrue(
            currentUrl.contains("amazon"),
            "Amazon URL validation failed"
        );
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
