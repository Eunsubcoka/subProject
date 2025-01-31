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
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq",allocationSize = 1)
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




}