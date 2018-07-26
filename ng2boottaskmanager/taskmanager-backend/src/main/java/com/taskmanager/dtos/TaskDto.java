package com.taskmanager.dtos;

public class TaskDto {

	private String id;
	private String title;
	private String description;

	private String priority;
	private String taskStatus;

	private String createdDate;
	private String lastUpdatedDate;
	private String resolvedAt;

	private String dueDate;
	private String remindeMeAT;

	public TaskDto() {

	}

	public TaskDto(String title, String description, String createdDate) {
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRemindeMeAT() {
		return remindeMeAT;
	}

	public void setRemindeMeAT(String remindeMeAT) {
		this.remindeMeAT = remindeMeAT;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getResolvedAt() {
		return resolvedAt;
	}

	public void setResolvedAt(String resolvedAt) {
		this.resolvedAt = resolvedAt;
	}

	public String toString() {
		return String.format(
				"id : %s , title : %s , description : %s , created date : %s",
				id, title, description, createdDate);
	}

}
