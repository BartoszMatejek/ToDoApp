package com.ToDoApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "user", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_seq_generator")
    @SequenceGenerator(
            name = "user_seq_generator",
            sequenceName = "user_id_seq",
            allocationSize = 1
    )
    private Integer id;

    @Column(name = "login", unique = true)
    @Size(max = 72)
    @NotBlank
    private String login;

    @Column(name = "password_hash")
    @NotBlank
    @JsonProperty("password")
    private String passwordHash;

    @OneToMany(mappedBy = "user")
    private List<TaskList> taskLists;
}
