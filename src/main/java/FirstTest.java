import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    By phoneNumber = By.xpath(".//input[@data-qa-node='phone-number']");
    By amount = By.xpath(".//input[@data-qa-node='amount']");
    By numberDebitSource = By.xpath(".//input[@data-qa-node='numberdebitSource']");
    By expiredebitSource = By.xpath(".//input[@data-qa-node='expiredebitSource']");
    By cvvdebitSource = By.xpath(".//input[@data-qa-node='cvvdebitSource']");
    By firstNamedebitSource = By.xpath(".//input[@data-qa-node='firstNamedebitSource']");
    By lastNamedebitSource = By.xpath(".//input[@data-qa-node='lastNamedebitSource']");

    @Test
    public void checkMobiPay(){
        System.setProperty("webdriver.chrome.driver",
                           "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://next.privat24.ua/mobile");

        driver
                .findElement(By.xpath(".//input[@data-qa-node='phone-number']"))
                .sendKeys("957112193");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='amount']"))
                .sendKeys("125");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='numberdebitSource']"))
                .sendKeys("4506 9093 2427 4797");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='expiredebitSource']"))
                .sendKeys("0622");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='cvvdebitSource']"))
                .sendKeys("327");

        driver.findElement(By.xpath(".//button[@data-qa-node='submit']")).click();

        driver
                .findElement(By.xpath(".//input[@data-qa-node='firstNamedebitSource']"))
                .sendKeys("Peter");
        driver
                .findElement(By.xpath(".//input[@data-qa-node='lastNamedebitSource']"))
                .sendKeys("Scroggs");

        Assert.assertEquals("957112193", driver.findElement(phoneNumber).getText());
        Assert.assertEquals("125", driver.findElement(amount).getText());
        Assert.assertEquals("4506 9093 2427 4797", driver.findElement(numberDebitSource).getText());
        Assert.assertEquals("0622", driver.findElement(expiredebitSource).getText());
        Assert.assertEquals("327", driver.findElement(cvvdebitSource).getText());
        Assert.assertEquals("Peter", driver.findElement(firstNamedebitSource).getText());
        Assert.assertEquals("Scroggs", driver.findElement(lastNamedebitSource).getText());

        driver.findElement(By.xpath(".//button[@data-qa-node='submit']")).click();

    }

}
