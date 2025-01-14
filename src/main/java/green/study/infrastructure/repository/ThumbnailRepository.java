package green.study.infrastructure.repository;

import green.study.domain.course.entity.ThumbnailEntity;
import org.springframework.data.repository.CrudRepository;

public interface ThumbnailRepository extends CrudRepository<ThumbnailEntity, Long> {
}
