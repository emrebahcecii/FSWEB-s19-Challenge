package com.example.FSWEB_s19_challenge.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RetweetRequestDto(@Column(name = "source")
                                @NotBlank
                                @Size(max = 100)
                                String source) {
}
