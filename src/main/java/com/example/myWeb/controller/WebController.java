package com.example.myWeb.controller;

import com.example.myWeb.component.mailer.SignUpMailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    private final SignUpMailer mailer;

    @Autowired
    public WebController(SignUpMailer mailer) {
        this.mailer = mailer;
    }

    @GetMapping("/")
    public ModelAndView main(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/home")
    public ModelAndView userPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @GetMapping("/skill")
    public ModelAndView skillPanel(ModelAndView modelAndView) {
        modelAndView.setViewName("skill");
        return modelAndView;
    }

    @PostMapping("/send_message")
    public ModelAndView sendMessage(ModelAndView modelAndView, @RequestParam("name") String name,
                                    @RequestParam("email") String email, @RequestParam("subject") String subject,
                                    @RequestParam("text") String text) {
        String message = "Od: " + name + "\nEmail: " + email + "\n\n" + text;
        mailer.sendMessage("arturtest69@gmail.com", subject, message);
        modelAndView.setViewName("home");

        return modelAndView;
    }

}
