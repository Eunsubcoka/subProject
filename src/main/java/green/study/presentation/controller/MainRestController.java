package green.study.presentation.controller;

import green.study.application.course.service.CourseService;
import green.study.domain.user.model.User;
import green.study.infrastructure.util.JwtUtil;
import green.study.presentation.dto.CourseRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api")
public class MainRestController {
    private final CourseService courseService;
    @GetMapping("/recommend/new-course")
    public List<CourseRes> newCourse(){
        return courseService.newCourseList();
    }

}
