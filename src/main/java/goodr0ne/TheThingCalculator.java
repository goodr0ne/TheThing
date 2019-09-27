package goodr0ne;

import java.util.*;

public class TheThingCalculator {
  private static TheThingCalculator ourInstance = new TheThingCalculator();
  private List<Integer> allNumbers;
  private boolean isSorted = false;
  private final int MAX_SIZE = Integer.MAX_VALUE - 10;

  public static TheThingCalculator getInstance() {
    return ourInstance;
  }

  private TheThingCalculator() {
    allNumbers = new ArrayList<>();
  }

  private void sortNumbers() {
    if (!isSorted) {
      Collections.sort(allNumbers);
      isSorted = true;
    }
  }

  public synchronized boolean addNewNumber(int number) {
    if (allNumbers.size() > MAX_SIZE) {
      return false;
    }
    allNumbers.add(number);
    isSorted = false;
    return true;
  }

  public synchronized void clear() {
    allNumbers = new ArrayList<>();
  }

  public synchronized double calculateAverage() {
    if (allNumbers.size() < 1) {
      return 0;
    }
    sortNumbers();
    OptionalDouble average = allNumbers.stream().mapToDouble(a -> a).average();
    if (average.isPresent()) {
      return average.getAsDouble();
    } else {
      return 0;
    }
  }

  public synchronized int retrieveMax() {
    if (allNumbers.size() < 1) {
      return 0;
    }
    sortNumbers();
    return allNumbers.get(allNumbers.size() - 1);
  }

  public synchronized int retrieveMin() {
    if (allNumbers.size() < 1) {
      return 0;
    }
    sortNumbers();
    return allNumbers.get(0);
  }
}
