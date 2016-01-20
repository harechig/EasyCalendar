package com.easycalendar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the STATUSES database table.
 * 
 */
@Entity
@Table(name="STATUSES")
@NamedQuery(name="Status.findAll", query="SELECT s FROM Status s")
public class Status implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STATUS_ID")
	private long statusId;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	private String description;

	private String status;

	//bi-directional many-to-one association to Project
	@OneToMany(mappedBy="status")
	private List<Project> projects;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="status")
	private List<Task> tasks;

	public Status() {
	}

	public long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(long statusId) {
		this.statusId = statusId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Project> getProjects() {
		return this.projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Project addProject(Project project) {
		getProjects().add(project);
		project.setStatus(this);

		return project;
	}

	public Project removeProject(Project project) {
		getProjects().remove(project);
		project.setStatus(null);

		return project;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setStatus(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setStatus(null);

		return task;
	}

}