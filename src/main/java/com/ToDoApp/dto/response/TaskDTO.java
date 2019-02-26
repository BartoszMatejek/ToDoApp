package com.ToDoApp.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("description")
    private String description;
}
