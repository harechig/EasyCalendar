package com.easycalendar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the PROJECTS database table.
 * 
 */
@Entity
@Table(name="PROJECTS")
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PROJECT_ID")
	private long projectId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_FINSIH_DATE")
	private Date actualFinsihDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_START_DATE")
	private Date actualStartDate;

	private String comments;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	private String description;

	@Temporal(TemporalType.DATE)
	@Column(name="ESTIMATED_FINSIH_DATE")
	private Date estimatedFinsihDate;

	@Temporal(TemporalType.DATE)
	@Column(name="ESTIMATED_START_DATE")
	private Date estimatedStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="CLIENT_ID")
	private Client client;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_OWNER_ID")
	private User user;

	//bi-directional many-to-one association to Task
	@OneToMany(mappedBy="project")
	private List<Task> tasks;

	public Project() {
	}

	public long getProjectId() {
		return this.projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public Date getActualFinsihDate() {
		return this.actualFinsihDate;
	}

	public void setActualFinsihDate(Date actualFinsihDate) {
		this.actualFinsihDate = actualFinsihDate;
	}

	public Date getActualStartDate() {
		return this.actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

	public Date getEstimatedFinsihDate() {
		return this.estimatedFinsihDate;
	}

	public void setEstimatedFinsihDate(Date estimatedFinsihDate) {
		this.estimatedFinsihDate = estimatedFinsihDate;
	}

	public Date getEstimatedStartDate() {
		return this.estimatedStartDate;
	}

	public void setEstimatedStartDate(Date estimatedStartDate) {
		this.estimatedStartDate = estimatedStartDate;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Task addTask(Task task) {
		getTasks().add(task);
		task.setProject(this);

		return task;
	}

	public Task removeTask(Task task) {
		getTasks().remove(task);
		task.setProject(null);

		return task;
	}

}