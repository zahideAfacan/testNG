package techproed.tests;

import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class Day17_firstDriverTest {

    @Test
    public void firstDriverTest(){

        Driver.getDriver().get("https://www.techproeducation.com/");
// close the page
        Driver.closeDriver();
    }
}
