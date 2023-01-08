package com.startup.startup.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ArticleDTO {

    private Long id;

    private String title;

    private String author;

    private String content;

    private LocalDateTime publishedAt;
}
