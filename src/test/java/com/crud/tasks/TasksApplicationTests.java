package com.crud.tasks;

import com.crud.tasks.domain.Item;
import com.crud.tasks.domain.Task;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Tuple;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.now;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TasksApplicationTests {

    @Autowired
    private DbService service;

    @Test
	public void TaskShopping() {

	    //Given
/*
        List<Item> items = new ArrayList<>();
        Task task = new Task(null,"zakupy","jajka, masło, ser",now(),items);

        Item item1  = new Item (null ,new BigDecimal(2.50), 2, new BigDecimal(5.00), null );
        Item item2  = new Item (null,new BigDecimal(4.50), 4, new BigDecimal(18.00), null);
        Item item3  = new Item (null,new BigDecimal(1.50), 1, new BigDecimal(1.50), null);

        item1.setTask(task);
        item2.setTask(task);
        item3.setTask(task);

        service.save(task);
        service.save(item1);
        service.save(item2);
        service.save(item3);*/

        //When
        List<Tuple> retrieveTasksFromQuery = service.retrieveTasksFromQuery();


        //Then
        System.out.println(retrieveTasksFromQuery.size() +"");
/*
        for (Tuple task: retrieveTasksFromQuery){
            System.out.println(task.get(0));
        }*/








	}


}
