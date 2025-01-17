package green.study.presentation.controller;

import green.study.application.course.service.CourseService;
import green.study.application.user.service.UserService;
import green.study.infrastructure.util.CookieUtil;
import green.study.presentation.dto.CourseReq;
import green.study.presentation.dto.UserReq;
import green.study.presentation.dto.UserRes;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class RestController {
    private final UserService userService;
    private final CourseService courseService;

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserReq.Signup user) {
        userService.registerUser(user.toUser());
    }

    @PostMapping("/login")
    public void login(@RequestBody @Valid UserReq.Login user, HttpServletResponse response, Model model) {
        UserRes member = userService.loginUser(user.toUser());
        model.addAttribute("member", member);
        response.addCookie(CookieUtil.createJwtCookie(member.getToken()));
        response.setStatus(500);
    }
    @PostMapping("/course")
    public void courses(@RequestBody @Valid CourseReq.Create courseReq,
                        @RequestParam(value = "thumbnail", required = false)MultipartFile file){
        System.out.println(file.getOriginalFilename());
        courseService.create(courseReq.toCourse(),file);

    }
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        // 모든 쿠키 가져오기
        Cookie[] cookies = request.getCookies();
        cookies = CookieUtil.deleteCookie(cookies);
        for(Cookie cookie : cookies){
            response.addCookie(cookie);
        }
        return ResponseEntity.ok("로그아웃되었습니다.");
    }
}
