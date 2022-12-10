package one;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DayOneDataProvider {

  private final String filePath;

  public DayOneDataProvider(String filePath) {
    this.filePath = filePath;
  }

  @SneakyThrows
  public List<String> readFileToList() {
    final List<String> initialData = new ArrayList<>();
    try (InputStream in = getClass().getResourceAsStream(filePath);
         BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(in)))) {
      for (String line; (line = br.readLine()) != null; ) {
        initialData.add(line);
      }
    }
    return initialData;
  }
}
