package one;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DayOne {
  private final List<String> data;

  @SneakyThrows
  public DayOne(String filePath) {
    this.data = new ArrayList<>();
    try (InputStream in = getClass().getResourceAsStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))) {
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
