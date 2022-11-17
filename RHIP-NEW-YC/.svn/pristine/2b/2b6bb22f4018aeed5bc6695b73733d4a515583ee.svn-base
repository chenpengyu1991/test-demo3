package com.founder.rhip.ehr.dto.idm;

import com.founder.rhip.ehr.service.export.Item;

import java.util.Date;

/**
 * Created by admin on 2017/2/9.
 */
public class ListCcDto {
    @Item(index=1,column = "接触者姓名")
    private String closeName;

    @Item(index=2,column = "登记日期",isDate = true,datePattern = "yyyy/MM/dd")
    private Date registDt;

    public String getCloseName() {
        return closeName;
    }

    public void setCloseName(String closeName) {
        this.closeName = closeName;
    }

    public Date getRegistDt() {
        return registDt;
    }

    public void setRegistDt(Date registDt) {
        this.registDt = registDt;
    }
}
