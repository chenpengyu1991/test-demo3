package com.founder.rhip.im.service.loader;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.im.common.CommonUtil;
import com.founder.rhip.im.common.JSONConvertionUtil;
import com.founder.rhip.im.common.TimestampMorpher;
import com.founder.rhip.im.entity.basic.RdDataCollectionLog;
import com.founder.rhip.im.repository.basic.IRdDataCollectionLogDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ye jianfei
 * @version 1.0 2016-03-01
 */
public abstract class BaseLoader<T> {

    // Spring应用上下文环境
    private static ApplicationContext context;

    @Resource(name = "rdDataCollectionLogDao")
    private IRdDataCollectionLogDao rdDataCollectionLogDao;

    @Resource(name = "organizationApp")
    private IOrganizationApp organizationApp;

    @Autowired
    private IDictionaryApp dictionaryApp;

    private static int count = 0;

    private String orgCode;

    private String logicDate;

    private String uploadDate;

    public static ApplicationContext getContext() {
        return context;
    }

    public static void setContext(ApplicationContext context) {
        BaseLoader.context = context;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getLogicDate() {
        return logicDate;
    }

    public void setLogicDate(String logicDate) {
        this.logicDate = logicDate;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

    protected synchronized static void increment() {
        count++;
    }

    public synchronized static int getCount() {
        return count;
    }

    /**
     * 根据机构编码获取机构名称
     *
     * @param orgCode
     * @return
     */
    protected final String getOrganName(String orgCode) {
        String result = "";
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        Organization org = organizationApp.queryOrgan(orgCode);
        if (ObjectUtil.isNotEmpty(org)) {
            result = org.getOrganName();
        }
        return result;
    }

    /**
     * 插入日志
     *
     * @param orgCode    医疗机构代码
     * @param logicDate  业务发生日期
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @param createDate 新增记录时间
     * @param ojbect     监管业务实体对象
     * @throws Exception
     */
    protected final void dataCollectionLogInsert(String orgCode, String logicDate, String uploadDate, Timestamp createDate, T ojbect) throws Exception {
        // 封装日志跟踪
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        Organization org = organizationApp.queryOrgan(orgCode);
        String modelOjbectData = JSONConvertionUtil.convetObjectToJSONString(ojbect);
        RdDataCollectionLog newDcl = new RdDataCollectionLog(getTableName(ojbect.getClass()), Integer.valueOf(logicDate), ojbect.getClass().getSimpleName(), modelOjbectData, createDate);
        setOrg(org,newDcl);
        newDcl.setUploadDate(Integer.valueOf(uploadDate));
        newDcl.setCollectDate(CommonUtil.getYyyyMmDD(createDate));
        rdDataCollectionLogDao.insert(newDcl);
    }

    /**
     * 插入日志（带LOGIC_TYPE）
     *
     * @param orgCode    医疗机构代码
     * @param logicDate  业务发生日期
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @param createDate 新增记录时间
     * @param ojbect     监管业务实体对象
     * @throws Exception
     */
    protected final void dataCollectionLogInsert(String orgCode, String logicDate, String uploadDate, Timestamp createDate, T ojbect, String logicType) throws Exception {
        // 封装日志跟踪
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        Organization org = organizationApp.queryOrgan(orgCode);
        String modelOjbectData = JSONConvertionUtil.convetObjectToJSONString(ojbect);
        RdDataCollectionLog newDcl = new RdDataCollectionLog(getTableName(ojbect.getClass()), Integer.valueOf(logicDate), ojbect.getClass().getSimpleName(), modelOjbectData, createDate);
        setOrg(org,newDcl);
        newDcl.setUploadDate(Integer.valueOf(uploadDate));
        newDcl.setCollectDate(CommonUtil.getYyyyMmDD(createDate));
        newDcl.setLogicType(logicType);
        rdDataCollectionLogDao.insert(newDcl);
    }

    /**
     * 批量插入DataCollectionLog
     *
     * @param insertDataCollectionLogList DataCollectionLog List
     * @throws Exception
     */
    protected final void dataCollectionLogBatchInsert(List<RdDataCollectionLog> insertDataCollectionLogList) throws Exception {
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        rdDataCollectionLogDao.batchInsert(insertDataCollectionLogList);
    }

    /**
     * 创建一个新DataCollectionLog对象
     *
     * @param orgCode    医疗机构代码
     * @param logicDate  业务发生日期
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @param createDate 新增记录时间
     * @param ojbect     监管业务实体对象
     * @return DataCollectionLog Object
     * @author Bao Jingbin
     */
    protected final RdDataCollectionLog createNewDataCollectionLogObject(String orgCode, String logicDate, String uploadDate, Timestamp createDate, T ojbect) {
        // 封装日志跟踪
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        Organization org = organizationApp.queryOrgan(orgCode);
        String modelOjbectData = JSONConvertionUtil.convetObjectToJSONString(ojbect);
        RdDataCollectionLog newDcl = new RdDataCollectionLog(getTableName(ojbect.getClass()), Integer.valueOf(logicDate), ojbect.getClass().getSimpleName(), modelOjbectData, createDate);
        setOrg(org,newDcl);
        newDcl.setUploadDate(Integer.valueOf(uploadDate));
        newDcl.setCollectDate(CommonUtil.getYyyyMmDD(createDate));
        return newDcl;
    }

    /**
     * 创建一个新DataCollectionLog对象
     *
     * @param orgCode    医疗机构代码
     * @param logicDate  业务发生日期
     * @param uploadDate 上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @param createDate 新增记录时间
     * @param ojbect     监管业务实体对象
     * @param logicType  业务类型 即相同实体同一日的日志分组
     * @return DataCollectionLog Object
     */
    protected final RdDataCollectionLog createNewDataCollectionLogObject(String orgCode, String logicDate, String uploadDate, Timestamp createDate, Object ojbect, String logicType) {
        // 封装日志跟踪
        if (ObjectUtil.isNullOrEmpty(organizationApp)) {
            organizationApp = (IOrganizationApp) context.getBean("organizationApp");
        }
        Organization org = organizationApp.queryOrgan(orgCode);
        String modelOjbectData = JSONConvertionUtil.convetObjectToJSONString(ojbect);
        RdDataCollectionLog newDcl = new RdDataCollectionLog(getTableName(ojbect.getClass()), Integer.valueOf(logicDate), ojbect.getClass().getSimpleName(), modelOjbectData, createDate);
        setOrg(org,newDcl);
        newDcl.setUploadDate(Integer.valueOf(uploadDate));
        newDcl.setLogicType(logicType);
        newDcl.setCollectDate(CommonUtil.getYyyyMmDD(createDate));
        return newDcl;
    }

    /**
     * 根据医疗机构代码和业务发生日期获得日志对象
     *
     * @param orgCode     医疗机构代
     * @param logicDate   上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @param entityClass 实体类Class
     * @return DataCollectionLog对象
     * @throws Exception
     * @author Bao Jingbin
     */
    protected RdDataCollectionLog getDataCollectionLogObject(String orgCode, String logicDate, Class<?> entityClass) throws Exception {
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        Criteria ca = new Criteria();
        if (StringUtil.isNotEmpty(orgCode)) {
            ca.add("ORGAN_CODE", orgCode);
        }
        if (StringUtil.isNotEmpty(logicDate)) {
            ca.add("LOGIC_DATE", logicDate);
        }
        if (ObjectUtil.isNotEmpty(entityClass)) {
            ca.add("MODEL_NAME", entityClass.getSimpleName());
            ca.add("TABLE_NAME", getTableName(entityClass));
        }
        return rdDataCollectionLogDao.get(ca);
    }

    /**
     * 根据医疗机构代码和业务发生日期获得日志对象
     *
     * @param orgCode     医疗机构代
     * @param logicDate   上传日期，数据从前置机上传到数据中心的日期。格式：yyyyMMdd
     * @param entityClass 实体类Class
     * @return DataCollectionLog对象
     * @throws Exception
     */
    protected final RdDataCollectionLog getDataCollectionLogObject(String orgCode, String logicDate, Class<?> entityClass, String logicType) throws Exception {
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        Criteria ca = new Criteria();
        if (StringUtil.isNotEmpty(orgCode)) {
            ca.add("ORGAN_CODE", orgCode);
        }
        if (StringUtil.isNotEmpty(logicDate)) {
            ca.add("LOGIC_DATE", logicDate);
        }
        if (ObjectUtil.isNotEmpty(entityClass)) {
            ca.add("MODEL_NAME", entityClass.getSimpleName());
            ca.add("TABLE_NAME", getTableName(entityClass));
        }
        if (ObjectUtil.isNotEmpty(logicType)) {
            ca.add("LOGIC_TYPE", logicType);
        }
        return rdDataCollectionLogDao.get(ca);
    }

    /**
     * 更新日志
     *
     * @param dataCollectionLog DataCollectionLog对象
     * @param object            监管业务实体对象
     * @param updateDate        更新记录时间
     * @throws Exception
     */
    protected final void dataCollectionLogUpdate(RdDataCollectionLog dataCollectionLog, Object object, Timestamp updateDate) throws Exception {
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        dataCollectionLog.setModelOjbectData(JSONConvertionUtil.convetObjectToJSONString(object));
        dataCollectionLog.setUpdateDate(updateDate);
        rdDataCollectionLogDao.update(dataCollectionLog);
    }

    /**
     * 批量更新日志
     *
     * @param updateDataCollectionLogList 监管业务实体对象 List
     * @throws Exception
     */
    protected final void dataCollectionLogBatchUpdate(List<RdDataCollectionLog> updateDataCollectionLogList) throws Exception {
        if (ObjectUtil.isNullOrEmpty(rdDataCollectionLogDao)) {
            rdDataCollectionLogDao = (IRdDataCollectionLogDao) context.getBean("rdDataCollectionLogDao");
        }
        rdDataCollectionLogDao.batchUpdate(updateDataCollectionLogList);
    }

    /**
     * 插入业务对象数据
     *
     * @param dao    与业务对象对应的Dao
     * @param entity 业务对象
     * @throws Exception
     */
    protected final void logicObjectInsert(IDao dao, T entity) throws Exception {
        dao.insert(entity);
    }

    /**
     * 查询业务对象
     *
     * @param dao       与业务对象DAO
     * @param orgCode   机构代码
     * @param logicDate 业务发生日期
     * @return 业务对象
     * @throws Exception
     */
    protected final T getLogicEntity(IDao dao, String orgCode, String logicDate) throws Exception {
        Criteria ca = new Criteria();
        ca.add("ORGAN_CODE", orgCode);
        int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
        ca.add("year", yqm[0]);
        ca.add("month", yqm[3]);
        return (T) dao.get(ca);
    }

    /**
     * 查询业务对象
     *
     * @param dao       与业务对象DAO
     * @param orgCode   机构代码
     * @param logicDate 业务发生日期
     * @param criteria  其他条件
     * @return 业务对象
     * @throws Exception
     */
    protected final T getLogicEntity(IDao dao, String orgCode, String logicDate, Criteria criteria) throws Exception {
        Criteria ca = new Criteria();
        ca.add("ORGAN_CODE", orgCode);
        int[] yqm = CommonUtil.converToYearHalfYearQuarterMonth(logicDate);
        ca.add("year", yqm[0]);
        ca.add("month", yqm[3]);
        ca.add(criteria);
        return (T) dao.get(ca);
    }

    /**
     * 转换 Model Ojbect Data 为实体对象
     *
     * @param modelOjbectData
     * @param clazz
     * @return 实体对象
     * @author Bao Jingbin
     */
    protected final T convertToEntityObjectFromJSON(String modelOjbectData, Class<T> clazz) {
        String[] formats = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd"};
        JSONUtils.getMorpherRegistry().registerMorpher(new TimestampMorpher(formats));
        return (T) JSONObject.toBean(JSONObject.fromObject(modelOjbectData), clazz);
    }

    /**
     * 更新业务对象数据
     *
     * @param dao    与业务对象对应的dao
     * @param entity 业务对象
     * @throws Exception
     */
    protected final void logicObjectUpdate(IDao dao, T entity) throws Exception {
        dao.update(entity);
    }


    /**
     * 为机构相关的属性赋值
     * @param organization
     * @param rdDataCollectionLog
     */
    private void setOrg(Organization organization, RdDataCollectionLog rdDataCollectionLog) {
        rdDataCollectionLog.setGbCode(organization.getGbCode());
        rdDataCollectionLog.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
        rdDataCollectionLog.setOrganCode(organization.getOrganCode());
        rdDataCollectionLog.setGenreCode(organization.getGenreCode());
        rdDataCollectionLog.setOrganCode(organization.getOrganCode());
        rdDataCollectionLog.setOrgName(organization.getOrganName());
    }

    private String getTableName(Class<?> entityClass) {
        String name = entityClass.getSimpleName();
        List<String> listStr = new ArrayList<String>();
        int beginIndex = 0;
        int endIndex = 0;
        String x = "mm";
        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') {
                if (i == 0) {
                    beginIndex = 0;
                } else {
                    endIndex = i;
                    String s = name.substring(beginIndex, endIndex);
                    x = x + "_" + s.toLowerCase();
                    listStr.add(s);
                    beginIndex = i;
                }
            }
            if (i == (name.length() - 1)) {
                String s = name.substring(beginIndex);
                x = x + "_" + s.toLowerCase();
            }
        }
        return x;
    }
}
