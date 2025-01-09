package green.study.domain.user.model;

import green.study.domain.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private Long userNo;

    private String userId;
    private String password;
    private String userName;
    private String role;

    public static User from(UserEntity userEntity) {
        return User.builder()
                .userNo(userEntity.getUserNo())
                .userId(userEntity.getUserId())
                .password(userEntity.getPassword())
                .userName(userEntity.getUserName())
                .role(userEntity.getRole())
                .build();
    }

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(userId)
                .password(password)
                .userName(userName)
                .role(role)
                .build();
    }
}
