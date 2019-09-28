
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.IntData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;


public class CreationMail {
    WebDriver init() {
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://mail.google.com");
        return driver;
    }
    void writeLogin(WebDriver driver){
        WebElement elemEmail = driver.findElement(By.id("identifierId"));
        elemEmail.sendKeys("yura140690@gmail.com");
    }

    void sendLogin(WebDriver driver){
        WebElement ememSend = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/span/span");
        ememSend.click();
    }

    void writePassword(WebDriver driver){
        weitForWebDriverByName(driver,"password");
        WebElement writeData = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input");
        if(writeData.isDisplayed())
            writeData.sendKeys("140690yura");
        else writePassword(driver);
    }

    void clickButtonToSendPassword(WebDriver driver){
        weitForWebDriverById(driver,"passwordNext");
        WebElement elemPassSend = ((FirefoxDriver) driver).findElementByXPath("//*[@id=\"passwordNext\"]");
        elemPassSend.isDisplayed();
        elemPassSend.click();
    }

    void clickButtonToWriteLetter(WebDriver driver){
        WebDriverWait wait3 = new WebDriverWait(driver, 200);
        wait3.until(ExpectedConditions.presenceOfElementLocated(By.id(":lf")));
        WebElement writeLetterClickButton = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div/div/div/div[1]/div/div");
        writeLetterClickButton.click();
    }

    void sendMale(WebDriver driver){
        weitForWebDriverById(driver,":r1");
        WebElement sendTo = ((FirefoxDriver) driver).findElementById(":r1");
        sendTo.isDisplayed();
        sendTo.sendKeys("yura140690@gmail.com");
    }

    void createObjectInLetter(WebDriver driver){
        weitForWebDriverById(driver,":qj");
        WebElement object= ((FirefoxDriver) driver).findElementById(":qj");
        object.sendKeys(new Date(System.currentTimeMillis()).toString());
    }

    void sendMailClicButton(WebDriver driver){
        weitForWebDriverById(driver,":q9");
        WebElement sendEmail= ((FirefoxDriver) driver).findElementById(":q9");
        sendEmail.click();
    }

    void weitForWebDriverByName(WebDriver driver,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName)));
    }

    void weitForWebDriverById(WebDriver driver,String id){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    void closeDriver(WebDriver webDriver){
        webDriver.close();
    }

}
