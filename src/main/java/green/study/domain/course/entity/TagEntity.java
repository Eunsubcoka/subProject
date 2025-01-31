package green.study.domain.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tag")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class TagEntity { // 태그 엔티티

    @Id
    @SequenceGenerator(name = "tag_seq",sequenceName = "tag_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "tag_seq")
    private Long tagNo;

    @Column(nullable = false)
    private String name;

    // 지칭하는 강의 넘버
    @Column(nullable = false)
    private Long courseNo;




}
