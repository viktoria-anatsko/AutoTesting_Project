import data.StaticProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWorkTest extends BaseTest {

    @Test(enabled = false)
    public void divTest_1() {
        int expectedValue  = 6;
        int actualValue = calculator.div(18, 3);

        Assert.assertEquals(actualValue, expectedValue, "Values aren't the same.");
    }

    @Test(testName = "Division test")
    public void divTest_2() {
        double expectedValue  = 632.8;
        double actualValue = calculator.div(158.2, 0.25);

        Assert.assertEquals(actualValue, expectedValue, "Values aren't the same.");
    }

    @Test(timeOut = 1000)
    public void waitLongTimeTest() throws InterruptedException {
        Thread.sleep(500);
        double expectedValue  = 632.8;
        double actualValue = calculator.div(158.2, 0.25);

        Assert.assertEquals(actualValue, expectedValue, "Values aren't the same.");
    }

    @Test(invocationCount = 2, invocationTimeOut = 2000)
    public void invocationCountTest() throws  InterruptedException {
        Thread.sleep(500);
        int expectedValue  = 6;
        int actualValue = calculator.div(18, 3);

        Assert.assertEquals(actualValue, expectedValue, "Values aren't the same.");
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void exceptionTest() {
        int result = calculator.div(18, 0);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void exceptionTest_1() {
        int result = calculator.div(0, 0);
    }

    @Test
    public void exceptionTest_2() {
        double result = calculator.div(158.2, 0);

        Assert.assertEquals(Double.POSITIVE_INFINITY, result);
    }

    @Test
    public void exceptionTest_3() {
        double result = calculator.div(0.0, 0);

        Assert.assertEquals(Double.NaN, result);
    }

    @Test(dataProvider = "Data for Division test", dataProviderClass = StaticProvider.class)
    public void dataProviderTest(int a, int b, int expectedValue) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(calculator.div(a, b), expectedValue, "Values aren't the same.");
    }
}
