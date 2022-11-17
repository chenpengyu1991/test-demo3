package com.founder.rhip.fdm.service;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.fdm.ReportStatus;
import com.founder.rhip.fdm.entity.FoodTest;
import com.founder.rhip.fdm.repository.IFoodBorneReportDao;
import com.founder.rhip.fdm.repository.IFoodTestDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by sa on 2014/10/28.
 */

@Service("foodTestService")
public class FoodTestServiceImpl implements IFoodTestService {
    @Resource(name = "fcFoodTest")
    private IFoodTestDao foodTestDao;

    @Resource(name = "fdFoodborneReportDao")
    private IFoodBorneReportDao foodBorneReportDao;

    @Override
    @Transactional
    public int saveFoodTest(FoodTest foodTest)
    {
        Long id = foodTest.getId();
        if(ObjectUtil.isNotEmpty(id)){
            foodTestDao.update(foodTest);
        }else {
            Number key = foodTestDao.generatedKey(foodTest, "ID", null);
            Parameters param = new Parameters();
            param.add("TEST_ID", key);
            param.add("STATUS", ReportStatus.TS_SAVED.getValue());
            foodBorneReportDao.update(param, new Criteria("ID", foodTest.getReportId()));
        }
        return 1;
    }

    @Override
    public FoodTest getFoodTest(Criteria criteria){
        return foodTestDao.get(criteria);
    }

}