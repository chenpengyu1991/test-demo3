package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.fasf.util.UUIDUtil;
import com.founder.rhip.ehr.entity.management.*;
import com.founder.rhip.ehr.repository.management.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by jingqiu on 17-4-14.
 */
@Service
public class HighRisk135ServiceImpl extends AbstractService implements IHighRisk135Service{

    @Resource
    private IDm135StandardDao dm135StandardDao;
    @Resource
    private IDm135QuestionDao dm135QuestionDao;
    @Resource
    private IDm135LastQuestionDao dm135LastQuestionDao;
    @Resource
    private IDm135AppraiseDao dm135AppraiseDao;

    @Resource
    private IDm135MgmtDao dm135MgmtDao;

    @Resource
    private IDm135ManageCardTempDao dm135ManageCardTempDao;
    @Resource
    private IDm135FollowupDao dm135FollowupDao;

    @Override
    public List<Dm135Standard> getStandards() {
        return dm135StandardDao.getAll();
    }

    @Override
    public PageList<Dm135Question> getPagedQuestionList(Page page, Criteria criteria) {
        Order order = new Order("SURVEY_DT", false);
        return dm135QuestionDao.getPageList(page, criteria, order);
    }

    @Override
    public Dm135Question getQuestion(Criteria criteria) {
        return dm135QuestionDao.get(criteria);
    }

    @Override
    public int saveQuestion(Dm135Question question) {
        if (StringUtil.isNullOrEmpty(question.getId())) {
            //新增
            return addQuestion(question);
        } else {
            //更新
            return updateQuestion(question);
        }
    }

    @Override
    public int addQuestion(Dm135Question question) {
        return dm135QuestionDao.insert(question);
    }

    @Override
    public int updateQuestion(Dm135Question question) {
        return dm135QuestionDao.update(question);
    }

    @Override
    public int deleteQuestion(String id) {
        return dm135QuestionDao.delete(id);
    }

    @Override
    public PageList<Dm135LastQuestion> getPagedLastQuestionList(Page page, Criteria criteria) {
        Order order = new Order("SURVEY_DT", false);
        return dm135LastQuestionDao.getPageList(page, criteria, order);
    }

    @Override
    public Dm135LastQuestion getLastQuestion(Criteria criteria) {
        return dm135LastQuestionDao.get(criteria);
    }

    @Override
    public PageList<Dm135LastQuestion> getLastQuestionList(Criteria criteria, Page page) {
        return dm135LastQuestionDao.getPageList(page, criteria);
    }
    @Override
    public PageList<Dm135Appraise> getDm315AppraiseList(Criteria criteria, Page page) {
        return dm135AppraiseDao.getPageList(page, criteria);
    }
    @Override
    public Dm135Appraise getDm315Appraise(Criteria criteria) {
        return dm135AppraiseDao.get(criteria);
    }


    @Override
    public int saveLastQuestion(Dm135LastQuestion question) {
        if (StringUtil.isNullOrEmpty(question.getId())) {
            //新增
            return addLastQuestion(question);
        } else {
            //更新
            return updateLastQuestion(question);
        }
    }

    @Override
    public int addLastQuestion(Dm135LastQuestion question) {
        return dm135LastQuestionDao.insert(question);
    }

    @Override
    public int updateLastQuestion(Dm135LastQuestion question) {
        return dm135LastQuestionDao.update(question);
    }

    @Override
    public int deleteLastQuestion(String id) {
        return dm135LastQuestionDao.delete(id);
    }

    @Override
    public PageList<Dm135Mgmt> getPagedMgmtList(Page page, Criteria criteria) {
        Criteria criteriaShow = new Criteria("is_show", "1");
        criteriaShow.add(LOP.OR, "is_show", OP.IS, null);
        criteria.add(criteriaShow);
        return dm135MgmtDao.getPageList(page, criteria);
    }

    @Override
    public Dm135Mgmt getMgmt(Criteria criteria) {
        return dm135MgmtDao.get(criteria);
    }

    @Override
    public int saveMgmtCover(Dm135Mgmt mgmt) {
        return updateMgmtCover(mgmt);
    }

    @Override
    public int addMgmtCover(Dm135Mgmt mgmt) {
        if (StringUtil.isNullOrEmpty(mgmt.getId())) {
            mgmt.setId(UUIDUtil.getUUID32Bits());
        }
        return dm135MgmtDao.insert(mgmt);
    }

    @Override
    public int updateMgmtCover(Dm135Mgmt mgmt) {
        return dm135MgmtDao.update(mgmt);
    }

    @Override
    public Dm135ManageCardTemp getManageCardTemp(Criteria criteria) {
        return dm135ManageCardTempDao.get(criteria);
    }

    @Override
    public PageList<Dm135ManageCardTemp> getManageCardTempList(Page page, Criteria criteria) {
        return dm135ManageCardTempDao.getPageList(page, criteria);
    }

    @Override
    public List<Dm135Followup> getFollowupList(Criteria criteria) {
        return dm135FollowupDao.getList(criteria, new Order("FOLLOWUP_DATE", false));
    }

    @Override
    public List<Map<String, Object>> getFollowupTrendData(String id) {
        Dm135Followup currentFollowup = getFollowup(new Criteria("id", id));
        Date followupDate = currentFollowup.getFollowupDate();
        Criteria criteria = new Criteria("followupDate", OP.LE, followupDate).add("PERSON_ID", currentFollowup.getPersonId());
        List<Map<String, Object>> followupList = dm135FollowupDao.getMapList(criteria, new Order("FOLLOWUP_DATE"));
        for (Map<String, Object> followup : followupList) {
            //计算BMI值
            String weightStr;
            String heightStr;
            if(followup.get("WEIGHT")==null){
                 weightStr = null;
            }else{
                 weightStr = String.valueOf(followup.get("WEIGHT"));
            }
            if(followup.get("WEIGHT")==null){
                heightStr = null;
            }else{
                heightStr = String.valueOf(followup.get("HEIGHT"));
            }



            if (StringUtil.isNotEmpty(weightStr) && StringUtil.isNotEmpty(heightStr)) {
                BigDecimal weight = new BigDecimal(weightStr);
                BigDecimal height = new BigDecimal(heightStr);
                BigDecimal zero = new  BigDecimal(0);
                if(ObjectUtil.isNullOrEmpty(height) || height.compareTo(zero) == 0) {
                    followup.put("BMI", 0);
                } else {
                    BigDecimal bmi = weight.divide(height.pow(2), 2, BigDecimal.ROUND_HALF_UP);
                    followup.put("BMI", bmi.toString());
                }
            }
            //计算吸烟数
            Object smoke = followup.get("SMOKE_NO");
            if (smoke == null) {
                followup.put("MORE_SMOKE_NO", 0);
            } else {
                String smokeNoStr = smoke.toString();
                if ("2".equals(smokeNoStr)) {
                    followup.put("MORE_SMOKE_NO", 0);
                } else if ("10".equals(smokeNoStr)) {
                    followup.put("MORE_SMOKE_NO", 1);
                }
            }
            //饮酒，啤酒
            BigDecimal beerTotal = BigDecimal.ONE;
            Object beerMonth = followup.get("BEER_MONTH");
            Object beerSeq = followup.get("BEER_SEQ");
            Object beerMill = followup.get("BEER_MILL");
            if (beerMonth == null && beerSeq == null && beerMill == null) {
                followup.put("BEER_TOTAL", 0);
            } else {
                if (ObjectUtil.isNotEmpty(beerMonth)) {
                    beerTotal = beerTotal.multiply(new BigDecimal(beerMonth.toString()));
                }
                if (ObjectUtil.isNotEmpty(beerSeq)) {
                    beerTotal = beerTotal.multiply(new BigDecimal(beerSeq.toString()));
                }
                if (ObjectUtil.isNotEmpty(beerMill)) {
                    beerTotal = beerTotal.multiply(new BigDecimal(beerMill.toString()));
                }
                followup.put("BEER_TOTAL", beerTotal);
            }
            //白酒
            BigDecimal spiritTotal = BigDecimal.ONE;
            Object spiritMonth = followup.get("SPIRIT_MONTH");
            Object spiritSeq = followup.get("SPIRIT_SEQ");
            Object spiritOunce = followup.get("SPIRIT_OUNCE");
            if (spiritMonth == null && spiritSeq == null && spiritOunce == null) {
                followup.put("SPIRIT_TOTAL", 0);
            } else {
                if (ObjectUtil.isNotEmpty(spiritMonth)) {
                    spiritTotal = spiritTotal.multiply(new BigDecimal(spiritMonth.toString()));
                }
                if (ObjectUtil.isNotEmpty(spiritSeq)) {
                    spiritTotal = spiritTotal.multiply(new BigDecimal(spiritSeq.toString()));
                }
                if (ObjectUtil.isNotEmpty(spiritOunce)) {
                    spiritTotal = spiritTotal.multiply(new BigDecimal(spiritOunce.toString()));
                }
                followup.put("SPIRIT_TOTAL", spiritTotal);
            }
            //葡萄酒
            BigDecimal wineTotal = BigDecimal.ONE;
            Object wineMonth = followup.get("WINE_MONTH");
            Object wineSeq = followup.get("WINE_SEQ");
            Object wineMill = followup.get("WINE_OUNCE");
            if (wineMonth == null && wineSeq == null && wineMill == null) {
                followup.put("WINE_TOTAL", 0);
            } else {
                if (ObjectUtil.isNotEmpty(wineMonth)) {
                    wineTotal = wineTotal.multiply(new BigDecimal(wineMonth.toString()));
                }
                if (ObjectUtil.isNotEmpty(wineSeq)) {
                    wineTotal = wineTotal.multiply(new BigDecimal(wineSeq.toString()));
                }
                if (ObjectUtil.isNotEmpty(wineMill)) {
                    wineTotal = wineTotal.multiply(new BigDecimal(wineMill.toString()));
                }
                followup.put("WINE_TOTAL", wineTotal);
            }
            //米酒或黄酒
            BigDecimal riceWineTotal = BigDecimal.ONE;
            Object riceWineMonth = followup.get("RICE_WINE_MONTH");
            Object riceWineSeq = followup.get("RICE_WINE_SEQ");
            Object riceWineMill = followup.get("RICE_WINE_OUNCE");
            if (riceWineMonth == null && riceWineSeq == null && riceWineMill == null) {
                followup.put("RICE_WINE_TOTAL", 0);
            } else {
                if (ObjectUtil.isNotEmpty(riceWineMonth)) {
                    riceWineTotal = riceWineTotal.multiply(new BigDecimal(riceWineMonth.toString()));
                }
                if (ObjectUtil.isNotEmpty(riceWineSeq)) {
                    riceWineTotal = riceWineTotal.multiply(new BigDecimal(riceWineSeq.toString()));
                }
                if (ObjectUtil.isNotEmpty(riceWineMill)) {
                    riceWineTotal = riceWineTotal.multiply(new BigDecimal(riceWineMill.toString()));
                }
                followup.put("RICE_WINE_TOTAL", riceWineTotal);
            }
            //高脂膳食
            int highFatDiet = 0;
            if (ObjectUtil.isNotEmpty(followup.get("EAT_MEAT"))) {
                highFatDiet += Integer.valueOf(followup.get("EAT_MEAT").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("MEAT_CATEGORY"))) {
                highFatDiet += Integer.valueOf(followup.get("MEAT_CATEGORY").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("EGG_NO"))) {
                highFatDiet += Integer.valueOf(followup.get("EGG_NO").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("FRIED_FOODS_NO"))) {
                highFatDiet += Integer.valueOf(followup.get("FRIED_FOODS_NO").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("BRIOCHE_NO"))) {
                highFatDiet += Integer.valueOf(followup.get("BRIOCHE_NO").toString());
            }
            followup.put("HIGH_FAT_DIET", highFatDiet);
            //家务劳动
            int labor1 = 0;
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_LABOR_HOUR"))) {
                labor1 = Integer.parseInt(followup.get("HIGH_LABOR_HOUR").toString()) * 60;
            }
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_LABOR_MIN"))) {
                labor1 += Integer.parseInt(followup.get("HIGH_LABOR_MIN").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_LABOR_DAY"))) {
                labor1 = Integer.parseInt(followup.get("HIGH_LABOR_DAY").toString()) * labor1 / 60;
            }
            Double labor2 = 0d;
            if (ObjectUtil.isNotEmpty(followup.get("GENERAL_LABOR_HOUR"))) {
                labor2 = Double.valueOf(followup.get("GENERAL_LABOR_HOUR").toString()) * 60;
            }
            if (ObjectUtil.isNotEmpty(followup.get("GENERAL_LABOR_MIN"))) {
                labor2 += Double.valueOf(followup.get("GENERAL_LABOR_MIN").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("GENERAL_LABOR_DAY"))) {
                labor2 = Double.valueOf(followup.get("GENERAL_LABOR_DAY").toString()) * labor2 / 60;
            }
            followup.put("HOUSEWORK", labor1 + labor2);
            //运动
            Double sportTime1 = 0d;
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_PHY_ACTI_HOUR"))) {
                sportTime1 = Double.valueOf(followup.get("HIGH_PHY_ACTI_HOUR").toString()) * 60;
            }
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_PHY_ACTI_MIN"))) {
                sportTime1 += Double.valueOf(followup.get("HIGH_PHY_ACTI_MIN").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_PHY_ACTI_DAY"))) {
                sportTime1 = Double.valueOf(followup.get("HIGH_PHY_ACTI_DAY").toString()) * sportTime1;
            }
            if (ObjectUtil.isNotEmpty(followup.get("HIGH_PHY_ACTI_MONTH"))) {
                sportTime1 = Double.valueOf(followup.get("HIGH_PHY_ACTI_MONTH").toString()) * sportTime1;
            }
            Double sportTime2 = 0d;
            if (ObjectUtil.isNotEmpty(followup.get("MIDDLE_PHY_ACTI_HOUR"))) {
                sportTime2 = Double.valueOf(followup.get("MIDDLE_PHY_ACTI_HOUR").toString()) * 60;
            }
            if (ObjectUtil.isNotEmpty(followup.get("MIDDLE_PHY_ACTI_MIN"))) {
                sportTime2 += Double.valueOf(followup.get("MIDDLE_PHY_ACTI_MIN").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("MIDDLE_PHY_ACTI_DAY"))) {
                sportTime2 = Double.valueOf(followup.get("MIDDLE_PHY_ACTI_DAY").toString()) * sportTime2;
            }
            if (ObjectUtil.isNotEmpty(followup.get("MIDDLE_PHY_ACTI_MONTH"))) {
                sportTime2 = Double.valueOf(followup.get("MIDDLE_PHY_ACTI_MONTH").toString()) * sportTime2;
            }
            Double sportTime3 = 0d;
            if (ObjectUtil.isNotEmpty(followup.get("LOW_PHY_ACTI_HOUR"))) {
                sportTime3 = Double.valueOf(followup.get("LOW_PHY_ACTI_HOUR").toString()) * 60;
            }
            if (ObjectUtil.isNotEmpty(followup.get("LOW_PHY_ACTI_MIN"))) {
                sportTime3 += Double.valueOf(followup.get("LOW_PHY_ACTI_MIN").toString());
            }
            if (ObjectUtil.isNotEmpty(followup.get("LOW_PHY_ACTI_DAY"))) {
                sportTime3 = Double.valueOf(followup.get("LOW_PHY_ACTI_DAY").toString()) * sportTime3;
            }
            if (ObjectUtil.isNotEmpty(followup.get("LOW_PHY_ACTI_MONTH"))) {
                sportTime3 = Double.valueOf(followup.get("LOW_PHY_ACTI_MONTH").toString()) * sportTime3;
            }
            followup.put("SPORT", sportTime1 + sportTime2 + sportTime3);
            //静息
            Double otherSportTime = 0d;
            if (ObjectUtil.isNotEmpty(followup.get("OTHER_SPORT_HOUR"))) {
                otherSportTime = Double.valueOf(followup.get("OTHER_SPORT_HOUR").toString()) * 60;
            }
            if (ObjectUtil.isNotEmpty(followup.get("OTHER_SPORT_MIN"))) {
                otherSportTime += Double.valueOf(followup.get("OTHER_SPORT_MIN").toString());
            }
            followup.put("REST", otherSportTime);
        }
        return followupList;
    }

    @Override
    public Dm135Followup getFollowup(Criteria criteria) {
        return dm135FollowupDao.get(criteria);
    }

    @Override
    public int saveFollowup(Dm135Followup followup) {
        //TODO:下面这个方法calculateHealthCondition是需要的，但写好了没测过，需要测试后放开注释
        /*calculateHealthCondition(followup);*/
        if (StringUtil.isNullOrEmpty(followup.getId())) {
            //新增
            return addFollowup(followup);
        } else {
            //更新
            return updateFollowup(followup);
        }
    }

    @Override
    public int saveEvaluate(Dm135Appraise appraise) {
        if (StringUtil.isNullOrEmpty(appraise.getId())) {
            dm135MgmtDao.update(new Parameters("is_appraise", "1"), new Criteria("me_number", appraise.getMeNumber()));
            return dm135AppraiseDao.insert(appraise);
        } else {
            //更新
            return dm135AppraiseDao.update(appraise);
        }
    }

    private int addFollowup(Dm135Followup followup) {
        followup.setId(UUIDUtil.getUUID32Bits());
        return dm135FollowupDao.insert(followup);
    }

    private int updateFollowup(Dm135Followup followup) {
        return dm135FollowupDao.update(followup);
    }

    /** 计算随访的健康评价 */
    private void calculateHealthCondition(Dm135Followup followup) {
        String idNo = followup.getIdNo();
        Criteria criteria = new Criteria("idNo", idNo).add("followupDate", OP.LT, followup.getFollowupDate());
        List<Dm135Followup> followupList = getFollowupList(criteria);
        if (ObjectUtil.isNotEmpty(followupList)) {
            //和上次随访比较
            Dm135Followup lastFollowup = followupList.get(0);
            Dm135Mgmt mgmt = getMgmt(new Criteria("idNo", idNo));
            compareFollowupCondition(followup, lastFollowup, mgmt.getGender());
        } else {
            //和问卷、体检数据比较
            Dm135Question question = getQuestion(new Criteria("idNo", idNo));
            Dm135ManageCardTemp manageCardTemp = getManageCardTemp(new Criteria("idNo", idNo));
            Dm135Followup lastFollowup = new Dm135Followup();
            //把问卷、体检数据放到随访实体里
            lastFollowup.setSbp(manageCardTemp.getSbp());
            lastFollowup.setDbp(manageCardTemp.getDbp());
            lastFollowup.setFbg(manageCardTemp.getFbg());
            lastFollowup.setWaistLine(manageCardTemp.getWaistline());
            lastFollowup.setHips(manageCardTemp.getHip());
            lastFollowup.setHeight(manageCardTemp.getHeight());
            lastFollowup.setWeight(manageCardTemp.getWeight());
            lastFollowup.setTc(manageCardTemp.getTc());
            lastFollowup.setTg(manageCardTemp.getTriglyceride());
            lastFollowup.setHdlc(manageCardTemp.getLhdlc());
            lastFollowup.setLdlc(manageCardTemp.getLdlc());
            if ("0".equals(question.getB2()) || "00".equals(question.getB5())) {
                lastFollowup.setSmokeNo(0);
            } else {
                lastFollowup.setSmokeNo(1);
                lastFollowup.setMoreSmokeNo(Integer.valueOf(question.getB5()));
            }
            lastFollowup.setBeerSize(Integer.valueOf(question.getB9A1()));
            lastFollowup.setBeerMonth(Integer.valueOf(question.getB9A2()));
            lastFollowup.setBeerSeq(Integer.valueOf(question.getB9A3()));
            lastFollowup.setBeerMill(Integer.valueOf(question.getB9A4()));
            lastFollowup.setSpiritDegree(Integer.valueOf(question.getB9B1()));
            lastFollowup.setSpiritMonth(Integer.valueOf(question.getB9B2()));
            lastFollowup.setSpiritSeq(Integer.valueOf(question.getB9B3()));
            lastFollowup.setSpiritOunce(new BigDecimal(question.getB9B4()));
            lastFollowup.setWineMonth(Integer.valueOf(question.getB9C1()));
            lastFollowup.setWineSeq(Integer.valueOf(question.getB9C2()));
            lastFollowup.setWineOunce(new BigDecimal(question.getB9C3()));
            lastFollowup.setRiceWineMonth(Integer.valueOf(question.getB9D1()));
            lastFollowup.setRiceWineSeq(Integer.valueOf(question.getB9D2()));
            lastFollowup.setRiceWineOunce(new BigDecimal(question.getB9D3()));
            lastFollowup.setDrinkTea(Integer.valueOf(question.getB21()));
            lastFollowup.setTeaSeq(Integer.valueOf(question.getB21C()));
            lastFollowup.setEatMeat(Integer.valueOf(question.getB23()));
            lastFollowup.setMeatCategory(Integer.valueOf(question.getB24()));
            lastFollowup.setEggNo(Integer.valueOf(question.getB25()));
            lastFollowup.setFriedFoodsNo(Integer.valueOf(question.getB26()));
            lastFollowup.setBriocheNo(Integer.valueOf(question.getB27()));
            lastFollowup.setHighLaborDay(Double.valueOf(question.getD3A1()));
            lastFollowup.setHighLaborHour(Double.valueOf(question.getD3A2()));
            lastFollowup.setHighLaborMin(Double.valueOf(question.getD3A3()));
            lastFollowup.setGeneralLaborDay(Double.valueOf(question.getD3B1()));
            lastFollowup.setGeneralLaborHour(Double.valueOf(question.getD3B2()));
            lastFollowup.setGeneralLaborMin(Double.valueOf(question.getD3B3()));
            lastFollowup.setHighPhyActiMonth(Integer.valueOf(question.getD5A1()));
            lastFollowup.setHighPhyActiDay(Integer.valueOf(question.getD5A2()));
            lastFollowup.setHighPhyActiHour(Integer.valueOf(question.getD5A3()));
            lastFollowup.setHighPhyActiMin(Integer.valueOf(question.getD5A4()));
            lastFollowup.setMiddlePhyActiMonth(Integer.valueOf(question.getD5B1()));
            lastFollowup.setMiddlePhyActiDay(Integer.valueOf(question.getD5B2()));
            lastFollowup.setMiddlePhyActiHour(Integer.valueOf(question.getD5B3()));
            lastFollowup.setMiddlePhyActiMin(Integer.valueOf(question.getD5B4()));
            lastFollowup.setLowPhyActiMonth(Integer.valueOf(question.getD5C1()));
            lastFollowup.setLowPhyActiDay(Integer.valueOf(question.getD5C2()));
            lastFollowup.setLowPhyActiHour(Integer.valueOf(question.getD5C3()));
            lastFollowup.setLowPhyActiMin(Integer.valueOf(question.getD5C4()));
            lastFollowup.setOtherSportHour(Integer.valueOf(question.getD6B2()));
            lastFollowup.setOtherSportMin(Integer.valueOf(question.getD6B3()));
            lastFollowup.setSleepHour(Integer.valueOf(question.getD7A()));
            lastFollowup.setSleepDis(Integer.valueOf(question.getD7B()));
            //计算评价
            compareFollowupCondition(followup, lastFollowup, Integer.valueOf(question.getA1()));
        }
    }

    private void compareFollowupCondition(Dm135Followup followup, Dm135Followup lastFollowup, Integer gender) {
        //血压
        if (followup.getSbp() < 130 && followup.getDbp() < 85) {
            followup.setBloodCondition(1);
        } else if (followup.getSbp() < lastFollowup.getSbp() &&
                followup.getDbp() < lastFollowup.getDbp()) {
            followup.setBloodCondition(2);
        } else {
            followup.setBloodCondition(3);
        }
        //血糖
        BigDecimal currentFbg = new BigDecimal(followup.getFbg());
        BigDecimal lastFbg = new BigDecimal(lastFollowup.getFbg());
        if (currentFbg.compareTo(new BigDecimal("6.1")) == -1) {
            followup.setFbgCondition(1);
        } else if (currentFbg.compareTo(lastFbg) == -1) {
            followup.setFbgCondition(2);
        } else {
            followup.setFbgCondition(3);
        }
        //腰围
        BigDecimal standardWaistLine = null;
        if (gender == 1) {
            standardWaistLine = new BigDecimal(90);
        } else {
            standardWaistLine = new BigDecimal(80);
        }
        if (followup.getWaistLine().compareTo(standardWaistLine) == -1) {
            followup.setWaistLineCondition(1);
        } else if (followup.getWaistLine().compareTo(lastFollowup.getWaistLine()) == -1) {
            followup.setWaistLineCondition(2);
        } else {
            followup.setWaistLineCondition(3);
        }
        //腰臀比
        BigDecimal standardWaistHips = null;
        if (gender == 1) {
            standardWaistHips = new BigDecimal("0.9");
        } else {
            standardWaistHips = new BigDecimal("0.85");
        }
        BigDecimal currentWaistHips = followup.getWaistLine().divide(followup.getHips(), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal lastWaistHips = lastFollowup.getWaistLine().divide(lastFollowup.getHips(), 2, BigDecimal.ROUND_HALF_UP);
        if (currentWaistHips.compareTo(standardWaistHips) == -1) {
            followup.setHipsCondition(1);
        } else if (currentWaistHips.compareTo(lastWaistHips) == -1) {
            followup.setHipsCondition(2);
        } else {
            followup.setHipsCondition(3);
        }
        //bmi
        BigDecimal currentBmi = followup.getWeight().divide(followup.getHeight().pow(2), 2, BigDecimal.ROUND_HALF_UP);
        BigDecimal lastBmi = lastFollowup.getWeight().divide(lastFollowup.getHeight().pow(2), 2, BigDecimal.ROUND_HALF_UP);
        if (currentBmi.compareTo(new BigDecimal(24)) == -1) {
            followup.setBmiCondition(1);
        } else if (currentBmi.compareTo(lastBmi) == -1) {
            followup.setBmiCondition(2);
        } else {
            followup.setBmiCondition(3);
        }
        //总胆固醇
        if (followup.getTc().compareTo(new BigDecimal("5.18")) == -1) {
            followup.setTcCondition(1);
        } else if (followup.getTc().compareTo(lastFollowup.getTc()) == -1) {
            followup.setTcCondition(2);
        } else {
            followup.setTcCondition(3);
        }
        //甘油三酯
        if (followup.getTg().compareTo(new BigDecimal("1.7")) == -1) {
            followup.setTgCondition(1);
        } else if (followup.getTg().compareTo(lastFollowup.getTg()) == -1) {
            followup.setTgCondition(2);
        } else {
            followup.setTgCondition(3);
        }
        //高密度脂
        BigDecimal standardHdlc = null;
        if (gender == 1) {
            standardHdlc = new BigDecimal("1.03");
        } else {
            standardHdlc = new BigDecimal("1.29");
        }
        BigDecimal currentHdlc = new BigDecimal(followup.getHdlc());
        BigDecimal lastHdlc = new BigDecimal(followup.getHdlc());
        if (currentHdlc.compareTo(standardHdlc) == 1 || currentHdlc.compareTo(standardHdlc) == 0) {
            followup.setHdlcCondition(1);
        } else if (currentHdlc.compareTo(lastHdlc) == 1) {
            followup.setHdlcCondition(2);
        } else {
            followup.setHdlcCondition(3);
        }
        //低密度脂
        BigDecimal currentLdlc = new BigDecimal(followup.getHdlc());
        BigDecimal lastLdlc = new BigDecimal(followup.getHdlc());
        if (currentLdlc.compareTo(new BigDecimal("3.37")) == -1) {
            followup.setHdlcCondition(1);
        } else if (currentLdlc.compareTo(lastLdlc) == -1) {
            followup.setHdlcCondition(2);
        } else {
            followup.setHdlcCondition(3);
        }
        //吸烟
        if (followup.getSmokeNo() == 0) {
            followup.setSmokeCondition(1);
        } else if (followup.getSmokeNo() < lastFollowup.getSmokeNo() ||
                followup.getMoreSmokeNo() < lastFollowup.getMoreSmokeNo()) {
            followup.setSmokeCondition(2);
        } else {
            followup.setSmokeCondition(3);
        }
        //饮酒
        int currentDrink1 = followup.getBeerMonth() * followup.getBeerSeq() / 4;
        int currentDrink2 = followup.getSpiritMonth() * followup.getSpiritSeq() / 4;
        int currentDrink3 = followup.getWineMonth() * followup.getWineSeq() / 4;
        int currentDrink4 = followup.getRiceWineMonth() * followup.getRiceWineSeq() / 4;
        int lastDrink1 = lastFollowup.getBeerMonth() * lastFollowup.getBeerSeq() / 4;
        int lastDrink2 = lastFollowup.getSpiritMonth() * lastFollowup.getSpiritSeq() / 4;
        int lastDrink3 = lastFollowup.getWineMonth() * lastFollowup.getWineSeq() / 4;
        int lastDrink4 = lastFollowup.getRiceWineMonth() * lastFollowup.getRiceWineSeq() / 4;
        if ((currentDrink1 < 2 && followup.getBeerMill() <= 300) ||
                (currentDrink2 < 2 && followup.getSpiritOunce().compareTo(BigDecimal.ONE) == -1) ||
                (currentDrink3 < 2 && followup.getWineOunce().compareTo(new BigDecimal(2)) == -1)) {
            followup.setDrinkCondition(1);
        } else if (currentDrink1 < lastDrink1 || currentDrink2 < lastDrink2 ||
                currentDrink3 < lastDrink3 || currentDrink4 < lastDrink4) {
            followup.setDrinkCondition(2);
        } else {
            followup.setDrinkCondition(3);
        }
        //喝茶
        int currentTea = followup.getTeaSeq() * 7;
        int lastTea = lastFollowup.getTeaSeq() * 7;
        if (currentTea > 3) {
            followup.setDrinkTeaCondition(1);
        } else if (currentTea > lastTea) {
            followup.setDrinkTeaCondition(2);
        } else {
            followup.setDrinkTeaCondition(3);
        }
        //膳食口味
        if (followup.getTaste() == 3) {
            followup.setTasteCondition(1);
        } else if (followup.getTaste() == 3 && lastFollowup.getTaste() != 3) {
            followup.setTasteCondition(2);
        } else {
            followup.setTasteCondition(3);
        }
        //高脂膳食
        int currentHighFatDiet = followup.getEatMeat() +followup.getMeatCategory() + followup.getEggNo() +
                followup.getFriedFoodsNo() + followup.getBriocheNo();
        int lastHighFatDiet = lastFollowup.getEatMeat() +lastFollowup.getMeatCategory() + lastFollowup.getEggNo() +
                lastFollowup.getFriedFoodsNo() + lastFollowup.getBriocheNo();
        if (currentHighFatDiet < 5) {
            followup.setFatDietCondition(1);
        } else if (currentHighFatDiet < lastHighFatDiet) {
            followup.setFatDietCondition(2);
        } else {
            followup.setFatDietCondition(3);
        }
        //家务劳动
        Double currentHousework = (followup.getHighLaborHour() * 60 + followup.getHighLaborMin()) * followup.getHighLaborDay();
        currentHousework += (followup.getGeneralLaborHour() * 60 + followup.getGeneralLaborMin()) * followup.getGeneralLaborDay();
        currentHousework = currentHousework / 60;
        Double lastHousework = (lastFollowup.getHighLaborHour() * 60 + lastFollowup.getHighLaborMin()) * lastFollowup.getHighLaborDay();
        lastHousework += (lastFollowup.getGeneralLaborHour() * 60 + lastFollowup.getGeneralLaborMin()) * lastFollowup.getGeneralLaborDay();
        lastHousework = lastHousework / 60;
        if (currentHousework >= 15) {
            followup.setHouseWorkCondition(1);
        } else if (currentHousework < lastHousework) {
            followup.setHouseWorkCondition(2);
        } else {
            followup.setHouseWorkCondition(3);
        }
        //运动
        int currentSport = (followup.getHighPhyActiHour() * 60 + followup.getHighPhyActiMin()) * followup.getHighPhyActiDay() / 4;
        currentSport += (followup.getMiddlePhyActiHour() * 60 + followup.getMiddlePhyActiMin()) * followup.getMiddlePhyActiDay() / 4;
        currentSport += (followup.getLowPhyActiHour() * 60 + followup.getLowPhyActiMin()) * followup.getLowPhyActiDay() / 4;
        int lastSport = (lastFollowup.getHighPhyActiHour() * 60 + lastFollowup.getHighPhyActiMin()) * lastFollowup.getHighPhyActiDay() / 4;
        currentSport += (lastFollowup.getMiddlePhyActiHour() * 60 + lastFollowup.getMiddlePhyActiMin()) * lastFollowup.getMiddlePhyActiDay() / 4;
        currentSport += (lastFollowup.getLowPhyActiHour() * 60 + lastFollowup.getLowPhyActiMin()) * lastFollowup.getLowPhyActiDay() / 4;
        if (currentSport >= 150) {
            followup.setSportCondition(1);
        } else if (currentSport > lastSport) {
            followup.setSportCondition(2);
        } else {
            followup.setSportCondition(3);
        }
        //静息
        int currentRest = (followup.getOtherSportHour() * 60 + followup.getOtherSportMin()) * 7 / 60;
        int lastRest = (lastFollowup.getOtherSportHour() * 60 + lastFollowup.getOtherSportMin()) * 7 / 60;
        if (currentRest < 10) {
            followup.setRestingCondition(1);
        } else if (currentRest < lastRest) {
            followup.setRestingCondition(2);
        } else {
            followup.setRestingCondition(3);
        }
        //睡眠
        int sleepHour = followup.getSleepHour();
        int sleepDis = followup.getSleepDis();
        int lastSleepHour = lastFollowup.getSleepHour();
        int lastSleepDis = lastFollowup.getSleepDis();
        if (sleepHour >= 6 && sleepHour <= 8 && sleepDis == 1) {
            followup.setSleepCondition(1);
        } else if ((lastSleepHour < 6 && sleepHour > 6 && sleepHour < 8) ||
                (lastSleepHour > 8 && sleepHour < 8 && sleepHour > 6) ||
                (lastSleepDis != 1 && sleepDis == 1)) {
            followup.setSleepCondition(2);
        } else {
            followup.setSleepCondition(3);
        }
    }

    /**
     * 获取在一个年度中已经按照计划完成随访的高危人群信息
     * @param criteria
     * @param page
     * @return
     */
    @Override
    public PageList<Dm135Mgmt> getDm135MgmtsFinishedFollow(Page page, Criteria criteria) {
        return dm135MgmtDao.getDm135MgmtsFinishedFollow(page, criteria);
    }

    /**
     * 返回true表示此时此居民可以填写评价 false表示不可以
     * @param idNo
     * @return
     */
    @Override
    public boolean isCanAppraise(String idNo) {
        return dm135MgmtDao.isCanAppraise(idNo);
    }

}
