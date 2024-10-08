package com.unsa.services.academics.users.infrastructure.adapters.in.web.mappers;

import com.unsa.services.academics.users.domain.models.User;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos.UserCreateCommand;
import com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos.UserResponse;

public class UserRestMapper {
    public static User createCommandToDomain(UserCreateCommand userCreateCommand) {
        return User.builder()
            .name(userCreateCommand.name())
            .lastname(userCreateCommand.lastname())
            .email(userCreateCommand.email())
            .password(userCreateCommand.password())
            .salt("salt")
            .build();
    }
    public static UserResponse toResponse(User user) {
        return UserResponse.builder()
            .id(user.getId())
            .name(user.getName())
            .lastname(user.getLastname())
            .email(user.getEmail())
            .build();
    }
}
