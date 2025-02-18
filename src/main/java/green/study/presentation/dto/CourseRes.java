package green.study.presentation.dto;

import green.study.application.course.service.CourseService;
import green.study.domain.course.model.Course;
import green.study.domain.course.model.Thumbnail;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
public class CourseRes {

    private long courseNo;

    private String title;

    private String description;

    private String thumbnailPath;

    private String convertName;

    private String price;

    private Long likeCount;

    private Date createAt;

    private Long userNo;


    public CourseRes from(Course course, Thumbnail thumbnail) {
          return CourseRes.builder()
                  .courseNo(course.getCourseNo())
                  .title(course.getTitle())
                  .thumbnailPath(thumbnail.getThumbnailPath())
                  .convertName(thumbnail.getConvertName())
                  .description(course.getDescription())
                  .createAt(course.getCreateAt())
                  .build();
    }


}
