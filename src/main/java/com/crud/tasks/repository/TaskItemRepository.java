package com.crud.tasks.repository;

import com.crud.tasks.domain.TaskItemDto;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

import java.util.ArrayList;
import java.util.List;

import static com.crud.tasks.domain.QItem.item;
import static com.crud.tasks.domain.QTask.task;


@Repository
public class TaskItemRepository {

    //@Autowired
    //private NamedParameterJdbcTemplate namedJdbcTemplate;

    @PersistenceContext
    private EntityManager em;


/*
    public List<TaskItemDto> getAllTasks() {

        String query = new DbUtils().loadSqlFileFromClasspath("db/testQuery.sql").get();

        List<TaskItemDto> messageReplyDtos = new ArrayList<>();
        //SqlParameterSource namedParameters = new MapSqlParameterSource("convId", conversationId);
        namedJdbcTemplate.query(query,  (resultSet -> {
            messageReplyDtos.add((TaskItemDto) resultSet);
        }));
        return messageReplyDtos;
    }*/


    @SuppressWarnings("unchecked")
    public List<TaskItemDto>  retrieveTasksItemDto(){

       String SearchQuery = "select distinct t.id, t.name, i.quantity from task_crud.tasks t join task_crud.item i" +
               " on t.id = i.task_id";

        return em.createNativeQuery(SearchQuery,TaskItemDto.class).getResultList();

    };

    @SuppressWarnings("unchecked")
    public List<TaskItemDto>  retrieveTasksItemDto2(){

        List<TaskItemDto>  listTaskItemDto = new ArrayList<>();
        JPAQuery query = new JPAQuery(em);

       final List<Tuple> myList =  query.from(item)
               .join(item.task)
               .list(item.task.id, item.task.title,item.quantity);

        for(Tuple taskDto2 : myList){
            listTaskItemDto.add(new TaskItemDto(taskDto2.get(item.task.id), taskDto2.get(item.task.title),
                    taskDto2.get(item.quantity)));
        }

        return listTaskItemDto;

    };

}
