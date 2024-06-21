package webTestScripts;
import org.testng.annotations.*;
import utilities.baseClass;
import webFunctions.wf_Login;

public class t_Login extends baseClass {

    @Test
    public void Login() throws InterruptedException {
        wf_Login wl = new wf_Login(webDriver);
        wl.invalidLoginFunction();
        //wl.loginFunction();
        webDriver.quit();
    }
}