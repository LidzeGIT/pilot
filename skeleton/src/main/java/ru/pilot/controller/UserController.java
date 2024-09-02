package ru.pilot.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import ru.pilot.model.entity.User;
import ru.pilot.model.entity.UserRole;
import ru.pilot.repository.UserRepository;
import ru.pilot.service.UserService;

import java.util.List;

import static ru.pilot.exception.ErrorConstants.USER_NOT_FOUND;

@Tag(name = "UserController", description = "")
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User> getUser(@RequestParam("id") long id) {
        User user = userService.getUserById(id)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND.formatted(id)));
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/getAllUserRole")
    public List<UserRole> getAllUserRole() {
        return userService.getAllUserRole();
    }
}
