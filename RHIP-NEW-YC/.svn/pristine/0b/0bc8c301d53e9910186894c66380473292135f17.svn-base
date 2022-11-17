package com.founder.rhip.ehr.service.ta;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.repository.cic.ICicTargetDao;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 市民信息指标
 *
 * @author liuk
 * @since 2014年4月10日 16:23:26
 */
@Service("cicTargetService")
public class CicTargetServiceImpl extends AbstractService implements ICicTargetService {
    @Resource(name = "cicTargetDao")
    private ICicTargetDao cicTargetDao;

    private Set<String> updateProperties;// 每次更新的必须字段

    @PostConstruct
    private void init() {
        updateProperties = new HashSet<>(1);
        updateProperties.add("updateDate");
    }

    @Override
    public void saveTargetValue(CicTarget targetResultValue, Set<String> properties) {
        Assert.notNull(targetResultValue);
        Assert.notEmpty(properties, "请指定需要处理的属性!");
        String personId = targetResultValue.getPersonId();
        Assert.notNull(personId, "人员id不能为空");

        // 需要判断是否更新
        Criteria criteria = new Criteria("personId", personId);
        CicTarget old  = cicTargetDao.get(criteria, "id");
        boolean update = null != old;

        //计算需要处理的属性
        String[] select = getSelectProperties(targetResultValue, update, properties);
        //校验
        check(select);
        targetResultValue.setUpdateDate(new Date());
        if (update) {
            targetResultValue.setId(old.getId());
            cicTargetDao.update(targetResultValue, select);
        } else {
            cicTargetDao.insert(targetResultValue);
        }

    }

    private void check(String[] properties) {
        return;//TODO
    }

    private String[] getSelectProperties(CicTarget targetResultValue, boolean update, Set<String> properties) {
        if (update) {
            properties.addAll(updateProperties);
        } else {
            //TODO
        }
        String[] select = properties.toArray(new String[properties.size()]);
        return select;
    }

}
