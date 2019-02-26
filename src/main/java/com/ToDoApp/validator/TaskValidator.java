package com.ToDoApp.validator;

import com.ToDoApp.dto.request.TaskCreateDTO;

public interface TaskValidator {

    void validateTaskCreation(TaskCreateDTO taskCreateDTO);
}
