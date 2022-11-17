package com.founder.rhip.ehr.entity.clinic;

import com.founder.rhip.ehr.annotation.RecordTrace;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "MS_HEALTH_EVALUATE_ANOMALY")
public class HealthEvaluateAnomaly implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "EHR_ID", columnDefinition = "VARCHAR||", length = 20, nullable = true)
    private String ehrId;

    @RecordTrace
    @Column(name = "HEALTH_EVALUATE_ANOMALY_DESC", columnDefinition = "VARCHAR||", length = 200, nullable = true)
    private String healthEvaluateAnomalyDesc;

    @Column(name = "IS_DELETE", columnDefinition = "NUMBER||", length = 1, nullable = true)
    private Integer isDelete;
    
	@Column(name = "GATHER_DATE", columnDefinition = "DATE|采集时间||", nullable = true)
	private Date gatherDate;

	@Column(name = "SORT", columnDefinition = "NUMBER|排序||", length = 2,nullable = true)
	private Integer sort;
	
    public String getEhrId() {
		return ehrId;
	}

	public void setEhrId(String ehrId) {
		this.ehrId = ehrId;
	}

	public String getHealthEvaluateAnomalyDesc() {
        return healthEvaluateAnomalyDesc;
    }

    public void setHealthEvaluateAnomalyDesc(String healthEvaluateAnomalyDesc) {
        this.healthEvaluateAnomalyDesc = healthEvaluateAnomalyDesc;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

	public Date getGatherDate() {
		return gatherDate;
	}

	public void setGatherDate(Date gatherDate) {
		this.gatherDate = gatherDate;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
