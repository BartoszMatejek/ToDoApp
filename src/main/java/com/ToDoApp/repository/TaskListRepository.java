package com.ToDoApp.repository;

import com.ToDoApp.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Integer> {

    TaskList findByIdAndUserId(Integer taskListId, Integer userId);

    List<TaskList> findByUserId(Integer userId);

    void deleteTaskListByIdAndUserId(Integer taskListId, Integer userId);
}
