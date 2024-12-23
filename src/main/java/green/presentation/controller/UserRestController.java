package green.presentation.controller;

import green.application.service.LoginService;
import green.application.service.RegisterService;
import green.domain.model.User;
import green.presentation.dto.UserReq;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRestController {
    private final LoginService loginService;
    private final RegisterService registerService;

    @PostMapping("/register")
    public User register(@RequestBody @Valid UserReq user) {
        return registerService.registerUser(user.toUser());
    }
}
