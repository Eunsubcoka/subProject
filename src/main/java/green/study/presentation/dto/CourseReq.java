package green.study.presentation.dto;

import green.study.domain.course.model.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CourseReq {

    @Getter
    @Builder
    public static class create{
        @NotBlank(message = "강의 이름")
        private String title;

        @NotBlank(message = "유저 번호")
        private int userNo;

        @NotBlank(message = "강의 설명")
        private String description;

        @NotNull(message = "가격")
        private int price;

        public Course toCourse(){
            return Course.builder()
                    .userNo(userNo)
                    .title(title)
                    .description(description)
                    .price(price)
                    .build();

        }
    }
}
