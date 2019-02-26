package com.ToDoApp.service.getter.impl;

import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.service.getter.TaskListGetter;
import com.ToDoApp.model.TaskList;
import com.ToDoApp.repository.TaskListRepository;
import org.springframework.stereotype.Component;

@Component
public class TaskListGetterImpl implements TaskListGetter {

    private TaskListRepository taskListRepository;

    public TaskListGetterImpl(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    @Override
    public TaskList getTaskList(Integer taskListId, Integer userId) {
        try {
            return this.taskListRepository.findByIdAndUserId(taskListId, userId);
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }
}
