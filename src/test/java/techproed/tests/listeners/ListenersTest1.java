package techproed.tests.listeners;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
//
@Listeners(techproed.utilities.Listeners.class)
public class ListenersTest1 {
    @Test
    public void test1(){
        System.out.println("Test case 1 PASS");
        Assert.assertTrue(true);//PASS
    }
    @Test
    public void test2(){
        System.out.println("Test case 2 FAIL");
        Assert.assertTrue(false);//FAILS
    }
    @Test
    public void test3(){
        System.out.println("Test case 3 SKIPPED");
        throw new SkipException("SKIP THIS TEST CASE");
    }
    @Test
    public void test4(){
        System.out.println("Test case 4 No SUCH ELEMENT EXCEPTION");
        Driver.getDriver().get("https://techproeducation.com/");
        Driver.getDriver().findElement(By.xpath("asegsdgga"));//NO SUCH ELEMENT EXCEPTION
    }
}
