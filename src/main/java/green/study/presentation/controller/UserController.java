package green.study.presentation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }
    @GetMapping("/login")
    public String login() {
        return "member/login";
    }
}