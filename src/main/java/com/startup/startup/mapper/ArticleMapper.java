package com.startup.startup.mapper;

import com.startup.startup.dto.ArticleDTO;
import com.startup.startup.entity.Article;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ArticleMapper {

    public ArticleDTO convertToDTO(Article article) {
        return ArticleDTO.builder()
                .author(article.getAuthor())
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getContent())
                .publishedAt(article.getPublishedAt())
                .build();
    }

    public ArticleDTO mapArticleRowToDto(ResultSet row, int rowNum) throws SQLException {
        return ArticleDTO.builder()
                .id(row.getLong("id"))
                .title(row.getString("title"))
                .content(row.getString("content"))
                .author(row.getString("author"))
                .publishedAt(row.getTimestamp("published_at").toLocalDateTime())
                .build();
    }
}

