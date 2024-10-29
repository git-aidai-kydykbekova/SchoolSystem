package com.example.Software_P.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class RoleDto {
    private Long userId;
    private Set<Long> roleIdSet;

    public RoleDto(){}
}
