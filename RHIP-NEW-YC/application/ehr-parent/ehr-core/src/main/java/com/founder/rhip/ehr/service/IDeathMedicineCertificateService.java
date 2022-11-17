package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.DeathInfo;
import com.founder.rhip.ehr.entity.control.DeathMedicineCertificate;

import java.util.List;

/**
 * 
 * @author Administrator
 *
 */
public interface IDeathMedicineCertificateService {

    public PageList<DeathMedicineCertificate> queryList(Criteria criteria, Page page,Order order);
    
    public PageList<DeathMedicineCertificate> queryList(Criteria criteria, Page page);

    public DeathMedicineCertificate getDeathMedicineCertificate(Criteria criteria);

    public int batchSave(List<DeathMedicineCertificate> records);
    
    public int save(DeathMedicineCertificate deathMedicineCertificate);

    public int update(DeathMedicineCertificate deathMedicineCertificate); 
    
    public int deleteChildDeath(DeathMedicineCertificate deathMedicineCertificate);

    PageList<DeathInfo> queryDeathInfoList(Criteria criteria, Page page);

    DeathInfo queryDeathInfo(Criteria criteria);}
