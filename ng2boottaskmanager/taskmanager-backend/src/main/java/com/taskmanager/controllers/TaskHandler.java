package com.taskmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.taskmanager.converters.TaskConverters;
import com.taskmanager.dtos.TaskDto;
import com.taskmanager.exception.TaskCustomException;
import com.taskmanager.services.TaskService;

//@CrossOrigin(origins = "*"))
@RestController
public class TaskHandler {

	@Autowired
	TaskService taskService;
	@Autowired
	TaskConverters taskConverters;

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getTasks", method = RequestMethod.GET)
	public ResponseEntity<List<TaskDto>> getAllTasks() {

		List<TaskDto> taskDtos = new ArrayList<>();
		taskService.listAllTasks().forEach(
				task -> taskDtos.add(taskConverters.convertToDto(task)));

		return new ResponseEntity<List<TaskDto>>(taskDtos, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getTask/{id}", method = RequestMethod.GET)
	public ResponseEntity<TaskDto> getTask(@PathVariable("id") final String id) {

		TaskDto taskdto = taskConverters.convertToDto(taskService.getById(id));// (Integer.parseInt(number));

		return new ResponseEntity<TaskDto>(taskdto, HttpStatus.OK);
	}

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/updateTask/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<TaskDto> updateTask(
			@PathVariable("id") final String id, @RequestBody TaskDto taskDto) {

		TaskDto updatedTaskdto = taskConverters.convertToDto(taskService
				.updateTask(id, taskDto));
		return new ResponseEntity<TaskDto>(updatedTaskdto, HttpStatus.OK);
	}

    //Need to add handler for it
	@ExceptionHandler(TaskCustomException.class)
	public ResponseEntity<TaskCustomException> handleCustomException(
			TaskCustomException ex) {

		return new ResponseEntity<TaskCustomException>(ex,
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> handleAllException(Exception ex) {

		return new ResponseEntity<Exception>(ex, HttpStatus.FORBIDDEN);

	}

}
