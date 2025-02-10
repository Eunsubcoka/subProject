package green.study.infrastructure.repository;

import green.study.domain.course.entity.CourseEntity;
import green.study.domain.course.entity.VideoEntity;
import org.springframework.data.repository.CrudRepository;


public interface VideoRepository extends CrudRepository<VideoEntity,Long> {
}
