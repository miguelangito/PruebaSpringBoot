package com.riwi.PruebaSpringBoot.api.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.PruebaSpringBoot.api.dto.response.UserResponse;
import com.riwi.PruebaSpringBoot.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/users")
@AllArgsConstructor
public class UserController {
    
    private final IUserService userService;

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAll(
    @RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "10") int size){
        return ResponseEntity.ok(this.userService.getAll(page - 1, size));

    }
}
