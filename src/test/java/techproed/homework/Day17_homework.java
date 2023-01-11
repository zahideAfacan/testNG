package techproed.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.pages.TestCenterPage;
import techproed.pages.TestHomePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day17_homework {

    @Test
    public void loginTest() {

        //Create a test case to login the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        // using page object model

        TestCenterPage testCenterPage = new TestCenterPage();
        TestHomePage testHomePage=new TestHomePage();
        Driver.getDriver().get(ConfigReader.getProperty("testcenter_URL"));
        testCenterPage.userName.sendKeys("techproed");
        testCenterPage.password.sendKeys("SuperSecretPassword");
        testCenterPage.submitButton.click();

   //     Assert.assertTrue(testHomePage.loginMessage.isDisplayed());
        ReusableMethods.verifyElementDisplayed(testHomePage.loginMessage);
    }
}