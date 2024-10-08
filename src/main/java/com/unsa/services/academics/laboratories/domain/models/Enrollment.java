package com.unsa.services.academics.laboratories.domain.models;

import com.unsa.services.academics.users.domain.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    private Long id;
    private Long laboratoryId;
    private Long userId;
}
