package com.startup.startup.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateArticleDTO {

    private String title;

    private String author;

    private String content;

    private String publishedAt;
}
