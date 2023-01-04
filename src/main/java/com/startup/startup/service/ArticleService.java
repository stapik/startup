package com.startup.startup.service;

import com.startup.startup.dto.ArticleDTO;
import com.startup.startup.dto.CreateArticleDTO;
import com.startup.startup.dto.PageDTO;
import com.startup.startup.entity.Article;
import com.startup.startup.mapper.ArticleMapper;
import com.startup.startup.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleMapper mapper;

    public ArticleDTO create(CreateArticleDTO dto) {
        Article article = new Article();
        article.setAuthor(dto.getAuthor());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setPublishedAt(LocalDateTime.parse(dto.getPublishedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        return mapper.convertToDTO(repository.save(article));
    }

    public PageDTO<ArticleDTO> list(Integer pageNumber) {
        pageNumber = Objects.requireNonNullElse(pageNumber, 0);
        Page<Article> page = repository.findAll(PageRequest.of(pageNumber, 5));
        PageDTO<ArticleDTO> result = new PageDTO<>();
        result.setContent(page.map(mapper::convertToDTO).toList());
        result.setTotalPages(page.getTotalPages());
        result.setTotalElements(page.getTotalElements());
        return result;
    }
}
