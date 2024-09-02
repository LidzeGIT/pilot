package ru.pilot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pilot.model.entity.User;
import ru.pilot.model.entity.UserRole;
import ru.pilot.repository.UserRepository;
import ru.pilot.repository.UserRoleRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService  {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    UserRoleRepository userRoleRepository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }


    public Optional<User> getUserById(long id) {
        return repository.findById(id);
    }

    public List<UserRole> getAllUserRole() {
        return userRoleRepository.findAll();
    }
}
