package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MHM_EVENT_INFO")
public class MhmEventInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|ID|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "STATUS_ID", columnDefinition = "NUMBER|状态表id|11|", length = 11, nullable = false)
	private Long statusId;

	@Column(name = "EVENT_TYPE", columnDefinition = "NUMBER|唯一事件类型|11|", length = 11, nullable = false)
	private Integer eventType;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除状态（0正常，1删除）|1|0", length = 1, nullable = false)
	private Integer isDelete;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatusId() {
		return this.statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Integer getEventType() {
		return this.eventType;
	}

	public void setEventType(Integer eventType) {
		this.eventType = eventType;
	}

	/**
	 * @return the isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}