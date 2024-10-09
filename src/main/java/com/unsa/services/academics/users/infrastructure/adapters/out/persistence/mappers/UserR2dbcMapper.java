package com.unsa.services.academics.users.infrastructure.adapters.out.persistence.mappers;

import com.unsa.services.academics.users.domain.models.User;
import com.unsa.services.academics.users.infrastructure.adapters.out.persistence.entities.UserEntity;

public class UserR2dbcMapper {
    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
            .name(user.getName())
            .lastname(user.getLastname())
            .email(user.getEmail())
            .password(user.getPassword())
            .salt(user.getSalt())
            .build();
    }
    public static User toDomain(UserEntity userEntity) {
        return User.builder()
            .id(userEntity.getId())
            .name(userEntity.getName())
            .lastname(userEntity.getLastname())
            .email(userEntity.getEmail())
            .createdAt(userEntity.getCreatedAt())
            .updatedAt(userEntity.getUpdatedAt())
            .build();
    }
}
