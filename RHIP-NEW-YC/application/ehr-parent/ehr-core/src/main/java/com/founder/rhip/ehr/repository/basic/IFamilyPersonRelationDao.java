package com.founder.rhip.ehr.repository.basic;

import com.founder.rhip.ehr.entity.basic.FamilyPersonRelation;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;

import java.util.List;

/**
 * DAO interface of FamilyPersonRelation
 */
public interface IFamilyPersonRelationDao extends IDao<FamilyPersonRelation, Long> {

    public List<PersonInfo> getList(FamilyPersonRelation familyPersonRelation);
    
    /** 获取家庭关系 */
    public List<FamilyPersonRelation> getFamilyPersonRelations(Criteria criteria);

}