package com.unsa.services.academics.users.infrastructure.adapters.in.web.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private String lastname;
    private String email;
}
