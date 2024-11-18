package org.peace.todo.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UpdateUserRequest(

        @NotBlank
        String name,
        @NotBlank
        String username,
        @NotBlank
        @Email
        String email) {
}
