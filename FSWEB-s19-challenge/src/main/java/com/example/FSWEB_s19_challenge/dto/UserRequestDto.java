package com.example.FSWEB_s19_challenge.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public record UserRequestDto(@NotEmpty
                             @NotBlank
                             @NotNull
                             @Size(max = 100)
                             String userName,

                             @Size(max = 100)
                             @Email
                             String email) {
}
