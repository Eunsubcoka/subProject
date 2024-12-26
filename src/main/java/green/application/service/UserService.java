package green.application.service;

import green.domain.entity.UserEntity;
import green.domain.model.User;
import green.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerUser(User user) {
        UserEntity userEntity = userRepository.save(user.toEntity());
        return User.from(userEntity);

    }
    public User loginUser(User user) {

        User info = User.from(userRepository.findByUserId((user.getUserId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found")));

        if(!info.getPassword().equals(user.getPassword())) {
        return null;
        }
            return info;
    }


}
