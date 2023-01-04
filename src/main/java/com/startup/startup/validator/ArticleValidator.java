package com.startup.startup.validator;

import com.startup.startup.dto.CreateArticleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ArticleValidator {

    public void validate(CreateArticleDTO dto) throws Exception {
        if (dto.getTitle() == null || dto.getTitle().length() > 100) {
            throw new Exception("title exception");
        }
        if (Objects.isNull(dto.getContent())) {
            throw new Exception("content exception");
        }
        if (Objects.isNull(dto.getAuthor())) {
            throw new Exception("author exception");
        }
        try {
            LocalDateTime.parse(dto.getPublishedAt(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } catch (DateTimeParseException exception) {
            throw new Exception("publishedAt exception");
        }
    }
}
