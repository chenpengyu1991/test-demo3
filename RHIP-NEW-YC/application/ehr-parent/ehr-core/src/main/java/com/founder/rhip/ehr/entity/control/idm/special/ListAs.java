package com.founder.rhip.ehr.entity.control.idm.special;

import com.founder.fasf.util.DateUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_AS")
public class ListAs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长id|11|", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|传染病唯一编码|11|", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "SPUTUM_DT", columnDefinition = "DATE|预约日期||", nullable = true)
	private Date sputumDt;

	@Column(name = "INSPECT_DT", columnDefinition = "DATE|送检日期||", nullable = true)
	private Date inspectDt;

	@Column(name = "SPUTUM_RESULT", columnDefinition = "VARCHAR2|痰检结果|2|", length = 2, nullable = true)
	private String sputumResult;

	@Column(name = "CREATE_UNIT", columnDefinition = "VARCHAR2|新增单位||", length = 100, nullable = true)
	private String createUnit;

	@Column(name = "CREATE_DT", columnDefinition = "DATE|新增时间||", nullable = true)
	private Date createDt;

	@Column(name = "CREATE_USER", columnDefinition = "VARCHAR2|新增人||", length = 50, nullable = true)
	private String createUser;

	@Column(name = "MODIFY_UNIT", columnDefinition = "VARCHAR2|修改单位||", length = 100, nullable = true)
	private String modifyUnit;

	@Column(name = "MODIFY_DT", columnDefinition = "DATE|修改时间||", nullable = true)
	private Date modifyDt;

	@Column(name = "MODIFY_USER", columnDefinition = "VARCHAR2|修改人||", length = 50, nullable = true)
	private String mofigyUser;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标识||", length = 1, nullable = true)
	private Integer isDelete;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
	private String flag;

    @Column(name = "DELAY_DAYS", columnDefinition = "NUMBER|延迟天数||", length = 5, nullable = true)
    private int delayDays;

    @Column(name = "MONTH_SEQ", columnDefinition = "VARCHAR2|类型||", length = 2, nullable = true)
    private String monthSeq;

    public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdmId() {
		return this.idmId;
	}

	public void setIdmId(Long idmId) {
		this.idmId = idmId;
	}

	public Date getSputumDt() {
		return this.sputumDt;
	}

	public void setSputumDt(Date sputumDt) {
		this.sputumDt = sputumDt;
	}

    public String getSputumDtStr() {
        String dateStr = "";
        if(null!=sputumDt){
            dateStr = DateUtil.toDateString(sputumDt, "yyyy/MM/dd");
        }
        return dateStr;
    }

	public Date getInspectDt() {
		return this.inspectDt;
	}

	public void setInspectDt(Date inspectDt) {
		this.inspectDt = inspectDt;
	}

	public String getSputumResult() {
		return this.sputumResult;
	}

	public void setSputumResult(String sputumResult) {
		this.sputumResult = sputumResult;
	}

	public String getCreateUnit() {
		return this.createUnit;
	}

	public void setCreateUnit(String createUnit) {
		this.createUnit = createUnit;
	}

	public Date getCreateDt() {
		return this.createDt;
	}

	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getModifyUnit() {
		return this.modifyUnit;
	}

	public void setModifyUnit(String modifyUnit) {
		this.modifyUnit = modifyUnit;
	}

	public Date getModifyDt() {
		return this.modifyDt;
	}

	public void setModifyDt(Date modifyDt) {
		this.modifyDt = modifyDt;
	}

	public String getMofigyUser() {
		return this.mofigyUser;
	}

	public void setMofigyUser(String mofigyUser) {
		this.mofigyUser = mofigyUser;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

    public int getDelayDays() {
        return delayDays;
    }

    public void setDelayDays(int delayDays) {
        this.delayDays = delayDays;
    }

    public String getMonthSeq() {
        return monthSeq;
    }

    public void setMonthSeq(String monthSeq) {
        this.monthSeq = monthSeq;
    }
}