package green.study.domain.course.model;

import green.study.domain.course.entity.CourseEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Category {

    private long courseNo;

    private String title;

    private String description;

    private Long userNo;

    private String price;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .price(price)
                .description(description)
                .title(title)
                .build();
    }

    public Course From(CourseEntity entity){
        return Course.builder()
                .courseNo(entity.getCourseNo())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .userNo(getUserNo())
                .price(entity.getPrice())
                .build();
    }

}
