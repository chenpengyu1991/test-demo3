package com.founder.rhip.idm.controller.form;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.special.ListCm;
import com.founder.rhip.idm.common.ListCmStatus;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.List;

/**
 * 麻风 个案
 * @author Jiang Haiying
 *
 */
public class ListCmForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idRough;

	private Long idmIdListCm;

	/*眶上左*/
	private String eyeLeftRough;

	/*眶上右*/
	private String eyeRightRough;

	/*耳大左*/
	private String earLeftRough;

	/*耳大右*/
	private String earRightRough;

	/*尺左*/
	private String ruleLeftRough;

	/*尺右*/
	private String ruleRightRough;

	/*桡左*/
	private String oarLeftRough;

	/*桡右*/
	private String oarRightRough;

	/*正中左*/
	private String centerLeftRough;

	/*正中右*/
	private String centerRightRough;

	/*腓总左*/
	private String peronealLeftRough;

	/*腓总右*/
	private String peronealRightRough;

	/*胫左*/
	private String legLeftRough;

	/*胫右*/
	private String legRightRough;

	/*其他左*/
	private String otherLeftRough;

	/*其他右*/
	private String otherRightRough;

	private Long idHard;
	
	/*眶上左*/
	private String eyeLeftHard;

	/*眶上右*/
	private String eyeRightHard;

	/*耳大左*/
	private String earLeftHard;

	/*耳大右*/
	private String earRightHard;

	/*尺左*/
	private String ruleLeftHard;

	/*尺右*/
	private String ruleRightHard;

	/*桡左*/
	private String oarLeftHard;

	/*桡右*/
	private String oarRightHard;

	/*正中左*/
	private String centerLeftHard;

	/*正中右*/
	private String centerRightHard;

	/*腓总左*/
	private String peronealLeftHard;

	/*腓总右*/
	private String peronealRightHard;

	/*胫左*/
	private String legLeftHard;

	/*胫右*/
	private String legRightHard;

	/*其他左*/
	private String otherLeftHard;

	/*其他右*/
	private String otherRightHard;
	
	private Long idTouch;

	/*眶上左*/
	private String eyeLeftTouch;

	/*眶上右*/
	private String eyeRightTouch;

	/*耳大左*/
	private String earLeftTouch;

	/*耳大右*/
	private String earRightTouch;

	/*尺左*/
	private String ruleLeftTouch;

	/*尺右*/
	private String ruleRightTouch;

	/*桡左*/
	private String oarLeftTouch;

	/*桡右*/
	private String oarRightTouch;

	/*正中左*/
	private String centerLeftTouch;

	/*正中右*/
	private String centerRightTouch;

	/*腓总左*/
	private String peronealLeftTouch;

	/*腓总右*/
	private String peronealRightTouch;

	/*胫左*/
	private String legLeftTouch;

	/*胫右*/
	private String legRightTouch;

	/*其他左*/
	private String otherLeftTouch;

	/*其他右*/
	private String otherRightTouch;

	public Long getIdRough() {
		return idRough;
	}

	public void setIdRough(Long idRough) {
		this.idRough = idRough;
	}
	public Long getIdmIdListCm() {
		return idmIdListCm;
	}

	public void setIdmIdListCm(Long idmIdListCm) {
		this.idmIdListCm = idmIdListCm;
	}

	public String getEyeLeftRough() {
		return eyeLeftRough;
	}

	public void setEyeLeftRough(String eyeLeftRough) {
		this.eyeLeftRough = eyeLeftRough;
	}

	public String getEyeRightRough() {
		return eyeRightRough;
	}

	public void setEyeRightRough(String eyeRightRough) {
		this.eyeRightRough = eyeRightRough;
	}

	public String getEarLeftRough() {
		return earLeftRough;
	}

	public void setEarLeftRough(String earLeftRough) {
		this.earLeftRough = earLeftRough;
	}

	public String getEarRightRough() {
		return earRightRough;
	}

	public void setEarRightRough(String earRightRough) {
		this.earRightRough = earRightRough;
	}

	public String getRuleLeftRough() {
		return ruleLeftRough;
	}

	public void setRuleLeftRough(String ruleLeftRough) {
		this.ruleLeftRough = ruleLeftRough;
	}

	public String getRuleRightRough() {
		return ruleRightRough;
	}

	public void setRuleRightRough(String ruleRightRough) {
		this.ruleRightRough = ruleRightRough;
	}

	public String getOarLeftRough() {
		return oarLeftRough;
	}

	public void setOarLeftRough(String oarLeftRough) {
		this.oarLeftRough = oarLeftRough;
	}

	public String getOarRightRough() {
		return oarRightRough;
	}

	public void setOarRightRough(String oarRightRough) {
		this.oarRightRough = oarRightRough;
	}

	public String getCenterLeftRough() {
		return centerLeftRough;
	}

	public void setCenterLeftRough(String centerLeftRough) {
		this.centerLeftRough = centerLeftRough;
	}

	public String getCenterRightRough() {
		return centerRightRough;
	}

	public void setCenterRightRough(String centerRightRough) {
		this.centerRightRough = centerRightRough;
	}


	public String getPeronealLeftRough() {
		return peronealLeftRough;
	}

	public void setPeronealLeftRough(String peronealLeftRough) {
		this.peronealLeftRough = peronealLeftRough;
	}

	public String getPeronealRightRough() {
		return peronealRightRough;
	}

	public void setPeronealRightRough(String peronealRightRough) {
		this.peronealRightRough = peronealRightRough;
	}

	public String getLegLeftRough() {
		return legLeftRough;
	}

	public void setLegLeftRough(String legLeftRough) {
		this.legLeftRough = legLeftRough;
	}

	public String getLegRightRough() {
		return legRightRough;
	}

	public void setLegRightRough(String legRightRough) {
		this.legRightRough = legRightRough;
	}

	public String getOtherLeftRough() {
		return otherLeftRough;
	}

	public void setOtherLeftRough(String otherLeftRough) {
		this.otherLeftRough = otherLeftRough;
	}

	public String getOtherRightRough() {
		return otherRightRough;
	}

	public void setOtherRightRough(String otherRightRough) {
		this.otherRightRough = otherRightRough;
	}

	public Long getIdHard() {
		return idHard;
	}

	public void setIdHard(Long idHard) {
		this.idHard = idHard;
	}

	public String getEyeLeftHard() {
		return eyeLeftHard;
	}

	public void setEyeLeftHard(String eyeLeftHard) {
		this.eyeLeftHard = eyeLeftHard;
	}

	public String getEyeRightHard() {
		return eyeRightHard;
	}

	public void setEyeRightHard(String eyeRightHard) {
		this.eyeRightHard = eyeRightHard;
	}

	public String getEarLeftHard() {
		return earLeftHard;
	}

	public void setEarLeftHard(String earLeftHard) {
		this.earLeftHard = earLeftHard;
	}

	public String getEarRightHard() {
		return earRightHard;
	}

	public void setEarRightHard(String earRightHard) {
		this.earRightHard = earRightHard;
	}

	public String getRuleLeftHard() {
		return ruleLeftHard;
	}

	public void setRuleLeftHard(String ruleLeftHard) {
		this.ruleLeftHard = ruleLeftHard;
	}

	public String getRuleRightHard() {
		return ruleRightHard;
	}

	public void setRuleRightHard(String ruleRightHard) {
		this.ruleRightHard = ruleRightHard;
	}

	public String getOarLeftHard() {
		return oarLeftHard;
	}

	public void setOarLeftHard(String oarLeftHard) {
		this.oarLeftHard = oarLeftHard;
	}

	public String getOarRightHard() {
		return oarRightHard;
	}

	public void setOarRightHard(String oarRightHard) {
		this.oarRightHard = oarRightHard;
	}

	public String getCenterLeftHard() {
		return centerLeftHard;
	}

	public void setCenterLeftHard(String centerLeftHard) {
		this.centerLeftHard = centerLeftHard;
	}

	public String getCenterRightHard() {
		return centerRightHard;
	}

	public void setCenterRightHard(String centerRightHard) {
		this.centerRightHard = centerRightHard;
	}

	public String getPeronealLeftHard() {
		return peronealLeftHard;
	}

	public void setPeronealLeftHard(String peronealLeftHard) {
		this.peronealLeftHard = peronealLeftHard;
	}

	public String getPeronealRightHard() {
		return peronealRightHard;
	}

	public void setPeronealRightHard(String peronealRightHard) {
		this.peronealRightHard = peronealRightHard;
	}

	public String getLegLeftHard() {
		return legLeftHard;
	}

	public void setLegLeftHard(String legLeftHard) {
		this.legLeftHard = legLeftHard;
	}

	public String getLegRightHard() {
		return legRightHard;
	}

	public void setLegRightHard(String legRightHard) {
		this.legRightHard = legRightHard;
	}

	public String getOtherLeftHard() {
		return otherLeftHard;
	}

	public void setOtherLeftHard(String otherLeftHard) {
		this.otherLeftHard = otherLeftHard;
	}

	public String getOtherRightHard() {
		return otherRightHard;
	}

	public void setOtherRightHard(String otherRightHard) {
		this.otherRightHard = otherRightHard;
	}

	public Long getIdTouch() {
		return idTouch;
	}

	public void setIdTouch(Long idTouch) {
		this.idTouch = idTouch;
	}

	public String getEyeLeftTouch() {
		return eyeLeftTouch;
	}

	public void setEyeLeftTouch(String eyeLeftTouch) {
		this.eyeLeftTouch = eyeLeftTouch;
	}

	public String getEyeRightTouch() {
		return eyeRightTouch;
	}

	public void setEyeRightTouch(String eyeRightTouch) {
		this.eyeRightTouch = eyeRightTouch;
	}

	public String getEarLeftTouch() {
		return earLeftTouch;
	}

	public void setEarLeftTouch(String earLeftTouch) {
		this.earLeftTouch = earLeftTouch;
	}

	public String getEarRightTouch() {
		return earRightTouch;
	}

	public void setEarRightTouch(String earRightTouch) {
		this.earRightTouch = earRightTouch;
	}

	public String getRuleLeftTouch() {
		return ruleLeftTouch;
	}

	public void setRuleLeftTouch(String ruleLeftTouch) {
		this.ruleLeftTouch = ruleLeftTouch;
	}

	public String getRuleRightTouch() {
		return ruleRightTouch;
	}

	public void setRuleRightTouch(String ruleRightTouch) {
		this.ruleRightTouch = ruleRightTouch;
	}

	public String getOarLeftTouch() {
		return oarLeftTouch;
	}

	public void setOarLeftTouch(String oarLeftTouch) {
		this.oarLeftTouch = oarLeftTouch;
	}

	public String getOarRightTouch() {
		return oarRightTouch;
	}

	public void setOarRightTouch(String oarRightTouch) {
		this.oarRightTouch = oarRightTouch;
	}

	public String getCenterLeftTouch() {
		return centerLeftTouch;
	}

	public void setCenterLeftTouch(String centerLeftTouch) {
		this.centerLeftTouch = centerLeftTouch;
	}

	public String getCenterRightTouch() {
		return centerRightTouch;
	}

	public void setCenterRightTouch(String centerRightTouch) {
		this.centerRightTouch = centerRightTouch;
	}

	public String getPeronealLeftTouch() {
		return peronealLeftTouch;
	}

	public void setPeronealLeftTouch(String peronealLeftTouch) {
		this.peronealLeftTouch = peronealLeftTouch;
	}

	public String getPeronealRightTouch() {
		return peronealRightTouch;
	}

	public void setPeronealRightTouch(String peronealRightTouch) {
		this.peronealRightTouch = peronealRightTouch;
	}

	public String getLegLeftTouch() {
		return legLeftTouch;
	}

	public void setLegLeftTouch(String legLeftTouch) {
		this.legLeftTouch = legLeftTouch;
	}

	public String getLegRightTouch() {
		return legRightTouch;
	}

	public void setLegRightTouch(String legRightTouch) {
		this.legRightTouch = legRightTouch;
	}

	public String getOtherLeftTouch() {
		return otherLeftTouch;
	}

	public void setOtherLeftTouch(String otherLeftTouch) {
		this.otherLeftTouch = otherLeftTouch;
	}

	public String getOtherRightTouch() {
		return otherRightTouch;
	}

	public void setOtherRightTouch(String otherRightTouch) {
		this.otherRightTouch = otherRightTouch;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public ListCmForm getListCmForm(List<ListCm> listCms) {
		ListCmForm listCmForm = new ListCmForm();
		if(ObjectUtil.isNullOrEmpty(listCms)) {
			return listCmForm;
		}
		
		for(ListCm listCm : listCms) {
			if(StringUtils.equals(listCm.getDegreeType(), ListCmStatus.ROUGH.getValue())) {
				listCmForm.setIdRough(listCm.getId());
				listCmForm.setIdmIdListCm(listCm.getIdmId());
				listCmForm.setEyeLeftRough(listCm.getEyeLeft());
				listCmForm.setEyeRightRough(listCm.getEyeRight());
				listCmForm.setEarLeftRough(listCm.getEarLeft());
				listCmForm.setEarRightRough(listCm.getEarRight());
				listCmForm.setRuleLeftRough(listCm.getRuleLeft());
				listCmForm.setRuleRightRough(listCm.getRuleRight());
				listCmForm.setOarLeftRough(listCm.getOarLeft());
				listCmForm.setOarRightRough(listCm.getOarRight());
				listCmForm.setCenterLeftRough(listCm.getCenterLeft());
				listCmForm.setCenterRightRough(listCm.getCenterRight());
				listCmForm.setPeronealLeftRough(listCm.getPeronealLeft());
				listCmForm.setPeronealRightRough(listCm.getPeronealRight());
				listCmForm.setLegLeftRough(listCm.getLegLeft());
				listCmForm.setLegRightRough(listCm.getLegRight());
				listCmForm.setOtherLeftRough(listCm.getOtherLeft());
				listCmForm.setOtherRightRough(listCm.getOtherRight());
			} else if(StringUtils.equals(listCm.getDegreeType(), ListCmStatus.HARD.getValue())) {
				listCmForm.setIdRough(listCm.getId());
				listCmForm.setIdmIdListCm(listCm.getIdmId());
				listCmForm.setEyeLeftHard(listCm.getEyeLeft());
				listCmForm.setEyeRightHard(listCm.getEyeRight());
				listCmForm.setEarLeftHard(listCm.getEarLeft());
				listCmForm.setEarRightHard(listCm.getEarRight());
				listCmForm.setRuleLeftHard(listCm.getRuleLeft());
				listCmForm.setRuleRightHard(listCm.getRuleRight());
				listCmForm.setOarLeftHard(listCm.getOarLeft());
				listCmForm.setOarRightHard(listCm.getOarRight());
				listCmForm.setCenterLeftHard(listCm.getCenterLeft());
				listCmForm.setCenterRightHard(listCm.getCenterRight());
				listCmForm.setPeronealLeftHard(listCm.getPeronealLeft());
				listCmForm.setPeronealRightHard(listCm.getPeronealRight());
				listCmForm.setLegLeftHard(listCm.getLegLeft());
				listCmForm.setLegRightHard(listCm.getLegRight());
				listCmForm.setOtherLeftHard(listCm.getOtherLeft());
				listCmForm.setOtherRightHard(listCm.getOtherRight());
			} else if(StringUtils.equals(listCm.getDegreeType(), ListCmStatus.TOUCH.getValue())) {
				listCmForm.setIdTouch(listCmForm.getIdTouch());
				listCmForm.setIdmIdListCm(listCm.getIdmId());
				listCmForm.setEyeLeftTouch(listCm.getEyeLeft());
				listCmForm.setEyeRightTouch(listCm.getEyeRight());
				listCmForm.setEarLeftTouch(listCm.getEarLeft());
				listCmForm.setEarRightTouch(listCm.getEarRight());
				listCmForm.setRuleLeftTouch(listCm.getRuleLeft());
				listCmForm.setRuleRightTouch(listCm.getRuleRight());
				listCmForm.setOarLeftTouch(listCm.getOarLeft());
				listCmForm.setOarRightTouch(listCm.getOarRight());
				listCmForm.setCenterLeftTouch(listCm.getCenterLeft());
				listCmForm.setCenterRightTouch(listCm.getCenterRight());
				listCmForm.setPeronealLeftTouch(listCm.getPeronealLeft());
				listCmForm.setPeronealRightTouch(listCm.getPeronealRight());
				listCmForm.setLegLeftTouch(listCm.getLegLeft());
				listCmForm.setLegRightTouch(listCm.getLegRight());
				listCmForm.setOtherLeftTouch(listCm.getOtherLeft());
				listCmForm.setOtherRightTouch(listCm.getOtherRight());
			}
		}
		
		return listCmForm;
	}
}