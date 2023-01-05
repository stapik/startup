package com.startup.startup.validator;

import com.startup.startup.dto.CreateArticleDTO;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CreateArticleValidatorTest {

    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void close() {
        validatorFactory.close();
    }

    @Test
    public void createTest() {
        CreateArticleDTO dto = CreateArticleDTO.builder()
                .content("Article content")
                .author("Test Test")
                .title(Strings.repeat("a", 101))
                .publishedAt(null)
                .build();
        assertFalse(validator.validate(dto).isEmpty());

        dto.setPublishedAt(LocalDateTime.now());
        assertFalse(validator.validate(dto).isEmpty());

        dto.setTitle("small");
        assertTrue(validator.validate(dto).isEmpty());

        dto.setAuthor(null);
        assertFalse(validator.validate(dto).isEmpty());

        dto.setAuthor("Test Test");
        dto.setContent(null);
        assertFalse(validator.validate(dto).isEmpty());

        dto.setTitle(null);
        dto.setContent("Content");
        assertFalse(validator.validate(dto).isEmpty());

        dto.setTitle("Title");
        assertTrue(validator.validate(dto).isEmpty());
    }
}
