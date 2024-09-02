package ru.pilot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pilot.model.entity.User;
import ru.pilot.model.entity.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    User findById(long id);

}
