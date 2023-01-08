package com.startup.startup.service;

import com.startup.startup.dto.*;
import com.startup.startup.entity.Article;
import com.startup.startup.mapper.ArticleMapper;
import com.startup.startup.repository.ArticleJdbcRepository;
import com.startup.startup.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository repository;

    private final ArticleJdbcRepository jdbcRepository;

    private final ArticleMapper mapper;

    public ArticleDTO create(CreateArticleDTO dto) {
        Article article = new Article();
        article.setAuthor(dto.getAuthor());
        article.setTitle(dto.getTitle());
        article.setContent(dto.getContent());
        article.setPublishedAt(dto.getPublishedAt());
        return mapper.convertToDTO(repository.save(article));
    }

    public ArticleDTO update(UpdateArticleDTO dto) {
        jdbcRepository.update(dto);
        return find(dto.getId());
    }

    public ArticleDTO find(Long id){
        return jdbcRepository.findById(id);
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

    public List<DayStatisticsDTO> getLastWeekStats() {
        return jdbcRepository.getStatisticsByDayAfterDate(
                LocalDate.now().atStartOfDay().minus(6, ChronoUnit.DAYS)
        );
    }
}
