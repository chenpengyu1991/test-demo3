package com.founder.rhip.yitiji;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.BaseWebService;
import com.founder.rhip.ehr.entity.basic.FingerInfo;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IFingerInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordService;
import com.founder.rhip.mdm.IPersonWebService;
import com.founder.rhip.mdm.service.IPersonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by f on 2018/8/9.
 */
@Service("yiTiJiWebService")
@WebService(serviceName="yiTiJiWebService")
public class YiTiJiWebService extends BaseWebService implements IYiTiJiWebService {

    protected static Logger logger = Logger.getLogger(YiTiJiWebService.class.getName());

    @Autowired
    IFingerInfoDao fingerDao;

    @Resource(name = "personalRecordService")
    private IPersonalRecordService personInfoService;

    @Override
    public FingerInfoRs queryFingerInfo(String idCard) {
        FingerInfoRs rs = new FingerInfoRs();
        if(StringUtil.isEmpty(idCard)){
            logger.warn("一体机查询指纹接口-参数不能为空!");
            rs.setCode(rs.ERROR);
            rs.setMessage("参数不能为空!");
            return rs;
        }
        Criteria criteria = new Criteria("idcard",idCard);
        List<PersonInfo> personList = personInfoService.getPersonRecordList(criteria);
        if(personList==null||personList.size()==0){
            logger.warn("一体机查询指纹接口-查询不到档案信息!(身份证号:"+idCard);
            rs.setCode(rs.WARN_2);
            rs.setMessage("用户不存在!");
            return rs;
        }
        FingerInfo finger = fingerDao.get(criteria);
        if(finger==null||finger.getFingerId()==null)
        {
            logger.warn("一体机查询指纹接口-查询不到指纹信息!(身份证号:"+idCard);
            rs.setCode(rs.WARN_0);
            rs.setMessage("查询不到指纹信息!");
            return rs;
        }
        rs.setCode(rs.SUCCESS);
        rs.setMessage("查询成功!");
        String tmp = finger.getFingerTemplate();
        String tmp2=finger.getFingerTemplateSec();
        if(StringUtil.isNotEmpty(tmp2))
            tmp = tmp + tmp2;
        rs.setFingerTmp(tmp);
        return rs;
    }
}
