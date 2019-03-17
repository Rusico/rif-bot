package apibank.club.bot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebConsole {

  @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
  private String index(Model model) {
    return "index";
  }
}
