package com.taskmanager.services;

import java.util.List;

import com.taskmanager.dtos.TaskDto;
import com.taskmanager.models.Task;

/**
 * Created by Rahul Kumar.
 */
public interface TaskService {

    List<Task> listAllTasks();

    Task getById(String id);

    Task saveOrUpdate(Task product);

    void delete(String id);

    Task saveOrUpdateTask(TaskDto taskDto);

    Task updateTask(String id , TaskDto taskDto);

}
