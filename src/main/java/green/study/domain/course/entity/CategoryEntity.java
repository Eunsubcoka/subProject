package green.study.domain.course.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class CategoryEntity { // 카테고리 엔티티

    // 카테고리 넘버
    @Id
    @SequenceGenerator(name = "category_seq",sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_seq")
    private Long categoryNo;

    // 분류 키
    @Column(nullable = true)
    private String parantsNo;

    @Column(nullable = false)
    private String name;

}
