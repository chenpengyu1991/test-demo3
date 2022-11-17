package com.founder.rhip.ce.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chen_wenbo on 2014/04/02.
 */
public class ContinueEducationQueryForm {

	private String recordYear;

	private String recordYearFrom;

	private String recordYearTo;

	private String organizer;
	
	private String town;

	private String centre;
	
	private String station;

	private String name;

	private String idCard;

    private String technical;

	public String getRecordYear() {
		return recordYear;
	}

	public void setRecordYear(String recordYear) {
		this.recordYear = recordYear;
	}

	public String getOrganizer() {
		return organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTechnical() {
        return technical;
    }

    public void setTechnical(String technical) {
        this.technical = technical;
    }

    public String getRecordYearFrom() {
        return recordYearFrom;
    }

    public void setRecordYearFrom(String recordYearFrom) {
        this.recordYearFrom = recordYearFrom;
    }

    public String getRecordYearTo() {
        return recordYearTo;
    }

    public void setRecordYearTo(String recordYearTo) {
        this.recordYearTo = recordYearTo;
    }

    public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(recordYear)) {
			criteria.add("RECORD_YEAR", recordYear);
		}
        if (StringUtil.isNotEmpty(recordYearFrom)) {
            criteria.add("RECORD_YEAR", OP.GE, recordYearFrom);
        }
        if (StringUtil.isNotEmpty(recordYearTo)) {
            criteria.add("RECORD_YEAR", OP.LE, recordYearTo);
        }
        if (StringUtil.isNotEmpty(organizer)) {
			criteria.add("ORGANIZER", OP.LIKE, organizer.trim());
		}
        if (StringUtil.isNotEmpty(name)) {
            criteria.add("NAME", OP.LIKE, name);
        }
        if (StringUtil.isNotEmpty(idCard)) {
            criteria.add("ID_CARD", OP.LIKE, idCard);
        }
        if (StringUtil.isNotEmpty(technical)) {
            List techMap = new ArrayList();
            if("1".equals(technical)){//初级-->师级（助理）、士级
                techMap.add("4");
                techMap.add("5");
            }
            if("2".equals(technical)){//中级-->中级
                techMap.add("3");
            }
            if("3".equals(technical)){//高级-->正高、副高
                techMap.add("1");
                techMap.add("2");
            }
            criteria.add("TECHNICAL", OP.IN, techMap);
        }
		return criteria;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getCentre() {
		return centre;
	}

	public void setCentre(String centre) {
		this.centre = centre;
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}
	
	
}
