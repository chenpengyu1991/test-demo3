package com.founder.rhip.ehr.dto;

/**
 * 临床图表基本信息
 *
 * @author liuk
 */
public class ClinicalChartParam {
    public ClinicalChartParam() {
        super();
    }

    public ClinicalChartParam(Long id, Integer currentWeek) {
        super();
        this.currentWeek = currentWeek;
        this.id = id;
    }

    private Integer currentWeek;
    private Long id;

    public Integer getCurrentWeek() {
        return currentWeek;
    }

    public void setCurrentWeek(Integer currentWeek) {
        this.currentWeek = currentWeek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
