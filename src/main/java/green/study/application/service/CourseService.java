package green.study.application.service;

import green.study.domain.entity.CourseEntity;
import green.study.domain.model.Course;
import green.study.infrastructure.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public void create(Course course) {
        courseRepository.save(course.toEntity());
    }
}
