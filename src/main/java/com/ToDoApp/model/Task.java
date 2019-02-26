package com.ToDoApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "taskList")
@EqualsAndHashCode(exclude = "taskList")
public class Task {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence")
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "list_id")
    @NotNull
    private TaskList taskList;

    @Column(name = "description")
    @NotBlank
    @Size(max = 255, min = 1)
    private String description;
}
