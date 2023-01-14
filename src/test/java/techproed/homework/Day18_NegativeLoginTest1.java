package techproed.homework;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_NegativeLoginTest1 {
    @Test
    public void test(){

        //Name:
        //Login screen error messages
        //Description:
        //User should see error message when user tries to login with incorrect credentials
        //Acceptance Criteria:
        //As admin or customer, I should be able to see error message,
        //when I provide a correct email address BUT incorrect password in a pop up window
        //Error Message: Bad credentials


        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));
        HomePage homePage=new HomePage();
        LoginPage loginPage=new LoginPage();
        ReusableMethods.waitFor(2);

        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(2);
        loginPage.userName.sendKeys("jack@gmail.com ");
        ReusableMethods.waitFor(2);
        loginPage.password.sendKeys("987");
        ReusableMethods.waitFor(2);
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);

        // Verify Error Message: Bad credentials
        ReusableMethods.verifyElementDisplayed(loginPage.errorMessage);

        System.out.println(loginPage.errorMessage.getText());//Bad credentials

        // close driver
        Driver.closeDriver();

    }

}
