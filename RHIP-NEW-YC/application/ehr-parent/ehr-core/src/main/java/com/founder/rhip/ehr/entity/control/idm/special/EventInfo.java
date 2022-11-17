package com.founder.rhip.ehr.entity.control.idm.special;

import com.founder.rhip.ehr.common.EHRConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "IDM_EVENT_INFO")
public class EventInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "STATUS_ID", columnDefinition = "NUMBER|状态表ID|11|", length = 11, nullable = false)
	private Long statusId;

	@Column(name = "EVENT_ID", columnDefinition = "NUMBER|记录日期|唯一事件id|", length = 11, nullable = false)
	private Long eventId;

	@Column(name = "is_delete", columnDefinition = "NUMBER|是否可用|1|", length = 1, nullable = true)
    private Integer isDelete = EHRConstants.DELETE_FLG_0;// 1表示可用 0 表示不可用
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the statusId
	 */
	public Long getStatusId() {
		return statusId;
	}

	/**
	 * @param statusId the statusId to set
	 */
	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	/**
	 * @return the eventId
	 */
	public Long getEventId() {
		return eventId;
	}

	/**
	 * @param eventId the eventId to set
	 */
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}
	
}