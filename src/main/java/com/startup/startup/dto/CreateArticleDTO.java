package com.startup.startup.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
public class CreateArticleDTO {

    @Size(min = 1, max = 100)
    @NotNull
    private String title;

    @NotNull
    private String author;

    @NotNull
    private String content;

    @NotNull
    private LocalDateTime publishedAt;
}
