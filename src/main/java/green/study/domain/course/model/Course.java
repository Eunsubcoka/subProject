package green.study.domain.course.model;

import green.study.domain.course.entity.CourseEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Course {

    private long courseNo;

    private String title;

    private String description;

    private Long userNo;

    private int price;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .price(price)
                .description(description)
                .title(title)
                .build();
    }

}
