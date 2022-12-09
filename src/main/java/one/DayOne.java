package one;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DayOne {
  private final List<String> data;

  @SneakyThrows
  public DayOne(String filePath) {
    this.data = new ArrayList<>();
    try (FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr)) {
      for (String line; (line = br.readLine()) != null; ) {
        data.add(line);
      }
    }
  }

  public int getTheMaxSum() {
    int currSum = 0;
    int maxSum = 0;
    for (String calorie : data) {
      if (!calorie.isEmpty()) {
        currSum += Integer.parseInt(calorie);
      } else {
        if (maxSum < currSum) {
          maxSum = currSum;
        }
        currSum = 0;
      }
    }
    return maxSum;
  }
}
