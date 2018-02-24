package com.crud.tasks;

import com.crud.tasks.domain.Item;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskItemDto;
import com.crud.tasks.repository.TaskItemRepository;
import com.crud.tasks.service.DbService;
import com.mysema.query.Tuple;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksApplicationTests {

    @Autowired
    private DbService service;

    @Autowired
    private TaskItemRepository taskItemRepository;


    @Test
    public void taskItemRepositoryTest() {

        //Given

        //When
        List<TaskItemDto> TaskItemDtos =  taskItemRepository.retrieveTasksItemDto();

        for(TaskItemDto taskDto : TaskItemDtos){
            System.out.println(taskDto.getId() + " " + taskDto.getName() + " " + taskDto.getQuantity());
        }



    }

    @Test
    public void taskItemRepositoryTest2() {

        //Given

        //When
        List<TaskItemDto> TaskItemDtos =  taskItemRepository.retrieveTasksItemDto2();

        for(TaskItemDto taskDto : TaskItemDtos){
            System.out.println("Moje Dane " + taskDto.getId() + " " + taskDto.getName() + " " + taskDto.getQuantity());
        }


    }



}
