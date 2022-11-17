package com.founder.rhip.ehr.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.CurrentLoginInfo;
import com.founder.rhip.ehr.entity.basic.PersonDeathRecord;
import com.founder.rhip.ehr.entity.child.ChildDeath;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;
import com.founder.rhip.ehr.entity.women.MaternalDeath;

/**
 * 
 * @author Administrator
 *
 */
public interface ILifeEventService {

	public PersonDeathRecord query(Criteria criteria);
	
    public PageList<PersonDeathRecord> queryList(Criteria criteria, Page page);
    
    public int batchSave(List<PersonDeathRecord> records);
    
    public String Cancel(CurrentLoginInfo loginInfo,String ip);
    
    /**
     * 获取死亡最高的前十种病
     * @return
     */
    public List<PersonDeathRecord> getTopTenDeath(Criteria criteria);
    
    /**
     * 统计死于最高的前十种病的人口数目
     * @param criteria
     * @return
     */
    public List<PersonDeathRecord> getDeathICD10TargetList(Criteria criteria);

    /**
     * 生命事件激活
     * @param personRecordId
     * @param filingFlag
     * @return
     */
    public String activePersonRecord(Long personRecordId,String filingFlag);

    /**
     * 生命事件EXCEL导入
     * @param personDeathRecords
     * @param deathMedicineCertificates
     * @param childDeaths
     * @param maternalDeaths
     * @return
     */
    public int batchSave(List<PersonDeathRecord> personDeathRecords
            ,List<DeathMedicineCertificate> deathMedicineCertificates
            ,List<ChildDeath> childDeaths
            ,List<MaternalDeath> maternalDeaths);

    /**
     * 死因统计分析
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getDeathICD10MapList(Criteria ca);

    /**
     * 人群分类分析
     * @param ca
     * @return
     */
    public List<Map<String, Object>> getPersonTypeMapList(Criteria ca);
}
