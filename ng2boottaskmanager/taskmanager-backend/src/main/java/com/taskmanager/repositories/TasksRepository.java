package com.taskmanager.repositories;

import org.springframework.data.repository.CrudRepository;

import com.taskmanager.models.Task;


/**
 * Created by Rahul Kumar.
 */
public interface TasksRepository extends CrudRepository<Task, String> {
}
