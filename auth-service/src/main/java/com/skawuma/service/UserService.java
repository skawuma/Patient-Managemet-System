package com.skawuma.service;

import com.skawuma.model.User;
import com.skawuma.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author samuelkawuma
 * @package com.skawuma.service
 * @project Patient-Managemet-System
 * @date 5/3/25
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
