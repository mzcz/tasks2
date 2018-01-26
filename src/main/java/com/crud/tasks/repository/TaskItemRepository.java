package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskItemDto;
import org.apache.commons.dbutils.DbUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedNativeQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.EntityManager;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

}
