package com.crud.tasks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@NamedNativeQuery(
        name = "Task.retrieveTasks",
        query = "select distinct t.id, t.name, t.description, t.data," +
                " i.quantity from task_crud.tasks t join task_crud.item i on t.id = i.task_id",
        resultClass = Task.class
)

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="tasks")
public class Task {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name="name")
        private String title;

        @Column(name="description")
        private String content;

        @Column(name="data")
        private LocalDate createData;

        @OneToMany(
                targetEntity = Item.class,
                mappedBy = "task",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY
        )
        private List<Item> items;
}
