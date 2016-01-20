package com.easycalendar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TASKS database table.
 * 
 */
@Entity
@Table(name="TASKS")
@NamedQuery(name="Task.findAll", query="SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TASK_ID")
	private long taskId;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_FINSIH_DATE")
	private Date actualFinsihDate;

	@Column(name="ACTUAL_HOURS")
	private BigDecimal actualHours;

	@Temporal(TemporalType.DATE)
	@Column(name="ACTUAL_START_DATE")
	private Date actualStartDate;

	private String comments;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	@Temporal(TemporalType.DATE)
	@Column(name="DUE_DATE")
	private Date dueDate;

	@Column(name="ESTIMATED_HOURS")
	private BigDecimal estimatedHours;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="PERCENTAGE_COMPLETE")
	private BigDecimal percentageComplete;

	@Column(name="PREDECESSOR_TASK_ID")
	private BigDecimal predecessorTaskId;

	private BigDecimal priority;

	@Column(name="REQUIRES_PROOF")
	private BigDecimal requiresProof;

	@Column(name="TASK_NAME")
	private String taskName;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="PROJECT_ID")
	private Project project;

	//bi-directional many-to-one association to Status
	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private Status status;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_OWNER_ID")
	private User user;

	//bi-directional many-to-one association to TaskAttachment
	@OneToMany(mappedBy="task")
	private List<TaskAttachment> taskAttachments;

	public Task() {
	}

	public long getTaskId() {
		return this.taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public Date getActualFinsihDate() {
		return this.actualFinsihDate;
	}

	public void setActualFinsihDate(Date actualFinsihDate) {
		this.actualFinsihDate = actualFinsihDate;
	}

	public BigDecimal getActualHours() {
		return this.actualHours;
	}

	public void setActualHours(BigDecimal actualHours) {
		this.actualHours = actualHours;
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

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getEstimatedHours() {
		return this.estimatedHours;
	}

	public void setEstimatedHours(BigDecimal estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public BigDecimal getPercentageComplete() {
		return this.percentageComplete;
	}

	public void setPercentageComplete(BigDecimal percentageComplete) {
		this.percentageComplete = percentageComplete;
	}

	public BigDecimal getPredecessorTaskId() {
		return this.predecessorTaskId;
	}

	public void setPredecessorTaskId(BigDecimal predecessorTaskId) {
		this.predecessorTaskId = predecessorTaskId;
	}

	public BigDecimal getPriority() {
		return this.priority;
	}

	public void setPriority(BigDecimal priority) {
		this.priority = priority;
	}

	public BigDecimal getRequiresProof() {
		return this.requiresProof;
	}

	public void setRequiresProof(BigDecimal requiresProof) {
		this.requiresProof = requiresProof;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
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

	public List<TaskAttachment> getTaskAttachments() {
		return this.taskAttachments;
	}

	public void setTaskAttachments(List<TaskAttachment> taskAttachments) {
		this.taskAttachments = taskAttachments;
	}

	public TaskAttachment addTaskAttachment(TaskAttachment taskAttachment) {
		getTaskAttachments().add(taskAttachment);
		taskAttachment.setTask(this);

		return taskAttachment;
	}

	public TaskAttachment removeTaskAttachment(TaskAttachment taskAttachment) {
		getTaskAttachments().remove(taskAttachment);
		taskAttachment.setTask(null);

		return taskAttachment;
	}

}