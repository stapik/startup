package com.startup.startup.controller;

import com.startup.startup.dto.ArticleDTO;
import com.startup.startup.dto.CreateArticleDTO;
import com.startup.startup.dto.PageDTO;
import com.startup.startup.service.ArticleService;
import com.startup.startup.validator.ArticleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;
    private final ArticleValidator validator;

    @PostMapping
    public ArticleDTO create(CreateArticleDTO dto) throws Exception {
        validator.validate(dto);
        return service.create(dto);
    }

    @GetMapping
    public PageDTO<ArticleDTO> get(@RequestParam(value = "page", required = false) Integer page) {
        return service.list(page);
    }
}
