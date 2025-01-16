package green.study.presentation.controller;

import green.study.domain.user.model.User;
import green.study.infrastructure.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {
    private final JwtUtil jwtUtil;
    @GetMapping("/")
    public String index(@CookieValue(value = "JWT_TOKEN", required = false) final String token,
                        Model model) {
        getTokenAndReturn(token, model);
        return "index";
    }

    @GetMapping("/signup")
    public String signup() {
        return "member/signup";
    }

    @GetMapping("/login")
    public String login() {
        return "member/login";
    }

    @GetMapping("/myPage")
    public String myPage(@CookieValue(value = "JWT_TOKEN", required = true) final String token,
                         Model model){

        getTokenAndReturn(token, model);
        return "member/myPage";
    }
    @GetMapping("/enroll/courses")
    public String enrollCourses(@CookieValue(value = "JWT_TOKEN", required = true) final String token,
                         Model model){

        getTokenAndReturn(token, model);
        return "course/enroll";
    }

    protected void getTokenAndReturn(String token, Model model){
        User member = jwtUtil.getLoginUserFromAccessToken(token);
        model.addAttribute("member", member);
    }
}
