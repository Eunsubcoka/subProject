package green.study.infrastructure.repository;

import green.study.domain.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<CourseEntity,Long> {
}
