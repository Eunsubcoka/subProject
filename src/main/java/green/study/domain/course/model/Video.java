package green.study.domain.course.model;


import green.study.domain.course.entity.VideoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Video {

    private Long videoNo;

    private String title;

    private Long courseNo;

    public static VideoEntity toVideoEntity(Long courseNo, String title) {
        return VideoEntity.builder()
                .courseNo(courseNo)
                .title(title)
                .build();
    }

}