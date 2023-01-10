package techproed.homework;

import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day17_homework {

    @Test
    public void loginTest() {

        //Create a test case to login the https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
        // using page object model

        OpenSourcePage openSourcePage = new OpenSourcePage();
        Driver.getDriver().get(ConfigReader.getProperty("testsenter_URL"));
        openSourcePage.userName.sendKeys("techproed");
        openSourcePage.password.sendKeys("SuperSecretPassword");
        openSourcePage.submitButton.click();
    }
}