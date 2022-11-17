package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.ReportRecord;
import com.founder.rhip.ehr.repository.basic.IReportRecordDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service("reportRecordService")
public class ReportRecordServiceImpl extends AbstractService implements IReportRecordService {

    @Resource(name = "reportRecordDao")
    private IReportRecordDao reportRecordDao;

    @Override
    public PageList<ReportRecord> findReportRecord(Criteria criteria, Page page, Order order) {
        return reportRecordDao.getPageList(page, criteria, order);
    }

    public PageList<ReportRecord> findPageReportRecord(Criteria criteria, Page page, String order) {
        return reportRecordDao.getPageReportRecord(page, criteria, order);
    }

    @Override
    public long save(ReportRecord reportRecord) {
        return reportRecordDao.generatedKey(reportRecord,"ID",null).longValue();
    }

    @Override
    public int update(Long id, Long reportId, int status) {

        Parameters parameters = new Parameters();
        if(null != reportId){
            parameters.add("REPORT_ID",reportId);
        }
        parameters.add("status", status);
        parameters.add("UPDATE_DATE", new Date());

        return reportRecordDao.update(parameters, new Criteria("id", id));

    }

    @Override
    public ReportRecord getReportRecord(Long id) {
        return reportRecordDao.get(id);
    }

    /**
     * 删除报卡监控--逻辑删除
     */
	@Override
	@Transactional
	public boolean deleteReportRecord(ReportRecord reportRecord) {
		int result = 0;
        Long id =reportRecord.getId();
		if(ObjectUtil.isNotEmpty(id)){
			Parameters parameters = new Parameters();
			parameters.add("IS_DELETE",-1);
            parameters.add("DELETE_CONTENT",reportRecord.getDeleteContent());
            parameters.add("DELETE_CONTENT_OTHER",reportRecord.getDeleteContentOther());
            result = reportRecordDao.update(parameters, new Criteria("id", id));
		}
		return result >0?true:false;
	}

}
