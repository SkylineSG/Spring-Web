package com.crud.tasks.domain;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


//@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrelloBoardDto {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
