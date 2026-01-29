import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.URL;

public class AmazonGridTest {

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(String browser) throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (browser.equalsIgnoreCase("chrome")) {
            capabilities.setBrowserName("chrome");
        } else if (browser.equalsIgnoreCase("firefox")) {
            capabilities.setBrowserName("firefox");
        } else if (browser.equalsIgnoreCase("edge")) {
            capabilities.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver(
                new URL("http://localhost:4444"),
                capabilities
        );
    }

    @Test
    public void verifyAmazonSearch() throws InterruptedException {
    	Thread.sleep(5000);
        driver.get("https://www.amazon.in");

        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Amazon"));

        driver.findElement(By.id("twotabsearchtextbox"))
              .sendKeys("Laptop", Keys.ENTER);

        Assert.assertTrue(
                driver.getTitle().contains("Laptop"),
                "Search result not displayed"
        );

        System.out.println("TEST PASSED on Browser: " +
                ((RemoteWebDriver) driver)
                .getCapabilities()
                .getBrowserName());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
