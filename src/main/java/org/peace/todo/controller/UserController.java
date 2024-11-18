package org.peace.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.peace.todo.dto.user.CreateUserRequest;
import org.peace.todo.dto.user.UpdateUserRequest;
import org.peace.todo.dto.user.UserResponse;
import org.peace.todo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1.0/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService ;


    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers() ;
    }

    @GetMapping("/{id}")
    public UserResponse getByIdUser(@PathVariable final UUID id) {
        return userService.getByIdUser(id) ;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody @Valid final CreateUserRequest createUserRequest) {
        return userService.createUser(createUserRequest) ;
    }
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable final UUID id, @RequestBody @Valid final UpdateUserRequest updateUserRequest) {
        return userService.updateUser(id, updateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final UUID id) {
        userService.deleteById(id);
    }


}
