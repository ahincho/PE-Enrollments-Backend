package com.unsa.services.academics.users.infrastructure.adapters.out.persistence.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String salt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
