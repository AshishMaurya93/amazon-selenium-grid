package Mytest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;
import java.net.URL;

public class AmazonGridTest {

    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) throws Exception {

        DesiredCapabilities cap = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            cap.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            cap.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            cap.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                cap
        );
    }

    @Test
    public void verifyAmazonTitle() throws InterruptedException {
    	Thread.sleep(5000);
        driver.get("https://www.amazon.in");
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        Assert.assertTrue(title.contains("Amazon"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
