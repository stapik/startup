package com.startup.startup.mapper;

import com.startup.startup.dto.ArticleDTO;
import com.startup.startup.entity.Article;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper {

    public ArticleDTO convertToDTO(Article article) {
        return ArticleDTO.builder()
                .author(article.getAuthor())
                .title(article.getTitle())
                .content(article.getContent())
                .publishedAt(article.getPublishedAt())
                .build();
    }
}

