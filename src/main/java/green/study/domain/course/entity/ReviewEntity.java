package green.study.domain.course.entity;

import jakarta.persistence.*;

import java.util.Date;

public class ReviewEntity {

    @Id
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long reviewNo;

    @Column(nullable = false)
    private String rating;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Long courseNo;

    @Column(nullable = false)
    private Long userNo;

    @Column(nullable = false)
    private Date createTime;
}
