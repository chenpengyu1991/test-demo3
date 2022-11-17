package com.founder.rhip.ehr.entity.control.idm.special;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "IDM_LIST_SC")
public class ListSc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, nullable = false)
	private Long id;

	@Column(name = "IDM_ID", columnDefinition = "NUMBER|本系统唯一编码||", length = 11, nullable = false)
	private Long idmId;

	@Column(name = "FOLLOWUP_NUM", columnDefinition = "VARCHAR2|随访次数||", length = 20, nullable = true)
	private String followupNum;

	@Column(name = "FOLLOWUP_DT", columnDefinition = "DATE|随访日期||", nullable = true)
	private Date followupDt;

	@Column(name = "SUPERVISOR_CONTENT", columnDefinition = "VARCHAR2|督导内容||", length = 200, nullable = true)
	private String supervisorContent;

	@Column(name = "SUPERVISOR_OTHER", columnDefinition = "VARCHAR2|督导内容－其他||", length = 200, nullable = true)
	private String supervisorOther;

	@Column(name = "MIND_GOODS", columnDefinition = "VARCHAR2|照料用品||", length = 200, nullable = true)
	private String mindGoods;

	@Column(name = "ASSISTANCE", columnDefinition = "VARCHAR2|帮助||", length = 200, nullable = true)
	private String assistance;

	@Column(name = "SATISFACTION", columnDefinition = "VARCHAR2|满意度||", length = 2, nullable = true)
	private String satisfaction;

	@Column(name = "REASON_CONTENT", columnDefinition = "VARCHAR2|理由||", length = 800, nullable = true)
	private String reasonContent;

	@Column(name = "SUGGESTION", columnDefinition = "VARCHAR2|评价和改善意见||", length = 800, nullable = true)
	private String suggestion;

	@Column(name = "CHECK_USER", columnDefinition = "VARCHAR2|检查人||", length = 50, nullable = true)
	private String checkUser;

	@Column(name = "DEPENDENT", columnDefinition = "VARCHAR2|家属||", length = 50, nullable = true)
	private String dependent;

	@Column(name = "SUPERVISOR_DT", columnDefinition = "DATE|日期||", nullable = true)
	private Date supervisorDt;

	@Column(name = "FLAG", columnDefinition = "VARCHAR2|类型||", length = 20, nullable = true)
	private String flag;

    @Column(name = "NAME", columnDefinition = "VARCHAR2|姓名|100|", length = 100, nullable = true)
    private String name;

    @Column(name = "GENDER", columnDefinition = "VARCHAR2|性别|1|", length = 1, nullable = true)
    private String gender;

    @Column(name = "AGE", columnDefinition = "VARCHAR2|年龄|20|", length = 20, nullable = true)
    private String age;

    @Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|电话|20|", length = 20, nullable = true)
    private String phoneNumber;

    @Column(name = "PATOWN_SHIP", columnDefinition = "VARCHAR2|居住地－县|100|", length = 100, nullable = true)
    private String patownShip;

    @Column(name = "PASTREET", columnDefinition = "VARCHAR2|居住地－村|100|", length = 100, nullable = true)
    private String pastreet;

    @Column(name = "PAHOUSE_NUMBER", columnDefinition = "VARCHAR2|居住地－地址|100|", length = 100, nullable = true)
    private String pahouseNumber;

    @Column(name = "FOLLOWUP_DT_STR", columnDefinition = "VARCHAR2|随访日期的文本输入内容|200|", length = 200, nullable = true)
    private String followupDtStr;

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

	public String getFollowupNum() {
		return this.followupNum;
	}

	public void setFollowupNum(String followupNum) {
		this.followupNum = followupNum;
	}

	public Date getFollowupDt() {
		return this.followupDt;
	}

	public void setFollowupDt(Date followupDt) {
		this.followupDt = followupDt;
	}

	public String getSupervisorContent() {
		return this.supervisorContent;
	}

	public void setSupervisorContent(String supervisorContent) {
		this.supervisorContent = supervisorContent;
	}

	public String getSupervisorOther() {
		return this.supervisorOther;
	}

	public void setSupervisorOther(String supervisorOther) {
		this.supervisorOther = supervisorOther;
	}

	public String getMindGoods() {
		return this.mindGoods;
	}

	public void setMindGoods(String mindGoods) {
		this.mindGoods = mindGoods;
	}

	public String getAssistance() {
		return this.assistance;
	}

	public void setAssistance(String assistance) {
		this.assistance = assistance;
	}

	public String getSatisfaction() {
		return this.satisfaction;
	}

	public void setSatisfaction(String satisfaction) {
		this.satisfaction = satisfaction;
	}

	public String getReasonContent() {
		return this.reasonContent;
	}

	public void setReasonContent(String reasonContent) {
		this.reasonContent = reasonContent;
	}

	public String getSuggestion() {
		return this.suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getCheckUser() {
		return this.checkUser;
	}

	public void setCheckUser(String checkUser) {
		this.checkUser = checkUser;
	}

	public String getDependent() {
		return this.dependent;
	}

	public void setDependent(String dependent) {
		this.dependent = dependent;
	}

	public Date getSupervisorDt() {
		return this.supervisorDt;
	}

	public void setSupervisorDt(Date supervisorDt) {
		this.supervisorDt = supervisorDt;
	}

	public String getFlag() {
		return this.flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPatownShip() {
        return patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public String getPastreet() {
        return pastreet;
    }

    public void setPastreet(String pastreet) {
        this.pastreet = pastreet;
    }

    public String getPahouseNumber() {
        return pahouseNumber;
    }

    public void setPahouseNumber(String pahouseNumber) {
        this.pahouseNumber = pahouseNumber;
    }

    public String getFollowupDtStr() {
        return followupDtStr;
    }

    public void setFollowupDtStr(String followupDtStr) {
        this.followupDtStr = followupDtStr;
    }
}