package green.presentation.dto;

import green.domain.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder

public class UserLoginReq {


    @NotBlank(message = "아이디 필수")
    private String id;

    @NotBlank(message = "비밀번호 필수")
    private String password;

    @NotBlank(message = "역할 필수")
    private String role;


    public User toUser(){
        return User.builder()
                .userId(id)
                .password(password)
                .role(role)
                .build();
    }


}
