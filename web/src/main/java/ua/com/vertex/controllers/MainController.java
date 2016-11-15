package ua.com.vertex.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.com.vertex.dao.UserDaoInf;

@Controller
public class MainController {

    private static int count = 0;
    private UserDaoInf userDao;

    @Value("${driver}")
    String driverName;

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        String message = String.format("Welcome, you are %d today", ++count);
        ModelAndView result = new ModelAndView("redirect:/welcome.jsp", "message", message);
        System.out.println(userDao);
        return result;
    }

    @Autowired
    void setUserDao(UserDaoInf userDao) {
        this.userDao = userDao;
    }
}
