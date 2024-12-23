package green.application.service;

import green.domain.entity.UserEntity;
import green.domain.model.User;
import green.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterService {
    private final UserRepository userRepository;

    public User registerUser(User user) {
        UserEntity userEntity = userRepository.save(user.toEntity());
        return User.from(userEntity);

    }
}
