package goodr0ne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheThingEndpoints {

  @GetMapping("/")
  public String welcome(@RequestParam(name="name", required=false, defaultValue="World") String name) {
    return "Welcome, " + name;
  }
}
