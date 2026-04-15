package org.umaxcodesma.socialmediaapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.umaxcodesma.socialmediaapp.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findByUsername(String username);
}
