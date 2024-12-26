package green.presentation.controller;

import green.application.service.UserService;
import green.domain.model.User;
import green.presentation.dto.UserLoginReq;
import green.presentation.dto.UserResReq;
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
    private final UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody @Valid UserResReq user) {
        return userService.registerUser(user.toUser());
    }
    @PostMapping("/login")
    public User login(@RequestBody @Valid UserLoginReq user) {
        return userService.loginUser(user.toUser());
    }
}
