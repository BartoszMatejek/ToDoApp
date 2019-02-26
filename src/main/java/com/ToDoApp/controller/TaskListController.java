package com.ToDoApp.controller;

import com.ToDoApp.dto.request.TaskCreateDTO;
import com.ToDoApp.dto.request.TaskListCreateDTO;
import com.ToDoApp.dto.response.ListDTO;
import com.ToDoApp.dto.response.SingleValueDTO;
import com.ToDoApp.dto.response.TaskListBasicDTO;
import com.ToDoApp.dto.response.TaskListExtendedDTO;
import com.ToDoApp.service.TaskListService;
import com.ToDoApp.service.TaskService;
import com.ToDoApp.service.TokenQueryService;
import com.ToDoApp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/list")
public class TaskListController extends CommonController {

    private TaskListService taskListService;

    private TaskService taskService;

    private UserService userService;

    public TaskListController(
            TokenQueryService tokenQueryService,
            TaskListService taskListService,
            TaskService taskService,
            UserService userService) {
        super(tokenQueryService);
        this.taskListService = taskListService;
        this.taskService = taskService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<ListDTO<TaskListBasicDTO>> getAllLists(HttpServletRequest request) {
        Integer userId = tokenQueryService.getUserId(request);
        ListDTO<TaskListBasicDTO> taskLists = taskListService.getAllTaskLists(userId);
        return new ResponseEntity<>(taskLists, HttpStatus.OK);
    }

    @GetMapping("/{task_list_id}")
    public ResponseEntity<TaskListExtendedDTO> getList(
            @PathVariable("task_list_id") Integer taskListId, HttpServletRequest request) {
        Integer userId = tokenQueryService.getUserId(request);
        TaskListExtendedDTO taskListExtendedDTO = taskListService.getTaskList(taskListId, userId);
        return new ResponseEntity<>(taskListExtendedDTO, HttpStatus.OK);
    }

    @PostMapping("/{task_list_id}/task")
    public ResponseEntity<SingleValueDTO<Integer>> createTask(
            @PathVariable(value = "task_list_id", required = true) Integer taskListId,
            @RequestBody TaskCreateDTO taskCreateDTO, HttpServletRequest request) {
        Integer userId = tokenQueryService.getUserId(request);
        SingleValueDTO<Integer> singleValueDTO = taskService.createTask(userId, taskListId, taskCreateDTO);
        return new ResponseEntity<>(singleValueDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{task_list_id}/task/{task_id}")
    public ResponseEntity<?> deleteTask(
            @PathVariable(value = "task_list_id") Integer taskListId,
            @PathVariable("task_id") Integer taskId,
            HttpServletRequest request) {
        Integer userId = tokenQueryService.getUserId(request);
        taskService.deleteTask(userId, taskListId, taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SingleValueDTO<Integer>> createList(
            @RequestBody TaskListCreateDTO taskListCreateDTO, HttpServletRequest request) {
        Integer userId = tokenQueryService.getUserId(request);
        SingleValueDTO<Integer> singleValueDTO = taskListService.createList(userId, taskListCreateDTO);
        return new ResponseEntity<>(singleValueDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{task_list_id}")
    public ResponseEntity<?> deleteTaskList(
            @PathVariable(value = "task_list_id") Integer taskListId, HttpServletRequest request) {
        Integer userId = tokenQueryService.getUserId(request);
        taskListService.deleteList(taskListId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
