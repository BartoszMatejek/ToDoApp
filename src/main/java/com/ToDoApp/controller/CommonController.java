package com.ToDoApp.controller;

import com.ToDoApp.service.TokenQueryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {

    protected TokenQueryService tokenQueryService;

    public CommonController(TokenQueryService tokenQueryService) {
        this.tokenQueryService = tokenQueryService;
    }
}
