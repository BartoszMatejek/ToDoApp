package com.ToDoApp.validator.impl;

import com.ToDoApp.exception.DataValidationException;
import com.ToDoApp.util.Util;
import com.ToDoApp.validator.TaskListValidator;
import org.springframework.stereotype.Component;

@Component
public class TaskListValidatorImpl implements TaskListValidator {

    @Override
    public void validateTaskListName(String name) {
        if (Util.isNullOrBlank(name)) {
            throw new DataValidationException(
                    "Error when entering task list name",
                    "Task list name cannot be empty. Try again");
        }
    }
}