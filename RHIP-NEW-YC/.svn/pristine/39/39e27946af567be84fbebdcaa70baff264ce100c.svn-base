package com.founder.rhip.fds.service;

import com.founder.rhip.fds.entity.ExternalCallLog;
import com.founder.rhip.fds.repository.IExternalCallLogDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yejianfei on 17-6-23.
 */
@Service("externalCallLogService")
public class ExternalCallLogServiceImpl implements ExternalCallLogService {

    @Resource(name = "externalCallLogDao")
    private IExternalCallLogDao externalCallLogDao;

    @Override
    public void saveLog(ExternalCallLog log) {
        log.setId(externalCallLogDao.getSequenceNextVal("SEQ_EXTERNAL_CALL_LOG", Long.class));
        externalCallLogDao.insert(log);
    }

    @Override
    public void updateLog(ExternalCallLog log,String... properties) {
        externalCallLogDao.update(log,properties);
    }
}
