package green.study.infrastructure.repository;

import green.study.domain.course.entity.CourseEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity,Long> {
    List<CourseEntity> findAll(Sort createAt);
}
