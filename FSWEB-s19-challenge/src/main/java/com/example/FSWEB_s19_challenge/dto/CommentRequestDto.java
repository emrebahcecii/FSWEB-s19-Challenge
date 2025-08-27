package com.example.FSWEB_s19_challenge.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


public record CommentRequestDto(@NotEmpty
                                @NotBlank
                                @NotNull
                                @Size(max = 300)
                                @Column(name = "content")
                                String content,

                                @NotNull
                                Long userId,

                                @NotNull
                                Long tweetId) {


}
