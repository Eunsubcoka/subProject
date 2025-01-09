package green.study.domain.course.entity;

import jakarta.persistence.*;

import java.util.Date;

public class ThumbnailEntity {

    @Id
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long thumbnailNo;

    @Column(nullable = false)
    private String thumbnailPath;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private String convertName;

    @Column(nullable = false)
    private Date uploadTime;

    @Column(nullable = false)
    private Date deleteTime;
}
