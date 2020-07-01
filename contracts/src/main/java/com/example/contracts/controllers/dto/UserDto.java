package com.example.contracts.controllers.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    @NonNull
    private String name;
    @NonNull
    private String lastName;
}
