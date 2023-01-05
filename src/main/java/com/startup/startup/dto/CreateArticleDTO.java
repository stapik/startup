package com.startup.startup.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
public class CreateArticleDTO {

    @Size(min = 1, max = 100)
    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String content;

    @NotNull
    private LocalDateTime publishedAt;
}
