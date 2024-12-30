package green.study.presentation.controller;

import green.study.application.service.UserService;
import green.study.domain.model.User;
import green.study.infrastructure.util.CookieUtil;
import green.study.presentation.dto.UserReq;
import green.study.presentation.dto.UserRes;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRestController {
    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserReq.Signup user) {
        userService.registerUser(user.toUser());
    }
    @PostMapping("/login")
    public void login(@RequestBody @Valid UserReq.Login user, HttpServletResponse response) {
         UserRes member = userService.loginUser(user.toUser());
        response.addCookie(CookieUtil.createJwtCookie(member.getToken()));
    }
}
