package com.ToDoApp.service;

import com.ToDoApp.dto.request.UserCreateDTO;
import com.ToDoApp.dto.response.SingleValueDTO;

public interface UserService {

    SingleValueDTO<Integer> createUser(UserCreateDTO userCreateDTO);
}
