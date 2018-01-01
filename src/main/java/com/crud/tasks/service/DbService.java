package com.crud.tasks.service;

import com.crud.tasks.domain.Item;
import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.ItemRepository;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NamedNativeQuery;
import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ItemRepository itemRepository;

    public List<Task>  getAllTask(){
        return taskRepository.findAll();
    }

    public Optional<Task> findById(Long taskId){
        return taskRepository.findById(taskId);
    }

    public Task save(final Task task){
        return taskRepository.save(task);
    }

    public void delete(final Task task) {
        taskRepository.delete(task);
    }

    public Item save(final Item item){
        return itemRepository.save(item);
    }

    public List<Tuple> retrieveTasksFromQuery(){
        return taskRepository.retrieveTasks();

    }
}
