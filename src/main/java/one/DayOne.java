package one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DayOne {

  private final DayOneDataProvider dayOneDataProvider;

  public DayOne(DayOneDataProvider dayOneDataProvider) {
    this.dayOneDataProvider = dayOneDataProvider;
  }

  private List<Integer> getListOfSums(List<String> initialData) {
    List<Integer> listOfSums = new ArrayList<>();
    if (!initialData.isEmpty()) {
      int currSum = 0;
      for (String calorie : initialData) {
        if (!calorie.isEmpty()) {
          currSum += Integer.parseInt(calorie);
        } else {
          listOfSums.add(currSum);
          currSum = 0;
        }
      }
      listOfSums.add(currSum); // to add the calories of the last elf, cause file does not ent with empty line
    }
    return listOfSums;
  }

  private void sortListDesc(List<Integer> list) {
    list.sort(Collections.reverseOrder());
  }

  private List<Integer> getListOfSumsSortedInDescOrder() {
    List<String> initialData = dayOneDataProvider.readFileToList();
    List<Integer> listOfSums = getListOfSums(initialData);
    sortListDesc(listOfSums);
    return listOfSums;
  }

  public int getTheMaxSum() {
    List<Integer> sortedListOfSums = getListOfSumsSortedInDescOrder();
    if (sortedListOfSums.isEmpty()) throw new RuntimeException("Not enough elements in the list");
    return sortedListOfSums.get(0);
  }

  public int getTheMaxSumFromTopThree() {
    List<Integer> sortedListOfSums = getListOfSumsSortedInDescOrder();
    if (sortedListOfSums.size() < 3) throw new RuntimeException("Not enough elements in the list");
    return sortedListOfSums.get(0) + sortedListOfSums.get(1) + sortedListOfSums.get(2);
  }
}
