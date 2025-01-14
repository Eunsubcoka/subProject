package green.study.domain.course.model;

import green.study.domain.course.entity.ThumbnailEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class Thumbnail {

    private Long thumbnailNo;

    private String thumbnailPath;

    private String originName;

    private String convertName;

    private LocalDateTime uploadTime;

    private LocalDateTime deleteTime;



    public ThumbnailEntity toEntity(){
        return ThumbnailEntity.builder()
                .thumbnailPath(thumbnailPath)
                .originName(originName)
                .convertName(convertName)
                .uploadTime(uploadTime)
                .build();
    }

}
