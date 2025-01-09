package green.study.domain.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ChapterEntity {

    @Id
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long chapterNo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int orderNo;

    @Column(nullable = false)
    private Long courseNo;

//    // 강사
//    @ManyToOne
//    @JoinColumn(name = "teacher", nullable = false)
//    private UserEntity teacher; // User.role == TEACHER

//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<EnrollmentEntity> enrollments;
}
