package com.taskmanager.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Task implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	private String title;
	private String description;

	private Enums.Priortiy priority;
	private Enums.TaskStatus taskStatus;

	private String createdDate;
	private String lastUpdatedDate;
	private String resolvedAt;
	private String dueDate;
	private String remindeMeAT;

	public Task() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Task(String title, String description, String createdDate) {
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
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

	public Enums.Priortiy getPriority() {
		return priority;
	}

	public void setPriority(Enums.Priortiy priority) {
		this.priority = priority;
	}

	public Enums.TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Enums.TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getCreatedDate() {
		return createdDate;
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

	public String getRemindeMeAT() {
		return remindeMeAT;
	}

	public void setRemindeMeAT(String remindeMeAT) {
		this.remindeMeAT = remindeMeAT;
	}

	public String toString() {
		return String.format(
				"id : %s , title : %s , description : %s , created date : %s",
				id, title, description, createdDate);
	}
}
