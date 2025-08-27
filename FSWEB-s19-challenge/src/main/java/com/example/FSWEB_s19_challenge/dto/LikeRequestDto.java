package com.example.FSWEB_s19_challenge.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LikeRequestDto(@Column(name = "mood")
                             @NotNull
                             @NotEmpty
                             @NotBlank
                             @Size(max = 100)
                             String mood) {
}
