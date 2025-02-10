package green.study.domain.course.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "course")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CourseEntity { // 강의 엔티티 (강의의 전반적인 내용을 담당)

    @Id
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long courseNo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String price;

    @Column(nullable = false)
    private Long userNo;


    @Column(nullable = false)
    private Date createAt;

    @Column(nullable = false)
    private Long likeCount;





}
