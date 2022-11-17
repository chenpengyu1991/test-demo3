package com.founder.rhip.fds.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.fds.common.DoctorTeamInfo;
import com.founder.rhip.fds.common.FDSConstants;
import com.founder.rhip.fds.entity.Doctor;
import com.founder.rhip.fds.entity.Team;
import com.founder.rhip.fds.entity.TeamMember;
import com.founder.rhip.fds.repository.IDoctorDao;
import com.founder.rhip.fds.repository.ITeamDao;
import com.founder.rhip.fds.repository.ITeamMemberDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("doctorService")
public class DoctorServiceImpl extends AbstractService implements DoctorService {

	@Resource(name = "doctorDao")
	private IDoctorDao doctorDao;
	@Resource(name = "teamMemberDao")
	private ITeamMemberDao teamMemberDao;
	@Resource(name = "teamDao")
	private ITeamDao teamDao;
	@Override

	/**
	 * 根据用户名，获取医生团队信息
	 * @param userName
	 * @return
	 */
	public DoctorTeamInfo getDoctorTeam(String userName) {
		Assert.notNull(userName,"用户名不能为空");
		DoctorTeamInfo doctorTeamInfo = new DoctorTeamInfo();
		Doctor doctor = doctorDao.get(new Criteria("userName",userName));
		doctorTeamInfo.setDoctor(doctor);
		if(ObjectUtil.isNotEmpty(doctor)){
			Criteria criteriaTeamMember = new Criteria("doctorId",doctor.getId());
			criteriaTeamMember.add("valid", FDSConstants.VALID_1);
			TeamMember teamMember = teamMemberDao.get(criteriaTeamMember);
			if (ObjectUtil.isNotEmpty(teamMember)) {
				if ("1".equals(teamMember.getTeamLeaderFlag())) {
					doctorTeamInfo.setLeader(true);
				} else {
					doctorTeamInfo.setLeader(false);
				}
				Criteria criteriaTeam = new Criteria("teamCode",teamMember.getTeamCode());
				criteriaTeam.add("valid",FDSConstants.VALID_1);
				Team team = teamDao.get(criteriaTeam);
				doctorTeamInfo.setTeam(team);
			}
		}
		return doctorTeamInfo;
	}

	@Override
	public Doctor getDoctor(Long doctorId) {
		return doctorDao.get(doctorId);
	}

	@Override
	public Doctor getDoctor(Criteria criteria) {
		return doctorDao.get(criteria);
	}

	@Override
	public Doctor getDoctor(String idcard) {
		Criteria criteria = new Criteria();
		criteria.add("idCard",idcard);
		return doctorDao.get(criteria);
	}

	@Override
	public List<Team> getTeamList(String idcard) {
		List<Team> teamList = new ArrayList<>();
		List<TeamMember> teamMembers = teamMemberDao.getList(new Criteria("doctorIdCard",idcard));
		for(TeamMember teamMember:teamMembers){
			Team team = teamDao.get(new Criteria("teamCode",teamMember.getTeamCode()));
			if(ObjectUtil.isNotEmpty(team)){
				teamList.add(team);
			}
		}
		return teamList;
	}

	@Override
	public Team getTeam(Criteria criteria) {
		return teamDao.get(criteria);
	}
}
