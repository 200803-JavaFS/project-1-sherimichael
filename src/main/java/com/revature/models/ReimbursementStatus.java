package com.revature.models;


import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reimb_status",  schema = "project1")
public class ReimbursementStatus implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id", unique = true, nullable = false)
	private int statusId;
	
	@Column(name="status", nullable=false)
	private String status;
	
	public ReimbursementStatus() {
		super();
	}

	public ReimbursementStatus(int statusId, String status, List<Reimbursement> r) {
		super();
		this.statusId = statusId;
		this.status = status;
	}

	public ReimbursementStatus(String status, List<Reimbursement> r) {
		super();
		this.status = status;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusId != other.statusId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ReimbursementStatus [statusId=" + statusId + ", status=" + status + "]";
	}

}
