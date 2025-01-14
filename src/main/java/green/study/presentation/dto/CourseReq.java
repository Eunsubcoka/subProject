package green.study.presentation.dto;

import green.study.domain.course.model.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CourseReq {

    @Getter
    @Builder
    public static class create{
        @NotBlank(message = "강의 이름")
        private String title;



        @NotBlank(message = "강의 설명")
        private String description;

        @NotBlank(message = "가격")
        private int price;



        public Course toCourse(){
            return Course.builder()
                    .title(title)
                    .description(description)
                    .price(price)
                    .build();

        }
    }
}
