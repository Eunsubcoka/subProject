package green.study.presentation.dto;

import green.study.domain.model.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
public class CourseReq {

    @Getter
    @Builder
    public static class create{
        @NotBlank(message = "강의 이름")
        private String title;

        @NotBlank(message = "강사 아이디")
        private String teacherId;

        @NotBlank(message = "강의 설명")
        private String description;

        @NotNull(message = "가격")
        private int price;

        public Course toCourse(){
            return Course.builder()
                    .teacherId(teacherId)
                    .title(title)
                    .description(description)
                    .price(price)
                    .build();

        }
    }
}
