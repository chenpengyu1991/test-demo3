package com.founder.rhip.ehr.entity.management.mhm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "MHM_MOVE")
public class MhmMove implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）|11|", length = 11, nullable = false)
	private Long id;

    @Column(name = "STATUS_ID", columnDefinition = "NUMBER|状态表id|11|", length = 11, nullable = true)
    private Long statusId;

    @Column(name = "EVENT_ID", columnDefinition = "NUMBER|本系统唯一编码|11|", length = 11, nullable = true)
    private Long eventId;

	@Column(name = "MOVE_OUT_ORGAN", columnDefinition = "VARCHAR2|迁出机构|100|", length = 100, nullable = true)
	private String moveOutOrgan;

	@Column(name = "MOVE_OUT_USER", columnDefinition = "VARCHAR2|迁出人|50|", length = 50, nullable = true)
	private String moveOutUser;

	@Column(name = "MOVE_OUT_DT", columnDefinition = "DATE|迁出时间||", nullable = true)
	private Date moveOutDt;

	@Column(name = "MOVE_IN_ORGAN", columnDefinition = "VARCHAR2|迁入机构|100|", length = 100, nullable = true)
	private String moveInOrgan;

	@Column(name = "MOVE_IN_USER", columnDefinition = "VARCHAR2|迁入人|50|", length = 50, nullable = true)
	private String moveInUser;

	@Column(name = "MOVE_IN_DT", columnDefinition = "DATE|迁入时间||", nullable = true)
	private Date moveInDt;

    @Column(name = "MOVE_REASON", columnDefinition = "VARCHAR2|迁出原因|100|", length = 100, nullable = true)
    private String moveReason;

    @Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|400|", length = 400, nullable = true)
    private String comments;

    @Column(name = "FLAG", columnDefinition = "VARCHAR2|状态|2|", length = 2, nullable = true)
    private String flag;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getEventId() {
		return this.eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getMoveOutOrgan() {
		return this.moveOutOrgan;
	}

	public void setMoveOutOrgan(String moveOutOrgan) {
		this.moveOutOrgan = moveOutOrgan;
	}

	public String getMoveOutUser() {
		return this.moveOutUser;
	}

	public void setMoveOutUser(String moveOutUser) {
		this.moveOutUser = moveOutUser;
	}

	public Date getMoveOutDt() {
		return this.moveOutDt;
	}

	public void setMoveOutDt(Date moveOutDt) {
		this.moveOutDt = moveOutDt;
	}

	public String getMoveInOrgan() {
		return this.moveInOrgan;
	}

	public void setMoveInOrgan(String moveInOrgan) {
		this.moveInOrgan = moveInOrgan;
	}

	public String getMoveInUser() {
		return this.moveInUser;
	}

	public void setMoveInUser(String moveInUser) {
		this.moveInUser = moveInUser;
	}

	public Date getMoveInDt() {
		return this.moveInDt;
	}

	public void setMoveInDt(Date moveInDt) {
		this.moveInDt = moveInDt;
	}

    public String getMoveReason() {
        return moveReason;
    }

    public void setMoveReason(String moveReason) {
        this.moveReason = moveReason;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}