package techproed.tests;

import org.testng.annotations.*;

public class Day16_Annotations {
    /*
    suite> tet> group> class> method
    @Test : create test case
    @Before and @After :10 before and after annotations. there are used to comtrol FLOW AND DESIGN of the test
    @Ignore " skip the test case
    @Test(enable=false) : Disable the test case. similar the @Ignore
    @Test(priority=number): prioritize/order test case execution.
    NOTE: Tests that has no priority parameter has a priority of 0. Test(priority=0)
    TestNG test cases runs in alphabetical order by default
     */
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Ignore
    @Test
    public void test2(){
        System.out.println("test2");
    }
    @Test
    public void test3(){
        System.out.println("test3");
    }
    @Test(enabled=false)
    public void test4(){
        System.out.println("test4");
    }
    @Test(priority=1)
    public void test5(){
        System.out.println("test5");
    }
}
