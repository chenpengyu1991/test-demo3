package com.founder.rhip.sr.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class SrQueryForm {

	private String year;

	private String belongOrg;

    private String town;

    private String village;

    private String station;

    private String idCard;

    private String name;

    private String technical;

    private String dateFrom;

    private String dateTo;
    
    private String orgCode;
    
    private String orgCode_name;

    private String queryCode;

    private String coopInsuranceCd;//农保编码

    private String pubmediCd;//医保编码

    private String disCode;//

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBelongOrg() {
        return belongOrg;
    }

    public void setBelongOrg(String belongOrg) {
        this.belongOrg = belongOrg;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgCode_name() {
		return orgCode_name;
	}

	public void setOrgCode_name(String orgCode_name) {
		this.orgCode_name = orgCode_name;
	}

	public String getQueryCode() {
		return queryCode;
	}

	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}

	public String getCoopInsuranceCd() {
		return coopInsuranceCd;
	}

	public void setCoopInsuranceCd(String coopInsuranceCd) {
		this.coopInsuranceCd = coopInsuranceCd;
	}

	public String getPubmediCd() {
		return pubmediCd;
	}

	public void setPubmediCd(String pubmediCd) {
		this.pubmediCd = pubmediCd;
	}

	public String getDisCode() {
		return disCode;
	}

	public void setDisCode(String disCode) {
		this.disCode = disCode;
	}

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(year)) {
			criteria.add("YEAR", year);
		}
		if (ObjectUtil.isNotEmpty(town)) {
			criteria.add("BELONG_GB_CODE", town);
		}
        if (ObjectUtil.isNotEmpty(village)) {
            criteria.add("BELONG_CENTER_CODE", village);
        }
        if (ObjectUtil.isNotEmpty(station)) {
            criteria.add("BELONG_ORGAN_CODE", station);
        }
        if (ObjectUtil.isNotEmpty(idCard)) {
            criteria.add("BELONG_NAME", OP.LIKE, idCard);
        }
        if (ObjectUtil.isNotEmpty(name)) {
            criteria.add("BELONG_NAME", OP.LIKE, name);
        }
        if (ObjectUtil.isNotEmpty(dateFrom) || ObjectUtil.isNotEmpty(dateTo)) {
            DateUtil.getCriteriaByDateRange(criteria, "CREATE_DATE", DateUtil.parseSimpleDate(dateFrom, null), DateUtil.parseSimpleDate(dateTo, null));
        }
		return criteria;
	}
}
