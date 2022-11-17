package com.founder.rhip.im.service.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.repository.medical.IRdPrescriptionDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("prescriptionService")
public class PrescriptionService implements IPrescriptionService {

	@Resource(name = "rdPrescriptionDao")
	private IRdPrescriptionDao rdPrescriptionDao;

	@Override
	public List<Map<String, Object>> getPrescriptionCostMapList(Criteria ca) {
		return rdPrescriptionDao.getPrescriptionCostMapList(ca);
	}
}
