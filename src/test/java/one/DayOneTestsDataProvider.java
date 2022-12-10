package one;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DayOneTestsDataProvider {

  @DataProvider()
  public static Object[][] getTheMaxSumTestDataProvider() {
    return new Object[][] {
      new Object[] {
        Arrays.asList("4567", "23984", "", "192836", "", "272", "234", "1000"), 192836
      }, // one element sum in the middle
      new Object[] {
        Arrays.asList("4567", "23984", "", "1928", "", "272", "234", "1000"), 28551
      }, // the first sum
      new Object[] {
        Arrays.asList("1928", "", "272", "234", "1000", "", "4567", "23984"), 28551
      } // the last sum
    };
  }

  @DataProvider()
  public static Object[][] getTheMaxSumFromTopThreeTestDataProvider() {
    return new Object[][] {
      new Object[] {
        Arrays.asList("4567", "23984", "", "192836", "", "272", "234", "1000", "", "566"),
        222893 // middle and first sums
      },
      new Object[] {
        Arrays.asList(
            "4567", "23984", "", "1928", "", "272", "234", "1000", "", "566", "", "56666", "56666"),
        143811 // middle, first and last sums
      }
    };
  }

  @DataProvider()
  public static Object[][] getTheMaxSumFromTopThreeNegativeTestDataProvider() {
    return new Object[][] {
      new Object[] {Arrays.asList("4567", "23984", "", "192836")},
      new Object[] {Collections.singletonList("4567")},
      new Object[] {new ArrayList<>()},
    };
  }
}
