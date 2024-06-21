package webTestScripts;
import org.testng.annotations.*;
import utilities.baseClass;
import webFunctions.wf_Login;
import webFunctions.wf_Register;

public class t_Register extends baseClass {
    @Test
    public void registerUser() throws InterruptedException {
        wf_Register wa = new wf_Register(webDriver);
        wf_Login wl = new wf_Login(webDriver);
        wa.addUser();
        wl.loginFunction();
        webDriver.quit();
    }
}
