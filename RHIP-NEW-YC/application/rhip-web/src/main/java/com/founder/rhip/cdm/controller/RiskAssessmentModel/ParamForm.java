package com.founder.rhip.cdm.controller.RiskAssessmentModel;

import com.founder.rhip.ehr.entity.basic.StandParameterCfg;

import java.util.List;

public class ParamForm {
	private List<StandParameterCfg> cfgs;

	public List<StandParameterCfg> getCfgs() {
		return cfgs;
	}

	public void setCfgs(List<StandParameterCfg> cfgs) {
		this.cfgs = cfgs;
	}
}
