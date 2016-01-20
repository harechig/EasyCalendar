package com.easycalendar.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TASK_ATTACHMENTS database table.
 * 
 */
@Entity
@Table(name="TASK_ATTACHMENTS")
@NamedQuery(name="TaskAttachment.findAll", query="SELECT t FROM TaskAttachment t")
public class TaskAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TASK_ATTACHMENT_ID")
	private long taskAttachmentId;

	private String comments;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATION_DATE")
	private Date creationDate;

	private String filename;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE_DATE")
	private Date lastUpdateDate;

	@Column(name="PROOF_PATH")
	private String proofPath;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="TASK_ID")
	private Task task;

	public TaskAttachment() {
	}

	public long getTaskAttachmentId() {
		return this.taskAttachmentId;
	}

	public void setTaskAttachmentId(long taskAttachmentId) {
		this.taskAttachmentId = taskAttachmentId;
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

	public String getFilename() {
		return this.filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getProofPath() {
		return this.proofPath;
	}

	public void setProofPath(String proofPath) {
		this.proofPath = proofPath;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}