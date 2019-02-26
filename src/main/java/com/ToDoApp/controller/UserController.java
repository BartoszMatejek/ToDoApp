package com.ToDoApp.controller;

import com.ToDoApp.dto.request.UserCreateDTO;
import com.ToDoApp.dto.response.SingleValueDTO;
import com.ToDoApp.service.TokenQueryService;
import com.ToDoApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends CommonController {

    private UserService userService;

    public UserController(TokenQueryService tokenQueryService, UserService userService) {
        super(tokenQueryService);
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<SingleValueDTO<Integer>> register(@RequestBody UserCreateDTO userCreateDTO) {
        SingleValueDTO singleValueDTO;
        singleValueDTO = userService.createUser(userCreateDTO);
        return new ResponseEntity<>(singleValueDTO, HttpStatus.OK);
    }
}
