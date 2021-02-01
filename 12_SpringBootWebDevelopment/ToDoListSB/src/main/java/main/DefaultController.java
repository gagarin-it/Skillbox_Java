package main;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
  @RequestMapping("/index")
  public String index(){
    return "index";
  }

}
