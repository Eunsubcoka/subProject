package green.study.application.course.service;

import green.study.application.image.service.ImageService;
import green.study.domain.course.model.Course;
import green.study.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final ImageService  imageService;
    public void create(Course course, MultipartFile file) {
        try {
            imageService.createThumbnail(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        courseRepository.save(course.toEntity());
    }
}
