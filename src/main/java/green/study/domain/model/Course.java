package green.study.domain.model;

import green.study.domain.entity.CourseEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Course {

    private long courseNo;

    private String title;

    private String description;

    private String teacherId;

    private int price;

    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .price(price)
                .description(description)
                .title(title)
                .teacherId(teacherId).build();
    }

}
