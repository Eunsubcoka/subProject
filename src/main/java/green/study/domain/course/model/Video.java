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

    private String originName;

    private Long courseNo;

    public static VideoEntity toVideoEntity(Long courseNo, String originName) {
        return VideoEntity.builder()
                .courseNo(courseNo)
                .originName(originName)
                .build();
    }

}