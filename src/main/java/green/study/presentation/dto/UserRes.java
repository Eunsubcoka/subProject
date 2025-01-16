package green.study.presentation.dto;

import green.study.domain.user.entity.UserEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRes {
    private Long id;
    private String token;
    private String role;


    public static UserRes from(UserEntity user, String generateToken) {
        return UserRes.builder()
                .id(user.getUserNo())
                .token(generateToken)
                .role(user.getRole())
                .build();
    }
}
