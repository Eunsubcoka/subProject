package green.study.presentation.controller;

import green.study.application.course.service.CourseService;
import green.study.application.user.service.UserService;
import green.study.domain.user.model.User;
import green.study.infrastructure.util.CookieUtil;
import green.study.infrastructure.util.JwtUtil;
import green.study.presentation.dto.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

// 태그 및 카테고리를 포함한 프론트 만들기
@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class RestController {
    private final UserService userService;
    private final CourseService courseService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserReq.Signup user) {
        userService.registerUser(user.toUser());
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserReq.Login user, HttpServletResponse response, Model model) {
        UserRes member = userService.loginUser(user.toUser());
        model.addAttribute("member", member);
        response.addCookie(CookieUtil.createJwtCookie(member.getToken()));
        return ResponseEntity.ok("ok");
    }
    @PostMapping("/course")
    public void courses(@CookieValue(value = "JWT_TOKEN", required = true) final String token,
                        @RequestPart("courseData") CourseReq.Create courseReq,
                        @RequestPart("categoryData") CategoryReq categoryReq,
                        @RequestPart("tagData") TagReq tagReq,
                        @RequestPart("tagData") VideoReq videoReq,
                       @RequestPart(value = "thumbnail", required = false) MultipartFile file) throws IOException {

        User member = jwtUtil.getLoginUserFromAccessToken(token);
        courseService.create(courseReq.toCourse(member.getUserNo()),categoryReq.toCategory(),tagReq.getTags(),file,videoReq.getVideos());


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
