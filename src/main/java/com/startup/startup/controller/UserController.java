package com.startup.startup.controller;

import com.startup.startup.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public String username(@AuthenticationPrincipal User user) {
        return user.getUsername();
    }

    @GetMapping("list")
    @PreAuthorize("hasRole('SYSTEM')")
    public List<String> users() {
        return List.of("admin", "user");
    }

    @Secured("ROLE_ADMIN")
    public String userPassword(@AuthenticationPrincipal User user) {
        return user.getPassword();
    }
}
