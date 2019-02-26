package com.ToDoApp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskCreateDTO {

    @JsonProperty(value = "description")
    private String description;
}
