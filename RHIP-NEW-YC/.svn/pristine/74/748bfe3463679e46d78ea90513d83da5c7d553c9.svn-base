package com.founder.rhip.ehr.dto.mhm;


import java.io.Serializable;
import java.util.Date;

public class MhmStatisticsReportDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /*查询月份*/
    private String amountFlag;  
    
    /*查询月份*/
    private Date reportMonth;    

    /*管理单位－镇 下属中心数量 */
    private Integer townCenterCount = 0;

    /*管理单位－镇*/
    private String managementTown;
 
    /*管理单位－中心*/
    private String managementCenter;
    
    /*管理单位－站*/
    private String managementStation;
    
    /*病人总数-重性病累计建档*/
    private Integer totalCumulativeFile = 0;    

    /*病人总数-重性病人数*/
    private Integer totalNumSevere = 0;
    
    /*病人总数-重性病人数(贫困)*/
    private Integer totalNumSeverePoor = 0;

    /*病人总数-重性病人数(非贫困)*/
    private Integer totalNumSevereNotPoor = 0;
    
    /*病人总数-普通病人数*/
    private Integer totalNumOrdinary = 0;
    
    /*病人增减数-重性病人增加*/
    private Integer raiseSevere = 0;
    
    /*病人增减数-重性病人减少*/
    private Integer decreaseSevere = 0; 
    
    /*病人增减数-普通病人增加*/
    private Integer raiseOrdinary = 0;
    
    /*病人增减数-普通病人减少*/
    private Integer decreaseOrdinary = 0;    
    
    /*免费发药-免费发药人数(重性)*/
    private Integer freeDispensingSevere = 0;

    /*免费发药-免费发药人数(非重性)*/
    private Integer freeDispensingOrdinary = 0;
    
    /*免费发药-实际吃药人数(重性)*/
    private Integer realityMedicineSevere = 0;  

    /*免费发药-实际吃药人数(非重性)*/
    private Integer realityMedicineOrdinary = 0;
    
    /*随访次数-重性病人数*/
    private Integer followupSevere = 0;
    
    /*随访次数-网络直报随访人数*/
    private Integer followupNetwork = 0;   

    /*随访次数-普通病人数*/
    private Integer followupOrdinary = 0; 

    /*化验检查-人数*/
    private Integer checkNumber = 0; 
    
    /*化验检查-心电*/
    private Integer checkEcg = 0; 
    
    /*化验检查-B超*/
    private Integer checkTypeB = 0; 
    
    /*化验检查-肝功能*/
    private Integer checkLiver = 0; 
    
    /*化验检查-血常规*/
    private Integer checkBloodTests = 0; 
    
    /*化验检查-其他检查*/
    private Integer checkOther = 0; 
    
    /*宣传培训-培训人数*/
    private Integer trainingNumber = 0; 
    
    /*宣传培训-培训次数*/
    private Integer trainingTime = 0;
    
    /*查询开始时间*/
    private String startDate;
    /*查询结束时间*/
    private String endDate;
    
    /**
     * 累加
     *
     * @param dto
     * @author Ye jianfei
     */
    public void amout(MhmStatisticsReportDto dto){
    	totalCumulativeFile += dto.getTotalCumulativeFile();
    	totalNumSevere += dto.getTotalNumSevere();
    	totalNumSeverePoor += dto.getTotalNumSeverePoor();
    	totalNumSevereNotPoor += dto.getTotalNumSevereNotPoor();
        totalNumOrdinary += dto.getTotalNumOrdinary();
        raiseSevere += dto.getRaiseSevere();
        decreaseSevere += dto.getDecreaseSevere(); 
        raiseOrdinary += dto.getRaiseOrdinary();
        decreaseOrdinary += dto.getDecreaseOrdinary();    
        freeDispensingSevere += dto.getFreeDispensingSevere();
        freeDispensingOrdinary += dto.getFreeDispensingOrdinary();
        realityMedicineSevere += dto.getRealityMedicineSevere();  
        realityMedicineOrdinary += dto.getRealityMedicineOrdinary();
        followupSevere += dto.getFollowupSevere();
        followupNetwork += dto.getFollowupNetwork();   
        followupOrdinary += dto.getFollowupOrdinary(); 
        checkNumber += dto.getCheckNumber(); 
        checkEcg += dto.getCheckEcg(); 
        checkTypeB += dto.getCheckTypeB(); 
        checkLiver += dto.getCheckLiver(); 
        checkBloodTests += dto.getCheckBloodTests(); 
        checkOther += dto.getCheckOther(); 
        trainingNumber += dto.getTrainingNumber(); 
        trainingTime += dto.getTrainingTime();    	
    }
	
	public String getManagementTown() {
		return managementTown;
	}

	
	public void setManagementTown(String managementTown) {
		this.managementTown = managementTown;
	}

	
	public String getManagementCenter() {
		return managementCenter;
	}

	
	public void setManagementCenter(String managementCenter) {
		this.managementCenter = managementCenter;
	}

	
	public String getManagementStation() {
		return managementStation;
	}

	
	public void setManagementStation(String managementStation) {
		this.managementStation = managementStation;
	}

	
	public Integer getTotalNumOrdinary() {
		return totalNumOrdinary;
	}

	
	public void setTotalNumOrdinary(Integer totalNumOrdinary) {
		this.totalNumOrdinary = totalNumOrdinary;
	}

	
	public Integer getRaiseSevere() {
		return raiseSevere;
	}

	
	public void setRaiseSevere(Integer raiseSevere) {
		this.raiseSevere = raiseSevere;
	}

	
	public Integer getDecreaseSevere() {
		return decreaseSevere;
	}

	
	public void setDecreaseSevere(Integer decreaseSevere) {
		this.decreaseSevere = decreaseSevere;
	}

	
	public Integer getRaiseOrdinary() {
		return raiseOrdinary;
	}

	
	public void setRaiseOrdinary(Integer raiseOrdinary) {
		this.raiseOrdinary = raiseOrdinary;
	}

	
	public Integer getDecreaseOrdinary() {
		return decreaseOrdinary;
	}

	
	public void setDecreaseOrdinary(Integer decreaseOrdinary) {
		this.decreaseOrdinary = decreaseOrdinary;
	}

	
	public Integer getFollowupSevere() {
		return followupSevere;
	}

	
	public void setFollowupSevere(Integer followupSevere) {
		this.followupSevere = followupSevere;
	}

	
	public Integer getFollowupNetwork() {
		return followupNetwork;
	}

	
	public void setFollowupNetwork(Integer followupNetwork) {
		this.followupNetwork = followupNetwork;
	}

	
	public Integer getFollowupOrdinary() {
		return followupOrdinary;
	}

	
	public void setFollowupOrdinary(Integer followupOrdinary) {
		this.followupOrdinary = followupOrdinary;
	}

	
	public Integer getCheckNumber() {
		return checkNumber;
	}

	
	public void setCheckNumber(Integer checkNumber) {
		this.checkNumber = checkNumber;
	}

	
	public Integer getCheckEcg() {
		return checkEcg;
	}

	
	public void setCheckEcg(Integer checkEcg) {
		this.checkEcg = checkEcg;
	}

	
	public Integer getCheckTypeB() {
		return checkTypeB;
	}

	
	public void setCheckTypeB(Integer checkTypeB) {
		this.checkTypeB = checkTypeB;
	}

	
	public Integer getCheckLiver() {
		return checkLiver;
	}

	
	public void setCheckLiver(Integer checkLiver) {
		this.checkLiver = checkLiver;
	}

	
	public Integer getCheckBloodTests() {
		return checkBloodTests;
	}

	
	public void setCheckBloodTests(Integer checkBloodTests) {
		this.checkBloodTests = checkBloodTests;
	}

	
	public Integer getCheckOther() {
		return checkOther;
	}

	
	public void setCheckOther(Integer checkOther) {
		this.checkOther = checkOther;
	}

	
	public Integer getTrainingNumber() {
		return trainingNumber;
	}

	
	public void setTrainingNumber(Integer trainingNumber) {
		this.trainingNumber = trainingNumber;
	}

	
	public Integer getTrainingTime() {
		return trainingTime;
	}

	
	public void setTrainingTime(Integer trainingTime) {
		this.trainingTime = trainingTime;
	}


	public Date getReportMonth() {
		return reportMonth;
	}


	public void setReportMonth(Date reportMonth) {
		this.reportMonth = reportMonth;
	}


	public String getAmountFlag() {
		return amountFlag;
	}


	public void setAmountFlag(String amountFlag) {
		this.amountFlag = amountFlag;
	}

	public Integer getTownCenterCount() {
		return townCenterCount;
	}

	public void setTownCenterCount(Integer townCenterCount) {
		this.townCenterCount = townCenterCount;
	}

	public Integer getTotalNumSeverePoor() {
		return totalNumSeverePoor;
	}

	public void setTotalNumSeverePoor(Integer totalNumSeverePoor) {
		this.totalNumSeverePoor = totalNumSeverePoor;
	}

	public Integer getTotalNumSevereNotPoor() {
		return totalNumSevereNotPoor;
	}

	public void setTotalNumSevereNotPoor(Integer totalNumSevereNotPoor) {
		this.totalNumSevereNotPoor = totalNumSevereNotPoor;
	}

	public Integer getFreeDispensingSevere() {
		return freeDispensingSevere;
	}

	public void setFreeDispensingSevere(Integer freeDispensingSevere) {
		this.freeDispensingSevere = freeDispensingSevere;
	}

	public Integer getFreeDispensingOrdinary() {
		return freeDispensingOrdinary;
	}

	public void setFreeDispensingOrdinary(Integer freeDispensingOrdinary) {
		this.freeDispensingOrdinary = freeDispensingOrdinary;
	}

	public Integer getRealityMedicineSevere() {
		return realityMedicineSevere;
	}

	public void setRealityMedicineSevere(Integer realityMedicineSevere) {
		this.realityMedicineSevere = realityMedicineSevere;
	}

	public Integer getRealityMedicineOrdinary() {
		return realityMedicineOrdinary;
	}

	public void setRealityMedicineOrdinary(Integer realityMedicineOrdinary) {
		this.realityMedicineOrdinary = realityMedicineOrdinary;
	}

	public Integer getTotalNumSevere() {
		return totalNumSevere;
	}

	public void setTotalNumSevere(Integer totalNumSevere) {
		this.totalNumSevere = totalNumSevere;
	}

	public Integer getTotalCumulativeFile() {
		return totalCumulativeFile;
	}

	public void setTotalCumulativeFile(Integer totalCumulativeFile) {
		this.totalCumulativeFile = totalCumulativeFile;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}