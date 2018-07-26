package com.taskmanager.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskmanager.converters.TaskConverters;
import com.taskmanager.dtos.TaskDto;
import com.taskmanager.models.Enums;
import com.taskmanager.models.Task;
import com.taskmanager.repositories.TasksRepository;

/**
 * Created by Rahul Kumar.
 */
@Service
public class TaskServiceImpl implements TaskService {

	private TasksRepository tasksRepository;
	private TaskConverters taskConverters;

	@Autowired
	public TaskServiceImpl(TasksRepository tasksRepository,
			TaskConverters taskConverters) {
		this.tasksRepository = tasksRepository;
		this.taskConverters = taskConverters;
	}

	/*
	 * List All Tasks whose remind Me At date is not set or current date Return
	 * list on basis of Priority and Due date
	 */
	@Override
	public List<Task> listAllTasks() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date currentDate = new Date();
		List<Task> tasks = new ArrayList<>();

		tasksRepository.findAll().forEach(task -> {
			if (task.getRemindeMeAT() == null || task.getRemindeMeAT() == "") {
				tasks.add(task);
				return;
			}

			Date remindMeDate = null;
			try {
				remindMeDate = sdf.parse(task.getRemindeMeAT());
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("-----------" + task.getRemindeMeAT());
			if (remindMeDate.compareTo(currentDate) < 1) {
				tasks.add(task);
			}
		});
		if (tasks.isEmpty())
			return tasks;
		/*
		 * Sort the Tasks First On basis of priority Then On basis of DueDate
		 */
		tasks.sort(Comparator.comparing(Task::getPriority,
				(priority1, priority2) -> {
					if (priority1 == priority2) {
						return 0;
					}
					return priority1.compareTo(priority2) < 0 ? -1 : 1;
				}).thenComparing(Task::getDueDate, (date1, date2) -> {
			if (date1.equals(date2)) {
				return 0;
			}
			Date date11 = null;
			Date date22 = null;
			try {
				date11 = sdf.parse(date1);
				date22 = sdf.parse(date2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return date11.compareTo(date22) < 0 ? -1 : 1;
		}));

		return tasks;
	}

	@Override
	public Task getById(String id) {
		return tasksRepository.findById(id).orElse(null);
	}

	@Override
	public Task saveOrUpdate(Task product) {
		tasksRepository.save(product);
		return product;
	}

	@Override
	public void delete(String id) {
		tasksRepository.deleteById(id);

	}

	@Override
	public Task saveOrUpdateTask(TaskDto taskDto) {
		Task updatedTask = null;
		try {
			updatedTask = saveOrUpdate(taskConverters.convertToEntity(taskDto));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println("Saved Product Id: " + updatedTask.getId());
		return updatedTask;
	}

	/*
	 * Apply patch changes to Task Allowed changes are Title , Description,Due
	 * date,Remind me at,Priority and Status
	 */
	@Override
	public Task updateTask(String id, TaskDto taskDto) {
		Task task = tasksRepository.findById(id).orElse(null);
		if (task == null)
			return null;

		if (taskDto.getDescription() != null)
			task.setDescription(taskDto.getDescription());

		if (taskDto.getTitle() != null)
			task.setTitle(taskDto.getTitle());

		if (taskDto.getTaskStatus() != null) {
			task.setTaskStatus(Enums.TaskStatus.valueOf(taskDto.getTaskStatus()));
			if (Enums.TaskStatus.valueOf(taskDto.getTaskStatus()).equals(
					Enums.TaskStatus.FINISHED)) {
				task.setResolvedAt(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()));
			} else {
				task.setResolvedAt(null);
			}

		}

		if (taskDto.getPriority() != null)
			task.setPriority(Enums.Priortiy.valueOf(taskDto.getPriority()));

		if (taskDto.getDueDate() != null) {
			task.setDueDate(taskDto.getDueDate());
		}

		if (taskDto.getRemindeMeAT() != null) {
			task.setRemindeMeAT(taskDto.getRemindeMeAT());
		}
		// Update last updated time
		task.setLastUpdatedDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new Date()));

		tasksRepository.save(task);

		return task;
	}
}
