package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class TaskDto {

    private Long id;

    private String title;

    private String content;

    private LocalDate createData;

    private List<Item> items ;
}
