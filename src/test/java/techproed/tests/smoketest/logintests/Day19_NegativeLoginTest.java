package techproed.tests.smoketest.logintests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.io.IOException;

public class Day19_NegativeLoginTest {
    HomePage homePage;
    LoginPage loginPage;
    Faker faker;

    @Test
    public void US100208_Negative_LoginTest() throws IOException {
//Name:
//US100208_Negative_Login
//Description:
        //  As customer, I should not be able to log in the application
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        //        click on home page login link
        homePage = new HomePage();
        loginPage=new LoginPage();
        ReusableMethods.waitFor(3);
        //  Customer email: fake@bluerentalcars.com
        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(3);
        loginPage.userName.sendKeys("fake@bluerentalcars.com ");
        ReusableMethods.waitFor(3);
        //  Customer password: fakepass
        loginPage.password.sendKeys("fakepass");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Error: User with email fake@bluerentalcars.com not found
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage_incorrectEmailPass);
        String errorMessage=loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email fake@bluerentalcars.com not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();

    }
    @Test
    public void invalidCredsTest() throws IOException {

        //  As customer, I should not be able to log in the application
        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        //        click on home page login link
        homePage = new HomePage();
        loginPage=new LoginPage();
        ReusableMethods.waitFor(3);
        //  Customer email: fake@bluerentalcars.com
        faker=new Faker();
        String fakeEmail= faker.internet().emailAddress();
        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(3);
        loginPage.userName.sendKeys(fakeEmail);
        ReusableMethods.waitFor(3);
        //  Customer password: fakepass
        loginPage.password.sendKeys(faker.internet().password(4,6));//fake password 4-6 digit
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
//        Error: User with email fake@bluerentalcars.com not found
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage_incorrectEmailPass);
        String errorMessage=loginPage.errorMessage_incorrectEmailPass.getText();
        Assert.assertEquals(errorMessage,"User with email "+fakeEmail+" not found");
        ReusableMethods.getScreenshot("NegativeLoginScreenshot");
        Driver.closeDriver();

    }
}
