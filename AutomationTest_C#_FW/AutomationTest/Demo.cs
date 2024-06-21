using OpenQA.Selenium.Support.UI;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace AutomationTest
{
    public class Tests
    {
        private static IWebDriver driver;

        [OneTimeSetUp]
        public void Setup()
        {
            driver = new ChromeDriver();
            driver.Navigate().GoToUrl("R:\\Learning\\lanefornetDemo\\Resources\\loginform.html");
            driver.Manage().Window.Maximize();
        }

        [Test]
        public void LoginandRegister()
        {
         
            driver.FindElement(By.Id("reg-username")).SendKeys("Admin");
            driver.FindElement(By.Id("reg-password")).SendKeys("admin123");
            driver.FindElement(By.Id("register")).Click();
            string validMsgTxt = driver.FindElement(By.Id("reg-message")).Text;
            Assert.AreEqual("Registration successful!", validMsgTxt);
            //--For Login--//
            driver.FindElement(By.Id("login-username")).SendKeys("Admin");
            driver.FindElement(By.Id("login-password")).SendKeys("admin123");
            driver.FindElement(By.Id("login-button")).Click();
            string loginvalidMsgTxt = driver.FindElement(By.Id("reg-message")).Text;
            Assert.AreEqual("Login successful!", loginvalidMsgTxt);
            Thread.Sleep(1000);
        }

        [OneTimeTearDown]
        public void Teardown()
        {
            driver.Quit();
        }
    }
}