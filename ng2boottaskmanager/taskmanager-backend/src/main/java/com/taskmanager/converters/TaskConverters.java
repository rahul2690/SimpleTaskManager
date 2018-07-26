package com.taskmanager.converters;

import java.text.ParseException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.taskmanager.dtos.TaskDto;
import com.taskmanager.models.Enums;
import com.taskmanager.models.Task;

@Component
public class TaskConverters {

	private static ModelMapper modelMapper = new ModelMapper();

	public TaskDto convertToDto(Task task) {
		TaskDto taskDto = modelMapper.map(task, TaskDto.class);
		taskDto.setPriority(task.getPriority().toString());
		taskDto.setTaskStatus(task.getTaskStatus().toString());

	    return taskDto;
	}

	public Task convertToEntity(TaskDto taskDto) throws ParseException {
		Task task = modelMapper.map(taskDto, Task.class);
		task.setPriority(Enums.Priortiy.valueOf(taskDto.getPriority()));
		task.setTaskStatus(Enums.TaskStatus.valueOf(taskDto.getTaskStatus()));

	    return task;
	}
}
