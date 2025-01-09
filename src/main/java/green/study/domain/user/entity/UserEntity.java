package green.study.domain.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MEMBER")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private Long userNo;

    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String role;


    // 학생이 수강 신청한 강의 목록
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    private List<EnrollmentEntity> enrollments;
//
//    // 강사가 등록한 강의 목록
//    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
//    private List<CourseEntity> courses;



}