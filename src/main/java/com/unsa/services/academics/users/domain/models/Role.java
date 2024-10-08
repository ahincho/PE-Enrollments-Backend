package com.unsa.services.academics.users.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private Long id;
    private String name;
    private LocalDate updatedAt;
    private LocalDate createdAt;
    @Override
    public String toString() {
        return "Role[id=" + id + ", name=" + name + ", updatedAt=" + updatedAt + ", createdAt=" + createdAt + "]";
    }
}
