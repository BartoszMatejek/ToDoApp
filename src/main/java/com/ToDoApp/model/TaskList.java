package com.ToDoApp.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "user")
@EqualsAndHashCode(exclude = "user")
public class TaskList {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_list_seq_generator")
    @SequenceGenerator(
            name = "task_list_seq_generator",
            sequenceName = "task_list_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @NotBlank
    @Column(name = "task_list_name")
    private String taskListName;

    @OneToMany(mappedBy = "taskList", cascade = CascadeType.ALL)
    private List<Task> listOfTasks;
}