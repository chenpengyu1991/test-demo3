package com.founder.rhip.fds.service;

import com.founder.rhip.fds.entity.ExternalCallLog;

/**
 * 外部访问日志
 * Created by yejianfei on 17-6-23.
 */
public interface ExternalCallLogService {

    void saveLog(ExternalCallLog log);

    void updateLog(ExternalCallLog log,String... properties);

}
