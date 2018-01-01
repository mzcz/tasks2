package com.crud.tasks.controller;

import com.crud.tasks.domain.Item;
import com.crud.tasks.domain.ItemDto;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

        @RequestMapping(method = RequestMethod.GET, value = "getTasks")
         public List<TaskDto> getTasks(){
            return taskMapper.mapToTaskDtoList(service.getAllTask());
        }
        @RequestMapping(method = RequestMethod.GET, value = "getTask")
        public TaskDto getTask(@RequestParam Long taskId) throws TaskNotFoundException {
            return taskMapper.mapToTaskDto(service.findById(taskId).orElseThrow(TaskNotFoundException::new));
        }

        @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask")
        public void deleteTask(@RequestParam Long taskId) throws TaskNotFoundException{
            service.delete(service.findById(taskId).orElseThrow(TaskNotFoundException::new));
        };

        @RequestMapping(method = RequestMethod.PUT, value = "updateTask")
        public TaskDto updateTask(@RequestBody TaskDto taskDto){
          return taskMapper.mapToTaskDto(service.save(taskMapper.mapToTask(taskDto)));
        }

        @RequestMapping(method = RequestMethod.POST, value = "createTask", consumes = APPLICATION_JSON_VALUE)
        public void createTask(@RequestBody Task taskDto){
            service.save(taskDto);

            for (Item item1 :taskDto.getItems() ){
                    item1.setTask(taskDto);
                    service.save(item1);
            }


        };
}
