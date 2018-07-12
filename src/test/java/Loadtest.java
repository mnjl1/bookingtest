import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Loadtest {

    private final String WINDOWS_GECKO_DRIVER_PATH = "C:\\geckodriver\\geckodriver.exe";

    private final String WEB_URL = "https://www.booking.com/index.en-gb.html";

    @Test
    public void bookingLoadTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", WINDOWS_GECKO_DRIVER_PATH);
        WebDriver webDriver = new FirefoxDriver();

        webDriver.get(WEB_URL);

        WebElement city = ((FirefoxDriver) webDriver).findElementById("ss");
        city.sendKeys("New York");

        Thread.sleep(3000);

        WebElement dateBox = ((FirefoxDriver) webDriver).findElementByXPath("/html/body/div[3]/div/div/div[2]/" +
                "form/div[1]/div[2]/div/div[2]/div/div/div/div[1]/div/div[1]/div[1]/select");

        JavascriptExecutor js = (JavascriptExecutor)webDriver;

        String date = "arguments[0].setAttribute('value','9-2018');";

        js.executeScript(date, dateBox);

        WebElement searchButton = ((FirefoxDriver) webDriver)
                .findElementByXPath("/html/body/div[3]/div/div/div[2]/form/div[1]/div[4]/div[2]/button");
        searchButton.click();

        webDriver.quit();
    }


}
