import org.openqa.selenium.WebDriver;

public class Run {
    CreationMail creationMail = new CreationMail();

    ReadLetters readLetters = new ReadLetters();

    public void creationMailBySelenium(){

        WebDriver webDriver = creationMail.init();

        creationMail.writeLogin(webDriver);

        creationMail.sendLogin(webDriver);

        creationMail.writePassword(webDriver);

        creationMail.clickButtonToSendPassword(webDriver);

        creationMail.clickButtonToWriteLetter(webDriver);

        creationMail.sendMale(webDriver);

        creationMail.createObjectInLetter(webDriver);

        creationMail.sendMailClicButton(webDriver);

        //creationMail.closeDriver(webDriver);
    }

    public void finedOutLetters() throws InterruptedException{

        WebDriver webDriver = readLetters.init();

        readLetters.writeLogin(webDriver);

        readLetters.sendLogin(webDriver);

        readLetters.writePassword(webDriver);

        readLetters.clickButtonToSendPassword(webDriver);

        readLetters.showSetingUpFoSeatch(webDriver);

        readLetters.putSender(webDriver);

        readLetters.putAddressee(webDriver);

        readLetters.clickButtonSeatch(webDriver);

        readLetters.getLetters(webDriver);

    }



}
