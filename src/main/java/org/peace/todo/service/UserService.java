package org.peace.todo.service;


import lombok.RequiredArgsConstructor;
import org.peace.todo.convertor.UserConvertor;
import org.peace.todo.dto.user.CreateUserRequest;
import org.peace.todo.dto.user.UpdateUserRequest;
import org.peace.todo.dto.user.UserResponse;
import org.peace.todo.model.User;
import org.peace.todo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository ;
    private final UserConvertor userConvertor ;



    public List<UserResponse> getAllUsers() {
        return  userRepository
                .findAll()
                .stream()
                .map(userConvertor::toResponse)
                .toList();
    }
    public UserResponse getByIdUser(final UUID id) {

        final User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        return userConvertor.toResponse(user) ;
    }


    public UserResponse createUser(final CreateUserRequest createUserRequest) {

        final User user = userConvertor.toEntity(createUserRequest);

        return userConvertor.toResponse(userRepository.save(user)) ;
    }
    public UserResponse updateUser(final UUID id, final UpdateUserRequest updateUserRequest) {

         User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser = userConvertor.toUpdateUser(existingUser, updateUserRequest);

        return userConvertor.toResponse(userRepository.save(existingUser));
    }
    public void deleteById(final UUID id) {

        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }

        userRepository.deleteById(id);
    }

}
