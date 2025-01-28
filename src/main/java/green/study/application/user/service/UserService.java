package green.study.application.user.service;

import green.study.domain.user.entity.UserEntity;
import green.study.domain.user.model.User;
import green.study.infrastructure.repository.UserRepository;
import green.study.infrastructure.util.JwtUtil;
import green.study.presentation.dto.UserRes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService { // 유저에 관한 서비스
    
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    // 회원가입
    @Transactional
    public void registerUser(User user) {
        UserEntity userEntity = userRepository.save(user.toEntity());
        User.from(userEntity);

    }
    // 로그인
    public UserRes loginUser(User user) {

        UserEntity info = userRepository.findByUserId((user.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        if(!info.getPassword().equals(user.getPassword()) && !info.getRole().equals(user.getRole())) {
        return null;
        }
        String accessToken = jwtUtil.createAccessToken(User.from(info));

        return UserRes.from(info, accessToken);

    }


}
