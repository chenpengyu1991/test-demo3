package com.founder.rhip.ehr.dto.ihm;

import com.founder.fasf.util.ObjectUtil;

import java.util.List;

/**
 * Created by wang_zhou on 2015/6/12.
 */
public class DoubleVisSummaryDTO {
    private Integer outTransfer = 0; // 转出
    private Integer inTransfer = 0; // 转入
    public DoubleVisSummaryDTO(List<DoubleVisDTO> doubleVisDTOs) {
        if (ObjectUtil.isNullOrEmpty(doubleVisDTOs)) {
            return;
        }
        for (DoubleVisDTO doubleVisDTO : doubleVisDTOs) {
            this.outTransfer += doubleVisDTO.getOutTransfer();
            this.inTransfer += doubleVisDTO.getInTransfer();
        }
    }

    public Integer getOutTransfer() {
        return outTransfer;
    }

    public void setOutTransfer(Integer outTransfer) {
        this.outTransfer = outTransfer;
    }

    public Integer getInTransfer() {
        return inTransfer;
    }

    public void setInTransfer(Integer inTransfer) {
        this.inTransfer = inTransfer;
    }
}
