package com.startup.startup.controller;

import com.startup.startup.dto.*;
import com.startup.startup.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService service;

    @PostMapping
    public ArticleDTO create(@Valid @RequestBody CreateArticleDTO dto) {
        return service.create(dto);
    }

    @PutMapping
    public ArticleDTO update(@Valid @RequestBody UpdateArticleDTO dto){
        return service.update(dto);
    }

    @GetMapping
    public Page<ArticleDTO> get(@RequestParam(value = "page", required = false) Integer page) {
        return service.list(page);
    }

    @GetMapping("stats")
    public List<DayStatisticsDTO> stats(){
        return service.getLastWeekStats();
    }
}
