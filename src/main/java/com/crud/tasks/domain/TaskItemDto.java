package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
/*
@SqlResultSetMapping(name="TaskItemResult", classes = {
        @ConstructorResult(targetClass = TaskItemDto.class,
                columns = {@ColumnResult(name="name")})
})*/
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class TaskItemDto {

    @Id
    private Long id;

    private String name;

    //private String content;

    //private LocalDate createData;

    private int quantity;
}
