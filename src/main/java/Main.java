import lombok.SneakyThrows;
import one.DayOne;
import one.DayOneDataProvider;

public class Main {
  @SneakyThrows
  public static void main(String[] args) {
    //Day 1
    DayOne taskOne = new DayOne(new DayOneDataProvider("/1/calories.txt"));
    System.out.println("One elf - MAX calories SUM: " + taskOne.getTheMaxSum());
    System.out.println("Three top elves - calories SUM: " + taskOne.getTheMaxSumFromTopThree());
  }
}
