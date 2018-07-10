import jdk.internal.util.xml.impl.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Loadtest {

    private final String GECKO_DRIVER_PATH = "C:\\geckodriver\\geckodriver.exe";
    private final String WEB_URL = "https://www.booking.com/index.en-gb.html";

    @Test
    public void bookingLoadTest(){
        System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);
        WebDriver webDriver = new FirefoxDriver();

        webDriver.get(WEB_URL);

        WebElement city = ((FirefoxDriver) webDriver).findElementById("ss");
        city.sendKeys("New York");

        WebElement dateBox = ((FirefoxDriver) webDriver)
                .findElementByXPath("//html/body/div[3]/div/div/div[2]/form/div[1]/div[2]" +
                        "/div/div[3]/div/div/div/div[1]/div/button");
        dateBox.sendKeys("09/01/2018");

        WebElement endDate;

        WebElement searchButton = ((FirefoxDriver) webDriver)
                .findElementByXPath("/html/body/div[3]/div/div/div[2]/form/div[1]/div[2]" +
                        "/div/div[2]/div/div/div/div[1]/div/button/svg/path");
        searchButton.click();


        //webDriver.quit();
    }


}
