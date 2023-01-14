package techproed.homework;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import techproed.pages.HomePage;
import techproed.pages.LoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class Day18_NegativeLoginTest2 {

    @Test
    public void test(){

        //Name:
        //Login screen error messages
        //Description:
        //User should see error message when an invalid email is entered
        //Acceptance Criteria:
        //As admin or customer, I should be able to see error message, when I do not provide a complete valid email address in email address box
        //Error Message: email must be a valid email
        //When I enter a valid email domain, then I should not see the error message
        //https://email-verify.my-addr.com/list-of-most-popular-email-domains.php

        Driver.getDriver().get(ConfigReader.getProperty("app_home_url"));

        HomePage homePage=new HomePage();
        LoginPage loginPage=new LoginPage();
        ReusableMethods.waitFor(2);
        homePage.homePageLoginLink.click();
        ReusableMethods.waitFor(2);
        loginPage.userName.sendKeys("jack");
        loginPage.password.sendKeys("12345");
        loginPage.loginButton.click();
        ReusableMethods.waitFor(2);
        //verify invalid email message
        String invalidMessage=loginPage.invalidEmailMessage.getText();
        System.out.println(invalidMessage);
        ReusableMethods.verifyElementDisplayed(loginPage.invalidEmailMessage);

        Actions actions=new Actions(Driver.getDriver());
        loginPage.userName.click();
        actions.doubleClick(loginPage.userName).perform();
        loginPage.userName.sendKeys("jack@gmail.com");
        loginPage.loginButton.click();

        //verify not seen the error message
        ReusableMethods.verifyElementNotDisplayed(loginPage.invalidEmailMessage);





    }
}
