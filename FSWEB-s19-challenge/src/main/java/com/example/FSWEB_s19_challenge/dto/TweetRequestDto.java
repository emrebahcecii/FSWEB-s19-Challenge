package com.example.FSWEB_s19_challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record TweetRequestDto(
        @NotBlank
        @Size(max = 300)
        String content,

        @JsonProperty("user_id")
        Long userId
) {
}