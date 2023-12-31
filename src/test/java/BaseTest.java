import org.testng.annotations.*;

public class BaseTest {
    protected Calculator calculator;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite: ...");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: ...");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: ...");
        calculator = new Calculator();
        calculator.setLevel(this.getClass().toString());
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: ...");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("BeforeGroups: ...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite: ...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: ...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: ...");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: ...");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("AfterGroups: ...");
    }
}
