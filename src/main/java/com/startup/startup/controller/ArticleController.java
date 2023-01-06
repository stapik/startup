package com.startup.startup.controller;

import com.startup.startup.dto.ArticleDTO;
import com.startup.startup.dto.CreateArticleDTO;
import com.startup.startup.dto.DayStatisticsDTO;
import com.startup.startup.dto.PageDTO;
import com.startup.startup.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @PostMapping
    public ArticleDTO create(@Valid CreateArticleDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public PageDTO<ArticleDTO> get(@RequestParam(value = "page", required = false) Integer page) {
        return service.list(page);
    }

    @GetMapping("stats")
    public List<DayStatisticsDTO> stats(){
        return service.getLastWeekStats();
    }
}
