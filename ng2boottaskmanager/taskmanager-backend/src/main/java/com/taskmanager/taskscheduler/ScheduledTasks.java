package com.taskmanager.taskscheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.taskmanager.models.Enums;
import com.taskmanager.models.Task;
import com.taskmanager.services.TaskService;

@Component
public class ScheduledTasks {

	@Autowired
	private TaskService taskService;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
    private final int TIME_INTERVAL = 10000;

	@Scheduled(fixedRate = TIME_INTERVAL)
	public void performTask() {

		System.out.println("The time is now {} "+ dateFormat.format(new Date()));

		// Create and Save new Task
		createAndsSaveNewTask();
	}

	private void createAndsSaveNewTask() {

		Task task = getNewTask();

		taskService.saveOrUpdate(task);
		System.out.println("Tasl added------" + task.toString());
	}

	private Task getNewTask() {

		Date date = new Date();
		String dateInString = dateFormat.format(date);

		String TaskName = "SimpleTask" + dateInString;
		String Description = "Sample Desc" + dateInString;
		int randomPriority = ThreadLocalRandom.current().nextInt(0, 3);

		Task task = new Task(TaskName, Description, dateInString);

		task.setPriority(Enums.Priortiy.values()[randomPriority]);
		task.setTaskStatus(Enums.TaskStatus.NOT_STARTED);
		task.setLastUpdatedDate(dateInString);

		// convert date to calendar
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		// manipulate date
		c.add(Calendar.DATE, 3);
		// convert calendar to date
		Date currentDatePlusThree = c.getTime();

		task.setDueDate(dateFormat.format(currentDatePlusThree).split(" ")[0]);
		return task;
	}

	// @Scheduled(initialDelay = 1000, fixedRate = TIME_INTERVAL)
	public void performDelayedTask() {

		System.out.println("Delayed Regular task performed at "
				+ dateFormat.format(new Date()));

	}

	// @Scheduled(cron = "*/5 * * * * *")
	public void performTaskUsingCron() {

		System.out.println("Regular task performed using Cron at "
				+ dateFormat.format(new Date()));

	}
}
