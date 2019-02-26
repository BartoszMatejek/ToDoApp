package com.ToDoApp.service.impl;

import com.ToDoApp.dto.request.TaskListCreateDTO;
import com.ToDoApp.dto.response.ListDTO;
import com.ToDoApp.dto.response.SingleValueDTO;
import com.ToDoApp.dto.response.TaskListBasicDTO;
import com.ToDoApp.dto.response.TaskListExtendedDTO;
import com.ToDoApp.exception.InternalServerErrorException;
import com.ToDoApp.exception.ResourceNotFoundException;
import com.ToDoApp.mapper.TaskListBasicDTOMapper;
import com.ToDoApp.mapper.TaskListCreateDTOMapper;
import com.ToDoApp.mapper.TaskListExtendedDTOMapper;
import com.ToDoApp.model.TaskList;
import com.ToDoApp.model.User;
import com.ToDoApp.repository.TaskListRepository;
import com.ToDoApp.repository.UserRepository;
import com.ToDoApp.service.TaskListService;
import com.ToDoApp.service.entityHandler.TaskListEntityHandler;
import com.ToDoApp.validator.TaskListValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaskListServiceImpl implements TaskListService {

    private TaskListRepository taskListRepository;

    private UserRepository userRepository;

    private TaskListBasicDTOMapper taskListBasicDTOMapper;

    private TaskListExtendedDTOMapper taskListExtendedDTOMapper;

    private TaskListCreateDTOMapper taskListCreateDTOMapper;

    private TaskListValidator taskListValidator;

    private TaskListEntityHandler taskListEntityHandler;

    public TaskListServiceImpl(
            TaskListRepository taskListRepository,
            UserRepository userRepository,
            TaskListBasicDTOMapper taskListBasicDTOMapper,
            TaskListExtendedDTOMapper taskListExtendedDTOMapper,
            TaskListCreateDTOMapper taskListCreateDTOMapper,
            TaskListValidator taskListValidator,
            TaskListEntityHandler taskListEntityHandler) {
        this.taskListRepository = taskListRepository;
        this.userRepository = userRepository;
        this.taskListBasicDTOMapper = taskListBasicDTOMapper;
        this.taskListExtendedDTOMapper = taskListExtendedDTOMapper;
        this.taskListCreateDTOMapper = taskListCreateDTOMapper;
        this.taskListValidator = taskListValidator;
        this.taskListEntityHandler = taskListEntityHandler;
    }

    @Override
    public ListDTO<TaskListBasicDTO> getAllTaskLists(Integer userId) {
        try {
            List<TaskList> listOfTaskLists = taskListRepository.findByUserId(userId);
            ListDTO<TaskListBasicDTO> listDTO = new ListDTO<>(
                    taskListBasicDTOMapper.taskListsToTaskListBasicDTOs(listOfTaskLists));
            return listDTO;
        } catch (Exception e) {
            throw new InternalServerErrorException();
        }
    }

    @Override
    public void deleteList(Integer taskListId, Integer userId) {
        taskListEntityHandler.deleteList(taskListId, userId);
    }

    @Override
    public TaskListExtendedDTO getTaskList(Integer taskListId, Integer userId) {
        TaskList taskList;
        try {
            taskList = taskListRepository.findByIdAndUserId(taskListId, userId);
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
        if (taskList != null) {
            TaskListExtendedDTO taskListExtendedDTO = taskListExtendedDTOMapper.taskListToTaskListExtendedDTO(taskList);
            return taskListExtendedDTO;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    @Transactional
    public SingleValueDTO<Integer> createList(Integer userId, TaskListCreateDTO taskListCreateDTO) {
        TaskList taskList = taskListCreateDTOMapper.taskListCreateDTOToTaskList(taskListCreateDTO);
        taskList.setTaskListName(taskList.getTaskListName().trim());
        taskListValidator.validateTaskListName(taskList.getTaskListName());
        taskList.setUser(getUser(userId));
        try {
            TaskList savedTaskList = taskListRepository.save(taskList);
            return new SingleValueDTO<>(savedTaskList.getId());
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }

    private User getUser(Integer userId) {
        try {
            User user = userRepository.findUserById(userId);
            return user;
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }
    }
}