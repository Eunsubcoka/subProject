package green.study.application.service;

import green.study.domain.entity.UserEntity;
import green.study.domain.model.User;
import green.study.infrastructure.repository.UserRepository;
import green.study.infrastructure.util.JwtUtil;
import green.study.presentation.dto.UserRes;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public void registerUser(User user) {
        UserEntity userEntity = userRepository.save(user.toEntity());
        User.from(userEntity);

    }
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
