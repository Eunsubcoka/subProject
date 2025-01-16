package green.study.domain.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "thumbnail")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ThumbnailEntity { // 강의 썸네일(리스트에 보일 강의 이미지)

    @Id
    @SequenceGenerator(name = "thumbnail_seq",sequenceName = "thumbnail_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "thumbnail_seq")
    private Long thumbnailNo;

    @Column(nullable = false)
    private String thumbnailPath;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String convertName;

    @Column(nullable = false)
    private LocalDateTime uploadTime;

    @Column(nullable = true)
    private Date deleteTime;

    @Column(nullable = true)
    private Long courseNo;
}
