package data;

import org.testng.annotations.DataProvider;

public class StaticProvider {
    @DataProvider(name = "Data for Sum test", parallel = true)
    public static Object[][] dataForSumTest() {
        return new Object[][] {
                {-2, -3, -5},
                {0, 0, 0},
                {-1, 2, 1},
                {2, 3, 5}
        };
    }

    @DataProvider(name = "Data for Division test", parallel = true)
    public static Object[][] dataForDivTest() {
        return new Object[][] {
                {18, 3, 6},
                {-122, 2, -61},
                {99, 11, 9}
        };
    }
}
