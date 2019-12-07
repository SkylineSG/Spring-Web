package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table (name = "users")
public class User {

    @Column (name="name")
    @NotNull
    private String userName;

    @Column (name = "id")
    @Id
    @GeneratedValue
    @NotNull
    private Long userId;

    @Column (name = "isBlocked")
    private boolean isBlocked;
}