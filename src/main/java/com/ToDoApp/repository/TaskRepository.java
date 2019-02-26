package com.ToDoApp.repository;

import com.ToDoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

    void deleteByIdAndTaskListIdAndTaskListUserId(Integer taskId, Integer taskListId, Integer userId);
}
