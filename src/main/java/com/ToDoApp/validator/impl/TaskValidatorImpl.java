package com.ToDoApp.validator.impl;

import com.ToDoApp.dto.request.TaskCreateDTO;
import com.ToDoApp.exception.DataValidationException;
import com.ToDoApp.util.Util;
import com.ToDoApp.validator.TaskValidator;
import org.springframework.stereotype.Component;

@Component
public class TaskValidatorImpl implements TaskValidator {

    @Override
    public void validateTaskCreation(TaskCreateDTO taskCreateDTO) {
        if (taskCreateDTO != null) {
            if (Util.isNullOrBlank(taskCreateDTO.getDescription())) {
                throw new DataValidationException(
                        "Error when entering task description by user",
                        "Task's description cannot be empty. Try again");
            }
        } else {
            throw new DataValidationException(
                    "Error when validating task description",
                    "Data for task creation is empty");
        }
    }
}