package apibank.club.bot;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebConsole {

  @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
  private String index(
          HttpServletRequest request,
          Model model) {

    //model.addAttribute("data",request.getParameterMap().toString());
    LoggerFactory.getLogger(getClass()).info("#####################################################################");
    LoggerFactory.getLogger(getClass()).info(request.getParameterMap().toString());
    LoggerFactory.getLogger(getClass()).info("#####################################################################");

    return "index";
  }
}
