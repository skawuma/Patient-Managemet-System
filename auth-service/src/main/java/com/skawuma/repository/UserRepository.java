package com.skawuma.repository;

import com.skawuma.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * @author samuelkawuma
 * @package com.skawuma.repository
 * @project Patient-Managemet-System
 * @date 5/3/25
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);
}
