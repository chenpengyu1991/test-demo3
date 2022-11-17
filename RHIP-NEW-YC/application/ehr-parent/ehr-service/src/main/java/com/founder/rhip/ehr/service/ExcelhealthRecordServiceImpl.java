package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.clinic.ExcelToDB;
import com.founder.rhip.ehr.repository.clinic.IExcelHealthRecordDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuanzg on 2017/2/21.
 */
@Service("excelhealthRecordService")
public class ExcelhealthRecordServiceImpl implements IExcelHealthRecordService{

    @Resource(name = "excelHealthRecordDao")
    private IExcelHealthRecordDao excelHealthRecordDao;

    /**
     * 获取健康档案数据
     * @param criteria
     * @return
     */
    @Override
    public List<ExcelToDB> getExcelHealthRecord(Criteria criteria) {
        return excelHealthRecordDao.getList(criteria);
    }
}
