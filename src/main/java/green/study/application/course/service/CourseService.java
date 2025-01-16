package green.study.application.course.service;

import green.study.application.image.service.ImageService;
import green.study.domain.course.entity.CourseEntity;
import green.study.domain.course.model.Course;
import green.study.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CourseService {  // 강의에 대한 서비스

    private final CourseRepository courseRepository;
    private final ImageService  imageService;

    // 강의 생성
    public void create(Course course, MultipartFile file) {
        try {
            CourseEntity save = courseRepository.save(course.toEntity());

            imageService.createThumbnail(file, save.getCourseNo());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        courseRepository.save(course.toEntity());
    }
}
