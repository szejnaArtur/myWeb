package com.example.myWeb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    @GetMapping("/home")
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

}
