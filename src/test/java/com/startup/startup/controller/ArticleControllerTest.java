package com.startup.startup.controller;

import com.startup.startup.dto.CreateArticleDTO;
import com.startup.startup.service.ArticleService;
import com.startup.startup.validator.ArticleValidator;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ArticleControllerTest {

    ArticleController articleController = new ArticleController(
            Mockito.mock(ArticleService.class),
            new ArticleValidator()
    );

    @Test
    public void createTest() throws Exception {
        CreateArticleDTO dto = CreateArticleDTO.builder()
                .content("Article content")
                .author("Test Test")
                .title(Strings.repeat("a", 101))
                .publishedAt(LocalDateTime.now().toString())
                .build();
        assertThrows(Exception.class, () -> articleController.create(dto));

        dto.setTitle("title");
        articleController.create(dto);

        dto.setAuthor(null);
        assertThrows(Exception.class, () -> articleController.create(dto));

        dto.setAuthor("Test Test");
        dto.setContent(null);
        assertThrows(Exception.class, () -> articleController.create(dto));

        dto.setTitle(null);
        dto.setContent("Content");
        assertThrows(Exception.class, () -> articleController.create(dto));

        dto.setTitle("Title");
        articleController.create(dto);
    }
}
