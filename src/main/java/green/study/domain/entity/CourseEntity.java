package green.study.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "course")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseEntity {

    @Id
    @SequenceGenerator(name = "course_seq",sequenceName = "course_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_seq")
    private Long courseNo;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String teacherId;

//    // 강사
//    @ManyToOne
//    @JoinColumn(name = "teacher", nullable = false)
//    private UserEntity teacher; // User.role == TEACHER

//    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
//    private List<EnrollmentEntity> enrollments;
}
