package com.founder.rhip.ehr.entity.sr;

import com.founder.fasf.util.StringUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SR_SCIENTIFIC_RESEARCH")
public class SrScientificResearch implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|自增长ID|11|", length = 11, nullable = true)
	private Long id;

	@Column(name = "SR_TYPE", columnDefinition = "VARCHAR2|科研著作类型|2|", length = 2, nullable = true)
	private String srType;

	@Column(name = "BELONG_IDCARD", columnDefinition = "VARCHAR2|归属身份证号|4000|", length = 4000, nullable = true)
	private String belongIdcard;

	@Column(name = "BELONG_NAME", columnDefinition = "VARCHAR2|归属姓名|4000|", length = 4000, nullable = true)
	private String belongName;

	@Column(name = "BELONG_ORGAN_CODE", columnDefinition = "VARCHAR2|归属单位（站）|50|", length = 50, nullable = true)
	private String belongOrganCode;

	@Column(name = "SERIAL_NUMBER", columnDefinition = "VARCHAR2|序号|30|", length = 30, nullable = true)
	private String serialNumber;

	@Column(name = "YEAR", columnDefinition = "CHAR|年份|4|", length = 4, nullable = true)
	private String year;

	@Column(name = "PROJECT_NO", columnDefinition = "VARCHAR2|项目编号|30|", length = 30, nullable = true)
	private String projectNo;

    @Column(name = "PLAN_CATEGORY", columnDefinition = "VARCHAR2|计划性质(级别)|2|", length = 2, nullable = true)
    private String planCategory;

	@Column(name = "PLAN_TYPE", columnDefinition = "VARCHAR2|计划性质|2|", length = 2, nullable = true)
	private String planType;

	@Column(name = "PROJECT_NAME", columnDefinition = "VARCHAR2|项目名称|30|", length = 30, nullable = true)
	private String projectName;

	@Column(name = "BEAR_UNIT", columnDefinition = "VARCHAR2|承担单位|400|", length = 400, nullable = true)
	private String bearUnit;

	@Column(name = "DEPARTMENT", columnDefinition = "VARCHAR2|科室|400|", length = 400, nullable = true)
	private String department;

	@Column(name = "PERSON_IN_CHARGE", columnDefinition = "VARCHAR2|课题负责人|800|", length = 800, nullable = true)
	private String personInCharge;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR2|联系电话|200|", length = 200, nullable = true)
	private String phoneNumber;

	@Column(name = "FINISHED_PERSON", columnDefinition = "VARCHAR2|课题完成人|800|", length = 800, nullable = true)
	private String finishedPerson;

	@Column(name = "COST", columnDefinition = "VARCHAR2|经费|30|", length = 30, nullable = true)
	private String cost;

	@Column(name = "FINISHED_DATE", columnDefinition = "DATE|完成时间||", nullable = true)
	private Date finishedDate;

    @Column(name = "RESULTS", columnDefinition = "VARCHAR2|结果|10|", length = 10, nullable = true)
	private String results;

	@Column(name = "FUNTURE", columnDefinition = "VARCHAR2|今后意向|2|", length = 2, nullable = true)
	private String funture;

	@Column(name = "ACHIEVEMENT_NO", columnDefinition = "VARCHAR2|成果文号|30|", length = 30, nullable = true)
	private String achievementNo;

    @Column(name = "AWARD_CATEGORY", columnDefinition = "VARCHAR2|获奖名称（级别）|2|", length = 2, nullable = true)
    private String awardCategory;

	@Column(name = "AWARD_NAME", columnDefinition = "VARCHAR2|获奖名称|2|", length = 2, nullable = true)
	private String awardName;

	@Column(name = "GRADE", columnDefinition = "VARCHAR2|等级|2|", length = 2, nullable = true)
	private String grade;

	@Column(name = "PERIODICAL_NAME", columnDefinition = "VARCHAR2|期刊名称|200|", length = 200, nullable = true)
	private String periodicalName;

	@Column(name = "TITLE", columnDefinition = "VARCHAR2|题目|200|", length = 200, nullable = true)
	private String title;

	@Column(name = "STAGE", columnDefinition = "VARCHAR2|期次|30|", length = 30, nullable = true)
	private String stage;

	@Column(name = "CORRESPONDING_AUTHOR", columnDefinition = "VARCHAR2|通讯作者|800|", length = 800, nullable = true)
	private String correspondingAuthor;

	@Column(name = "FIRST_AUTHOR", columnDefinition = "VARCHAR2|第一作者|800|", length = 800, nullable = true)
	private String firstAuthor;

	@Column(name = "SECORD_AUTHOR", columnDefinition = "VARCHAR2|第二作者|800|", length = 800, nullable = true)
	private String secordAuthor;

	@Column(name = "PRESS", columnDefinition = "VARCHAR2|出版社|100|", length = 100, nullable = true)
	private String press;

	@Column(name = "ISBN", columnDefinition = "VARCHAR2|书号（ISBN）|30|", length = 30, nullable = true)
	private String isbn;

	@Column(name = "CHIEF_EDITOR", columnDefinition = "VARCHAR2|主编|800|", length = 800, nullable = true)
	private String chiefEditor;

	@Column(name = "SUBEDITOR", columnDefinition = "VARCHAR2|副主编|800|", length = 800, nullable = true)
	private String subeditor;

	@Column(name = "PARTICIPANT", columnDefinition = "VARCHAR2|参编|800|", length = 800, nullable = true)
	private String participant;

	@Column(name = "TYPE", columnDefinition = "CHAR|分类|2|", length = 2, nullable = true)
	private String type;

	@Column(name = "PATENT_NO", columnDefinition = "VARCHAR2|专利号|30|", length = 30, nullable = true)
	private String patentNo;

	@Column(name = "PATENT_NAME", columnDefinition = "VARCHAR2|专利名称|800|", length = 800, nullable = true)
	private String patentName;

	@Column(name = "APPLICANT", columnDefinition = "VARCHAR2|申请人|800|", length = 800, nullable = true)
	private String applicant;

	@Column(name = "OTHER_AUTHOR", columnDefinition = "VARCHAR2|其他著作人|4000|", length = 4000, nullable = true)
	private String otherAuthor;

	@Column(name = "OTHER_EDITOR", columnDefinition = "VARCHAR2|其他编辑|4000|", length = 4000, nullable = true)
	private String otherEditor;

	@Column(name = "COMMENTS", columnDefinition = "VARCHAR2|备注|400|", length = 400, nullable = true)
	private String comments;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标示(0正常，-1删除)||", nullable = true)
	private Integer isDelete;

	@Column(name = "CREATE_ORGAN_CODE", columnDefinition = "VARCHAR2|创建机构编码|50|", length = 50, nullable = true)
	private String createOrganCode;

	@Column(name = "CREATE_USER_CODE", columnDefinition = "VARCHAR2|创建操作人|100|", length = 100, nullable = true)
	private String createUserCode;

	@Column(name = "CREATE_DATE", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createDate;

	@Column(name = "UPDATE_ORGAN_CODE", columnDefinition = "VARCHAR2|更新机构编码|50|", length = 50, nullable = true)
	private String updateOrganCode;

	@Column(name = "UPDATE_USER_CODE", columnDefinition = "VARCHAR2|更新操作人|100|", length = 100, nullable = true)
	private String updateUserCode;

	@Column(name = "UPDATE_DATE", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateDate;

    @Column(name = "BELONG_GB_CODE", columnDefinition = "VARCHAR2|归属镇|50|", length = 50, nullable = true)
    private String belongGbCode;

    @Column(name = "BELONG_CENTER_CODE", columnDefinition = "VARCHAR2|归属中心|50|", length = 50, nullable = true)
    private String belongCenterCode;

    @Column(name = "AWARDS_TYPE", columnDefinition = "VARCHAR2|获奖类型|50|", length = 50, nullable = true)
    private String awardsType;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSrType() {
		return this.srType;
	}

	public void setSrType(String srType) {
		this.srType = srType;
	}

	public String getBelongIdcard() {
		return this.belongIdcard;
	}

	public void setBelongIdcard(String belongIdcard) {
		this.belongIdcard = belongIdcard;
	}

	public String getBelongName() {
		return this.belongName;
	}

	public void setBelongName(String belongName) {
		this.belongName = belongName;
	}

	public String getBelongOrganCode() {
		return this.belongOrganCode;
	}

	public void setBelongOrganCode(String belongOrganCode) {
		this.belongOrganCode = belongOrganCode;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProjectNo() {
		return this.projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	public String getPlanType() {
		return this.planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getBearUnit() {
		return this.bearUnit;
	}

	public void setBearUnit(String bearUnit) {
		this.bearUnit = bearUnit;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPersonInCharge() {
		return this.personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFinishedPerson() {
		return this.finishedPerson;
	}

	public void setFinishedPerson(String finishedPerson) {
		this.finishedPerson = finishedPerson;
	}

	public String getCost() {
		return this.cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Date getFinishedDate() {
		return this.finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}

	public String getFunture() {
		return this.funture;
	}

	public void setFunture(String funture) {
		this.funture = funture;
	}

	public String getAchievementNo() {
		return this.achievementNo;
	}

	public void setAchievementNo(String achievementNo) {
		this.achievementNo = achievementNo;
	}

	public String getAwardName() {
		return this.awardName;
	}

	public void setAwardName(String awardName) {
		this.awardName = awardName;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPeriodicalName() {
		return this.periodicalName;
	}

	public void setPeriodicalName(String periodicalName) {
		this.periodicalName = periodicalName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public String getCorrespondingAuthor() {
		return this.correspondingAuthor;
	}

	public void setCorrespondingAuthor(String correspondingAuthor) {
		this.correspondingAuthor = correspondingAuthor;
	}

	public String getFirstAuthor() {
		return this.firstAuthor;
	}

	public void setFirstAuthor(String firstAuthor) {
		this.firstAuthor = firstAuthor;
	}

	public String getSecordAuthor() {
		return this.secordAuthor;
	}

	public void setSecordAuthor(String secordAuthor) {
		this.secordAuthor = secordAuthor;
	}

	public String getPress() {
		return this.press;
	}

	public void setPress(String press) {
		this.press = press;
	}

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getChiefEditor() {
		return this.chiefEditor;
	}

	public void setChiefEditor(String chiefEditor) {
		this.chiefEditor = chiefEditor;
	}

	public String getSubeditor() {
		return this.subeditor;
	}

	public void setSubeditor(String subeditor) {
		this.subeditor = subeditor;
	}

	public String getParticipant() {
		return this.participant;
	}

	public void setParticipant(String participant) {
		this.participant = participant;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPatentNo() {
		return this.patentNo;
	}

	public void setPatentNo(String patentNo) {
		this.patentNo = patentNo;
	}

	public String getPatentName() {
		return this.patentName;
	}

	public void setPatentName(String patentName) {
		this.patentName = patentName;
	}

	public String getApplicant() {
		return this.applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getOtherAuthor() {
		return this.otherAuthor;
	}

	public void setOtherAuthor(String otherAuthor) {
		this.otherAuthor = otherAuthor;
	}

	public String getOtherEditor() {
		return this.otherEditor;
	}

	public void setOtherEditor(String otherEditor) {
		this.otherEditor = otherEditor;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCreateOrganCode() {
		return this.createOrganCode;
	}

	public void setCreateOrganCode(String createOrganCode) {
		this.createOrganCode = createOrganCode;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateOrganCode() {
		return this.updateOrganCode;
	}

	public void setUpdateOrganCode(String updateOrganCode) {
		this.updateOrganCode = updateOrganCode;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

    public String getCreateUserCode() {
        return createUserCode;
    }

    public void setCreateUserCode(String createUserCode) {
        this.createUserCode = createUserCode;
    }

    public String getUpdateUserCode() {
        return updateUserCode;
    }

    public void setUpdateUserCode(String updateUserCode) {
        this.updateUserCode = updateUserCode;
    }

    public String getPlanCategory() {
        return planCategory;
    }

    public void setPlanCategory(String planCategory) {
        this.planCategory = planCategory;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getAwardCategory() {
        return awardCategory;
    }

    public void setAwardCategory(String awardCategory) {
        this.awardCategory = awardCategory;
    }

    public String getBelongGbCode() {
        return belongGbCode;
    }

    public void setBelongGbCode(String belongGbCode) {
        this.belongGbCode = belongGbCode;
    }

    public String getBelongCenterCode() {
        return belongCenterCode;
    }

    public void setBelongCenterCode(String belongCenterCode) {
        this.belongCenterCode = belongCenterCode;
    }

    public String getAwardsType() {
        return awardsType;
    }

    public void setAwardsType(String awardsType) {
        this.awardsType = awardsType;
    }

    public List getBelongNameList(){
        List result = new ArrayList();
        if(StringUtil.isNotEmpty(belongName)){
            String[] names = belongName.split(";");
            for(String temp : names){
                String[] line = {temp.substring(0,temp.indexOf(" ")), temp.substring(temp.indexOf(" ")+1,temp.length())};
                result.add(line);
            }
        }
        return result;
    }
}