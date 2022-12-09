import lombok.SneakyThrows;
import one.DayOne;

public class Main {
  @SneakyThrows
  public static void main(String[] args) {
    //Day 1
    DayOne taskOne = new DayOne("/1/calories.txt");
    System.out.println(taskOne.getTheMaxSum());
  }
}
