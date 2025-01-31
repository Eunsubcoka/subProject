package green.study.domain.course.model;

import green.study.domain.course.entity.CategoryEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {

    private Long categoryNo;

    private String mainCategoryName;

    private String subCategoryName;

    private Long parentsNo;


    public CategoryEntity toMainEntity(Long courseNo){
        return CategoryEntity.builder()
                .courseNo(courseNo)
                .name(mainCategoryName)
                .parentsNo(null)
                .build();
    }
    public CategoryEntity toSubEntity(Long courseNo,Long parentsNo){
        return CategoryEntity.builder()
                .courseNo(courseNo)
                .name(subCategoryName)
                .parentsNo(parentsNo)
                .build();
    }


}
