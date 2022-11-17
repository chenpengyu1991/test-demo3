package com.founder.rhip.ehr.service.nc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.nc.NcLog;
import com.founder.rhip.ehr.repository.nc.*;
import com.founder.rhip.ehr.service.INcService;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("ncService")
public class NcService implements INcService {

	@Resource(name = "ncBloodDonationDao")
	private INcBloodDonationDao ncBloodDonationDao;

	@Resource(name = "ncPlateletsDao")
	private INcPlateletsDao plateletsDao;

	@Resource(name = "ncChildExaminationDao")
	private INcChildExaminationDao childExaminationDao;

	@Resource(name = "ncHealthCertificateDao")
	private INcHealthCertificateDao healthCertificateDao;

	@Resource(name = "ncHealthRecordsDao")
	private INcHealthRecordsDao healthRecordsDao;

	@Resource(name = "ncPunishmentDao")
	private INcPunishmentDao punishmentDao;

	@Resource(name = "ncVaccinationDao")
	private INcVaccinationDao vaccinationDao;

	@Resource(name = "ncPerinatalCardDao")
	private INcPerinatalCardDao perinatalCardDao;

	@Resource(name = "ncPrenatalExaminationDao")
	private INcPrenatalExaminationDao prenatalExaminationDao;

	@Resource(name = "ncLogDao")
	private INcLogDao insertNcLogDao;

	protected Logger logger = Logger.getLogger(NcService.class.getName());

	/**
	 * 当年及前五年内献血接口
	 *
	 * @param idCard
	 * @param personName
	 * @param operateDateStr
	 * @return
	 */
	@Override
	public int getBloodDonation5(String idCard, String personName,
			String operateDateStr) {
		int result = 0;
		try {
			Criteria ca = getCommonCa(idCard, personName);
			if (StringUtil.isNotEmpty(operateDateStr)) {
				Date dateEnd = DateUtil.parseSimpleDate(operateDateStr, "yyyyMMdd");
				Date dateStart = getStartDate(operateDateStr);
				DateUtil.getCriteriaByDateRange(ca, "OPERATE_DATE", dateStart,
						dateEnd);
			}
			result = ncBloodDonationDao.getBloodDonation5(ca);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 当年及前五年内捐献血小板接口
	 *
	 * @param idCard
	 * @param personName
	 * @param operateDateStr
	 * @return
	 */
	@Override
	public int getPlatelets5(String idCard, String personName,
			String operateDateStr) {
		int result = 0;
		try {
			Criteria ca = getCommonCa(idCard, personName);
			if (StringUtil.isNotEmpty(operateDateStr)) {
				Date dateEnd = DateUtil.parseSimpleDate(operateDateStr, "yyyyMMdd");
				Date dateStart = getStartDate(operateDateStr);
				DateUtil.getCriteriaByDateRange(ca, "OPERATE_DATE", dateStart,
						dateEnd);
			}
			result = plateletsDao.getPlatelets5(ca);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 早孕是否建卡接口
	 *
	 * @param idCard
	 * @param personName
	 * @return
	 */
	@Override
	public String isCarded(String idCard, String personName) {
		String result = "";
		try {
			Criteria ca = getCommonCa(idCard, personName);
			List resultList = perinatalCardDao.getList(ca);
			result = convertResult(resultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 产前是否检查接口
	 *
	 * @param idCard
	 * @param personName
	 * @return
	 */
	@Override
	public String isChecked5(String idCard, String personName) {
		String result = "";
		try {
			Criteria ca = getCommonCa(idCard, personName);
			List resultList = prenatalExaminationDao.getList(ca);
			result = convertResult(resultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 儿童是否定期检查接口
	 *
	 * @param idCard
	 * @param personName
	 * @return
	 */
	@Override
	public String isChildRegular(String idCard, String personName) {
		String result = "";
		try {
			Criteria ca = getCommonCa(idCard, personName);
			List resultList = childExaminationDao.getList(ca);
			result = convertResult(resultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 三星健康档案接口
	 *
	 * @param idCard
	 * @param personName
	 * @return
	 */
	@Override
	public String isHealthRecord3Star(String idCard, String personName) {
		String result = "";
		try {
			Criteria ca = getCommonCa(idCard, personName);
			List resultList = healthRecordsDao.getList(ca);
			result = convertResult(resultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	/**
	 * 预防接种是否齐全接口
	 *
	 * @param idCard
	 * @param personName
	 * @param birthdayStr
	 * @param parentName
	 * @return
	 */
	@Override
	public String isVaccinationComplete(String idCard, String personName,
			String birthdayStr, String parentName) {
		String result = "";
		try {
			Criteria ca = getCommonCa(idCard, personName);
			if (StringUtil.isNotEmpty(birthdayStr)) {
				if (birthdayStr.length() != 8) {
					birthdayStr = birthdayStr + "01";
				}
				// ca.add("TO_CHAR(BRITHDAY, 'YYYYMMDD')", birthdayStr);
				DateUtil.getCriteriaByDateRange(ca, "BRITHDAY",
						DateUtil.parseSimpleDate(birthdayStr, "yyyyMMdd"),
						DateUtil.parseSimpleDate(birthdayStr, "yyyyMMdd"));
			}
			if (StringUtil.isNotEmpty(parentName)) {
				ca.add("PARENT_NAME", OP.LIKE, parentName);
			}
			List resultList = vaccinationDao.getList(ca);
			result = convertResult(resultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;

	}

	/**
	 * 是否办理从业人员健康证
	 *
	 * @param idCard
	 * @param personName
	 * @return
	 */
	@Override
	public String hasHealthCertificate(String idCard, String personName) {
		String result = "";
		try {
			Criteria ca = getCommonCa(idCard, personName);
			List resultList = healthCertificateDao.getList(ca);
			result = convertResult(resultList);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;

	}

	/**
	 * 行政处罚
	 *
	 * @param idCard
	 * @param personName
	 * @param punishedDateStr
	 * @return
	 */
	@Override
	public int getPunishedTimes(String idCard, String personName,
			String punishedDateStr) {
		int result = 0;
		try {
			Criteria ca = getCommonCa(idCard, personName);
			// TODO punishedDateStr
			if (StringUtil.isNotEmpty(punishedDateStr)) {
				DateUtil.getCriteriaByDateRange(ca, "PUNISHED_DATE",
						DateUtil.parseSimpleDate("19000101", "yyyyMMdd"),
						DateUtil.parseSimpleDate(punishedDateStr, "yyyyMMdd"));
			}
			List resultList = punishmentDao.getList(ca);
			if (ObjectUtil.isNotEmpty(resultList)) {
				result = resultList.size();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	// 获取5年前的时间
	private Date getStartDate(String endDateStr) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR,
				Integer.parseInt(endDateStr.substring(0, 4)) - 5);
		calendar.set(Calendar.MONTH,
				Integer.parseInt(endDateStr.substring(4, 6)) - 1);
		calendar.set(Calendar.DATE,
				Integer.parseInt(endDateStr.substring(6, 8)));
		return calendar.getTime();
	}

	// 共通查询条件 idCard personName
	private Criteria getCommonCa(String idCard, String personName) {
		Criteria ca = new Criteria();
		if (StringUtil.isNotEmpty(idCard)) {
			ca.add("ID_CARD", idCard);
		}
		if (StringUtil.isNotEmpty(personName)) {
			ca.add("PERSON_NAME", OP.LIKE, personName);
		}
		return ca;
	}

	/**
	 * "1" true , "0" false
	 *
	 * @param resultList
	 * @return
	 */
	private String convertResult(List resultList) {
		if (ObjectUtil.isNotEmpty(resultList) && resultList.size() > 0) {
			return "1";
		} else {
			return "0";
		}
	}

	@Override
	public int insertNcLog(NcLog ncLog) {
		try {
			insertNcLogDao.insert(ncLog);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

}
