package green.study.infrastructure.repository;

import green.study.domain.course.entity.CourseEntity;
import green.study.domain.course.entity.TagEntity;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<TagEntity,Long> {
}
