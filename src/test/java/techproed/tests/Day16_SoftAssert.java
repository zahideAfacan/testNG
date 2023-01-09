package techproed.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Day16_SoftAssert {
    @Test
    public void softAssert(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("Line 10 Code");
        softAssert.assertEquals(3,5);
        System.out.println("Line 12 Code");
        softAssert.assertEquals("Apple","Orange");
        System.out.println("Line 14 Code");
        softAssert.assertAll();//mark for the failing the test
    }
}
