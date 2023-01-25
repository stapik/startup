package com.startup.startup.controller;

import com.startup.startup.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String username(@AuthenticationPrincipal User user) {
        return user.getUsername();
    }
}
