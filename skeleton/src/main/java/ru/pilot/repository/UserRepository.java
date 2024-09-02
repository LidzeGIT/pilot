package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pilot.model.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(long id);
    Optional<User> findByUsername(String name);
}
