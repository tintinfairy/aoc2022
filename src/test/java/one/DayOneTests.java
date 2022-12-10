package one;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

public class DayOneTests {

  /**
   * Checks that actual SUM matches the expected one (the max sum search).
   * @param dataReadFromFile
   * @param expectedSum
   */
  @Test(
      dataProvider = "getTheMaxSumTestDataProvider",
      dataProviderClass = DayOneTestsDataProvider.class)
  public void getTheMaxSumTest(List<String> dataReadFromFile, int expectedSum) {
    DayOneDataProvider dayOneDataProviderMock =
        mock(DayOneDataProvider.class, withSettings().useConstructor("filePath"));
    DayOne dayOne = new DayOne(dayOneDataProviderMock);
    when(dayOneDataProviderMock.readFileToList())
        .thenReturn(dataReadFromFile); // the mocked data is used as the data read from file
    Assert.assertEquals(
        dayOne.getTheMaxSum(), expectedSum, "Actual SUM does not match an expected one!");
  }

  /**
   * Checks that exception is thrown if empty file with initial data is provided (the max sum search).
   */
  @Test(
      expectedExceptions = RuntimeException.class,
      expectedExceptionsMessageRegExp = "Not enough elements in the list")
  public void getTheMaxSumNegativeTest() {
    DayOneDataProvider dayOneDataProviderMock =
        mock(DayOneDataProvider.class, withSettings().useConstructor("filePath"));
    DayOne dayOne = new DayOne(dayOneDataProviderMock);
    when(dayOneDataProviderMock.readFileToList())
        .thenReturn(new ArrayList<>()); // the mocked data is used as the data read from file
    dayOne.getTheMaxSum();
  }

  /**
   * Checks that actual SUM matches the expected one (the sum of top 3 search).
   * @param dataReadFromFile
   * @param expectedSum
   */
  @Test(
      dataProvider = "getTheMaxSumFromTopThreeTestDataProvider",
      dataProviderClass = DayOneTestsDataProvider.class)
  public void getTheMaxSumFromTopThreeTest(List<String> dataReadFromFile, int expectedSum) {
    DayOneDataProvider dayOneDataProviderMock =
        mock(DayOneDataProvider.class, withSettings().useConstructor("filePath"));
    DayOne dayOne = new DayOne(dayOneDataProviderMock);
    when(dayOneDataProviderMock.readFileToList())
        .thenReturn(dataReadFromFile); // the mocked data is used as the data read from file
    Assert.assertEquals(
        dayOne.getTheMaxSumFromTopThree(),
        expectedSum,
        "Actual SUM does not match an expected one!");
  }

  /**
   * Checks that exception is thrown if empty file with initial data is provided (the sum of top 3 search).
   * @param dataReadFromFile
   */
  @Test(
      dataProvider = "getTheMaxSumFromTopThreeNegativeTestDataProvider",
      dataProviderClass = DayOneTestsDataProvider.class,
      expectedExceptions = RuntimeException.class,
      expectedExceptionsMessageRegExp = "Not enough elements in the list")
  public void getTheMaxSumFromTopThreeNegativeTest(List<String> dataReadFromFile) {
    DayOneDataProvider dayOneDataProviderMock =
        mock(DayOneDataProvider.class, withSettings().useConstructor("filePath"));
    DayOne dayOne = new DayOne(dayOneDataProviderMock);
    when(dayOneDataProviderMock.readFileToList())
        .thenReturn(dataReadFromFile); // the mocked data is used as the data read from file
    dayOne.getTheMaxSumFromTopThree();
  }
}
