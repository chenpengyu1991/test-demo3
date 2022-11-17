package com.founder.rhip.fds.common;

import com.founder.rhip.fds.entity.Doctor;
import com.founder.rhip.fds.entity.Team;

public class DoctorTeamInfo {

    private Doctor doctor;

    private Team team;

    private boolean leader;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isLeader() {
        return leader;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }
}
