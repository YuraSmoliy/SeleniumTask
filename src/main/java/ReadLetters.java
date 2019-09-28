import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadLetters {
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

    void showSetingUpFoSeatch(WebDriver driver){
        weitForWebDriverById(driver,"aso_search_form_anchor");
        WebElement elemSetUp= ((FirefoxDriver) driver).findElementByXPath("/html/body/div[7]/div[3]/div/div[1]/div[4]/header/div[2]/div[2]/div[2]/form/button[2]");
        elemSetUp.click();
    }

    void putSender(WebDriver driver){
        weitForWebDriverById(driver,":n9");
        WebElement elemSearchSender = ((FirefoxDriver) driver).findElementById(":n9");
        elemSearchSender.sendKeys("yura140690@gmail.com ");
    }

    void putAddressee(WebDriver driver){
        weitForWebDriverById(driver,":nb");
        WebElement elemSearchAddressee = ((FirefoxDriver) driver).findElementById(":nb");
        elemSearchAddressee.sendKeys("yura140690@gmail.com ");
    }

    void clickButtonSeatch(WebDriver driver){
        weitForWebDriverById(driver,":nn");
        WebElement elemClickBotton = ((FirefoxDriver) driver).findElementById(":nn");
        elemClickBotton .click();
    }

    void getLetters(WebDriver driver)throws InterruptedException{
        String msg = "alert('";
        weitForWebDriverById(driver,":rc");
        WebElement parentListLetters = ((FirefoxDriver) driver).findElementByXPath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[2]/div[5]/div[1]/div/table/tbody");
        List<WebElement> listLetters = parentListLetters.findElements(By.tagName("tr"));
        List<WebElement> listObjects  = new ArrayList<WebElement>();
        for(int i = 0; i < listLetters.size(); i++){
            listObjects.add(listLetters.get(i).findElement(By.className("a4W")).findElement(By.className("bog")).findElement(By.tagName("span")));
            msg += (listObjects.get(i).getText()+"\\n");
            System.out.println(listObjects.get(i).getText());
        }
        msg +="')";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(msg);
        Thread.sleep(7000);
        driver.switchTo().alert().accept();
    }

    void weitForWebDriverByName(WebDriver driver,String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(elementName)));
    }

    void weitForWebDriverById(WebDriver driver,String id){
        WebDriverWait wait = new WebDriverWait(driver, 150);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    void closeDriver(WebDriver webDriver){
        webDriver.close();
    }
}
