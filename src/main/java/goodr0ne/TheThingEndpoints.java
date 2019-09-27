package goodr0ne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheThingEndpoints {
  private TheThingCalculator calculator = TheThingCalculator.getInstance();

  @GetMapping("/")
  public String welcome() {
    return "Welcome, human";
  }

  @GetMapping("/add")
  public String add(@RequestParam(name="number") int number) {
    if (!calculator.addNewNumber(number)) {
      return "bip... blop... List is completely filled!";
    }
    return "bip... blop...";
  }

  @GetMapping("/max")
  public String getMax() {
    return "bip... blop... Max is... " + calculator.retrieveMax();
  }

  @GetMapping("/min")
  public String getMin() {
    return "bip... blop... Min is... " + calculator.retrieveMin();
  }

  @GetMapping("/avg")
  public String getAverage() {
    return "bip... blop... Average is... " + calculator.calculateAverage();
  }

  @GetMapping("/clear")
  public String clear() {
    calculator.clear();
    return "bip... blop... List is wiped... ";
  }
}
