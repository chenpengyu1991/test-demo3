/**
 * 家庭医生，医生、团队信息相关服务
 */
package com.founder.rhip.fds.service;


import com.founder.fasf.beans.Criteria;
import com.founder.rhip.fds.common.DoctorTeamInfo;
import com.founder.rhip.fds.entity.Doctor;
import com.founder.rhip.fds.entity.Team;

import java.util.List;

public interface DoctorService {

    /**
     * 根据用户名，获取医生团队信息
     * @param userName
     * @return
     */
    DoctorTeamInfo getDoctorTeam(String userName);

    /**
     * 根据doctorId获取医生信息
     * @param doctorId
     * @return
     */
    Doctor getDoctor(Long doctorId);

    /**
     * 根据doctorId获取医生信息
     * @param criteria
     * @return
     */
    Doctor getDoctor(Criteria criteria);

    /**
     * 根据idcard获取医生信息
     * @param idcard
     * @return
     */
    Doctor getDoctor(String  idcard);

    /**
     * 获取团队列表
     * @param idcard
     * @return
     */
    List<Team> getTeamList(String idcard);

    /**
     *获取医生团队信息
     * @param criteria
     * @return
     */
    Team getTeam(Criteria criteria);
}