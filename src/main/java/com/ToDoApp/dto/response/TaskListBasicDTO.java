package com.ToDoApp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskListBasicDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("taskListName")
    private String taskListName;
}
