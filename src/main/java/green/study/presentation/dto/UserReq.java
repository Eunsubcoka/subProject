package green.study.presentation.dto;

import green.study.domain.user.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserReq {

    @Getter
    @Builder
    public static class Signup {

        @NotBlank(message = "이름 필수")
        private String name;

        @NotBlank(message = "아이디 필수")
        private String id;

        @NotBlank(message = "비밀번호 필수")
        private String password;

        @NotBlank(message = "확인 비밀번호 필수")
        private String confirmPassword;

        @NotBlank(message = "역할 필수")
        private String role;


        public User toUser(){
            return User.builder()
                    .userName(name)
                    .userId(id)
                    .password(password)
                    .role(role)
                    .build();
        }


    }

    @Getter
    @Builder
    public static class Login {


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


}
