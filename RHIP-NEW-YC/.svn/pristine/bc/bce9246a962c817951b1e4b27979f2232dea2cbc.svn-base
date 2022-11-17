package com.founder.rhip.im.service.medical;

import com.founder.rhip.im.repository.medical.IRdExamAnalysDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 检验结果统计
 */
@Service("exanAnalyseService")
public class ExamAnalyseService implements IExanAnalyseService {

	@Resource(name = "rdExamAnalysDao")
	private IRdExamAnalysDao rdExamAnalysDao;

	@Override
	public List<Map<String, Object>> getOrganSummary(Date beginDate, Date endDate) {
		return rdExamAnalysDao.getOrganSummary(beginDate,endDate);
	}

	@Override
	public List<Map<String, Object>> getExamAnalys(Map<String, String> paramMap) {
		return rdExamAnalysDao.getExamAnalysList(paramMap);
	}

	@Override
	public List<Map<String, Object>> getServiceAnalys(Map<String, String> paramMap) {
		return rdExamAnalysDao.getServiceAnalys(paramMap);
	}
}
