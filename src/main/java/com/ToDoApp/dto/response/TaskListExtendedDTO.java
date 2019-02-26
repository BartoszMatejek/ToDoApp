package com.ToDoApp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TaskListExtendedDTO extends TaskListBasicDTO {
    @JsonProperty("listOfTasks")
    private List<TaskDTO> listOfTasks;
}