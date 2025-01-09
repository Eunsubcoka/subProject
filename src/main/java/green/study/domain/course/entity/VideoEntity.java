package green.study.domain.course.entity;

import jakarta.persistence.*;

public class VideoEntity {

    @Id
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long videoNo;

    @Column(nullable = false)
    private String convertName;

    @Column(nullable = false)
    private String videoPath;

    @Column(nullable = false)
    private String originName;

    @Column(nullable = false)
    private Long chapterNo;

    @Column(nullable = false)
    private Long thumbnailNo;
}
