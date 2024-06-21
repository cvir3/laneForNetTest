package webFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.baseClass;
import webElements.we_Login;


public class wf_Login extends baseClass {
    WebDriver webDriver;
    we_Login wE = new we_Login();

    public wf_Login(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }

    // This is negative scenario
    public void invalidLoginFunction() throws InterruptedException {
        webDriver.findElement(wE.inputUserName).sendKeys("testt");
        webDriver.findElement(wE.inputPassword).sendKeys("admin123");
        webDriver.findElement(wE.btnLogin).click();
        WebElement Invalidcredtext = webDriver.findElement(wE.lValidMsg);
        String expectedValue = Invalidcredtext.getText();
        String actualValue = "Invalid username or password.";
        if (actualValue.equals(expectedValue)) {
            System.out.println("Test Pass " + actualValue);
        } else {
            System.out.println("Test fail " + expectedValue + ", but found: " + actualValue);
            Assert.assertFalse(true, "Test is fail");
        }
        Thread.sleep(1000);
        webDriver.findElement(wE.inputUserName).clear();
        webDriver.findElement(wE.inputPassword).clear();
    }

    public void loginFunction() throws InterruptedException {
        WebElement username = webDriver.findElement(wE.inputUserName);
        username.isDisplayed();
        username.isEnabled();
        username.sendKeys("Admin");
        WebElement password = webDriver.findElement(wE.inputPassword);
        password.isDisplayed();
        password.isEnabled();
        password.sendKeys("admin123");
        webDriver.findElement(wE.btnLogin).click();
        String validMsgTxt = webDriver.findElement(wE.lValidMsg).getText();
        Assert.assertEquals(validMsgTxt, "Login successful!");
        Thread.sleep(1000);
    }

}
