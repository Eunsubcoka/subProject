package green.study.domain.course.model;

import green.study.domain.course.entity.CourseEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class Course {

    private long courseNo;

    private String title;

    private String description;

    private Long userNo;

    private String price;

    private Long likeCount;

    private Date createAt;


    public CourseEntity toEntity(){
        return CourseEntity.builder()
                .price(price)
                .description(description)
                .title(title)
                .userNo(userNo)
                .build();
    }

}
