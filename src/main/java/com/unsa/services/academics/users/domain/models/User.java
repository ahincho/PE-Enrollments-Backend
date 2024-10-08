package com.unsa.services.academics.users.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String password;
    private String salt;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
    private List<Role> roles;
    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", salt=" + salt + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }
}
