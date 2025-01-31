package green.study.infrastructure.repository;

import green.study.domain.course.entity.CategoryEntity;
import green.study.domain.course.entity.CourseEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity,Long> {
}
