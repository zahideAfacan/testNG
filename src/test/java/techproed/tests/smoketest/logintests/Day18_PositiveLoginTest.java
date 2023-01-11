package techproed.tests.smoketest.logintests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_PositiveLoginTest {

    /*
          Name: US100201_Admin_Login
        Description:
        User should be able login as admin
        Acceptance Criteria:
        As admin, I should be able to log in the application
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345

     */

    HomePage homePage;
    @Test
    public void US100201_Admin_Login(){
//going to rentalcar homepage

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        //        click on home page login link
        homePage = new HomePage();
        LoginPage loginPage=new LoginPage();
        ReusableMethods.waitFor(3);

        homePage.homePageLoginLink.click();
        loginPage.userName.sendKeys("jack@gmail.com ");
        ReusableMethods.waitFor(3);
        loginPage.password.sendKeys("12345");
        ReusableMethods.waitFor(3);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);

        // verify login is successful
        ReusableMethods.verifyElementDisplayed(homePage.userID);

        Driver.closeDriver();
    }

}
