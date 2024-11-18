package org.peace.todo.convertor;

import org.peace.todo.dto.user.CreateUserRequest;
import org.peace.todo.dto.user.UpdateUserRequest;
import org.peace.todo.dto.user.UserResponse;
import org.peace.todo.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserConvertor {



    public User toEntity(final CreateUserRequest createUserRequest) {

        User user = new User() ;
        user.setName(createUserRequest.name());
        user.setUsername(createUserRequest.username());
        user.setEmail(createUserRequest.email());
        user.setPassword(createUserRequest.password());
        return user;
    }
    public User toUpdateUser(final User existuser, final UpdateUserRequest updateUserRequest) {
       existuser.setName(updateUserRequest.name());
        existuser.setUsername(updateUserRequest.username());
        existuser.setEmail(updateUserRequest.email());

        return existuser;
    }

    public UserResponse toResponse(final User user) {
        return new UserResponse(user.getId(),
                user.getName(),
                user.getUsername(),
                user.getEmail());
    }
}
