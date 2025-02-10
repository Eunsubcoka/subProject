package green.study.application.course.service;

import green.study.application.image.service.ImageService;
import green.study.domain.course.entity.CategoryEntity;
import green.study.domain.course.entity.CourseEntity;
import green.study.domain.course.entity.TagEntity;
import green.study.domain.course.entity.VideoEntity;
import green.study.domain.course.model.Category;
import green.study.domain.course.model.Course;
import green.study.domain.course.model.Tag;
import green.study.infrastructure.repository.CategoryRepository;
import green.study.infrastructure.repository.CourseRepository;
import green.study.infrastructure.repository.TagRepository;
import green.study.infrastructure.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static green.study.domain.course.model.Tag.toTagEntity;
import static green.study.domain.course.model.Video.toVideoEntity;

@Service
@RequiredArgsConstructor
public class CourseService {  // 강의에 대한 서비스

    private final CourseRepository courseRepository;
    private final ImageService  imageService;
    private final CategoryRepository categoryRepository;
    private final TagRepository tagRepository;
    private final VideoRepository videoRepository;

    // 강의 생성
    @Transactional
    public void create(Course course, Category category, List<String> tag , MultipartFile file,List<String> video) throws IOException {
            CourseEntity courseEntity = courseRepository.save(course.toEntity());
            CategoryEntity categoryEntity =  categoryRepository.save(category.toMainEntity(courseEntity.getCourseNo()));
            categoryRepository.save(category.toSubEntity(courseEntity.getCourseNo(),categoryEntity.getCategoryNo()));

            for (String tagName : tag) {
                Tag.from(tagRepository.save(toTagEntity(courseEntity.getCourseNo(), tagName)));
            }
            for (String videoName : video){
                videoRepository.save(toVideoEntity(categoryEntity.getCategoryNo(), videoName));
            }

            imageService.createThumbnail(file, courseEntity.getCourseNo());

    }
}
