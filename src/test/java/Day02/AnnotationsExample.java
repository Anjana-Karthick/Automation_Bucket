package Day02;

import org.testng.annotations.*;

public class AnnotationsExample {

    @BeforeSuite
    void BeforeSuite ()
    {
        System.out.println("@BeforeSuite");
    }
    @AfterMethod
    void AfterMethod ()
    {
        System.out.println("@AfterMethod");
    }

    @AfterClass
    void AfterClass ()
    {
        System.out.println("@AfterClass");
    }
    @Test
    void Test() {
        System.out.println("@Test");
    }
    @Test
    void Test1() {
        System.out.println("@Test1");
    }
    @AfterSuite
    void AfterSuite ()
    {
        System.out.println("@AfterSuite");
    }
    @BeforeMethod
    void BeforeMethod ()
    {
        System.out.println("@BeforeMethod");
    }
    @BeforeTest
    void BeforeTest ()
    {
        System.out.println("@BeforeTest");
    }
    @BeforeClass
    void BeforeClass ()
    {
        System.out.println("@BeforeClass");
    }
    @AfterTest
    void AfterTest ()
    {
        System.out.println("@AfterTest");
    }
}

