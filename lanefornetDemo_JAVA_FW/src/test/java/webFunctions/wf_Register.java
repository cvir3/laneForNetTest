package webFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.baseClass;
import webElements.we_Register;


public class wf_Register extends baseClass {
    WebDriver webDriver;
    we_Register wr = new we_Register();

    public wf_Register(WebDriver remoteDriver) {
        webDriver = remoteDriver;
    }


    public void addUser() throws InterruptedException {
            WebElement username = webDriver.findElement(wr.inputUserName);
            username.isDisplayed();
            username.isEnabled();
            username.sendKeys("Admin");
            WebElement password = webDriver.findElement(wr.inputPassword);
            password.isDisplayed();
            password.isEnabled();
            password.sendKeys("admin123");
            webDriver.findElement(wr.btnRegister).click();
            String validMsgTxt = webDriver.findElement(wr.validMsg).getText();
            Assert.assertEquals(validMsgTxt, "Registration successful!");
            Thread.sleep(1000);
        }
    }
