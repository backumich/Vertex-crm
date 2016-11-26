package ua.com.vertex.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("message")
@RequestMapping("/welcome")
public class MainController {

    private static int count = 0;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView welcome() {
        String message = String.format("Welcome, you are %d today", ++count);
        ModelAndView result = new ModelAndView();
        result.setViewName("redirect:/welcome.jsp");
        result.addObject("message", message);
        return result;
    }

}
