package com.founder.rhip.ph.service.oh;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.oh.OhCautionAlarm;
import com.founder.rhip.ehr.entity.control.oh.OhDoseDetection;
import com.founder.rhip.ehr.entity.control.oh.OhHospitalInfo;
import com.founder.rhip.ehr.entity.control.oh.OhMachineRoom;
import com.founder.rhip.ehr.entity.control.oh.OhPersonalDose;
import com.founder.rhip.ehr.entity.control.oh.OhProtectiveEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalApparatus;
import com.founder.rhip.ehr.entity.control.oh.OhRadiologicalPostion;
import com.founder.rhip.ehr.entity.control.oh.OhTraining;
import com.founder.rhip.ehr.entity.control.oh.OhWorkload;

public interface IRadiologicalProtectionReportService {
	//医院基本情况====================================================================
	PageList<OhHospitalInfo> searchOhHospitalInfoList(Page page,Criteria criteria);
	OhHospitalInfo searchOhHospitalInfo(Criteria criteria);
	int addOhHospitalInfo(OhHospitalInfo ohHospitalInfo);
	int deleteOhHospitalInfo(String isDelete,Criteria criteria);
	int updateOhHospitalInfo(OhHospitalInfo ohHospitalInfo);
	int checkOhHospitalInfo(String verifier,String verifyState,Criteria criteria);
	//医院放射设备情况================================================================
	PageList<OhRadiologicalApparatus> searchOhRadiologicalApparatusList(Page page,Criteria criteria);
	OhRadiologicalApparatus searchOhRadiologicalApparatus(Criteria criteria);
	int addOhRadiologicalApparatus(OhRadiologicalApparatus ohRadiologicalApparatus);
	int deleteOhRadiologicalApparatus(String isDelete,Criteria criteria);
	int updateOhRadiologicalApparatus(OhRadiologicalApparatus ohRadiologicalApparatus);
	//放射防护情况===============================================================
	//医院放射科位置布置情况
	OhRadiologicalPostion searchOhRadiologicalPostion(Criteria criteria);
	int addOhRadiologicalPostion(OhRadiologicalPostion ohRadiologicalPostion);
	int updateOhRadiologicalPostion(OhRadiologicalPostion ohRadiologicalPostion);
	//警示标识/报警仪
	PageList<OhCautionAlarm> searchOhCautionAlarmList(Page page,Criteria criteria);
	OhCautionAlarm searchOhCautionAlarm(Criteria criteria);
	int addOhCautionAlarm(OhCautionAlarm ohCautionAlarm);
	int deleteOhCautionAlarm(String isDelete,Criteria criteria);
	int updateOhCautionAlarm(OhCautionAlarm ohCautionAlarm);
	//放射科场所
	Double getSumArea(Criteria criteria);
	Double getMachineRoomArea(Criteria criteria);
	Double getOtherArea(Criteria criteria);
	PageList<OhMachineRoom> searchOhMachineRoomList(Page page,Criteria criteria);
	OhMachineRoom searchOhMachineRoom(Criteria criteria);
	int addOhMachineRoom(OhMachineRoom ohMachineRoom);
	int deleteOhMachineRoom(String isDelete,Criteria criteria);
	int updateOhMachineRoom(OhMachineRoom ohMachineRoom);
	//个人防护用品==========================================================================================================
	PageList<OhProtectiveEquipment> searchOhProtectiveEquipmentList(Page page,Criteria criteria);
	OhProtectiveEquipment searchOhProtectiveEquipment(Criteria criteria);
	int addOhProtectiveEquipment(OhProtectiveEquipment ohProtectiveEquipment);
	int deleteOhProtectiveEquipment(String isDelete,Criteria criteria);
	int updateOhProtectiveEquipment(OhProtectiveEquipment ohProtectiveEquipment);
	//个人剂量档案=======================================================================
	PageList<OhPersonalDose> searchOhPersonalDoseList(Page page,Criteria criteria);
	OhPersonalDose searchOhPersonalDose(Criteria criteria);
	int addOhPersonalDose(OhPersonalDose ohPersonalDose);
	int deleteOhPersonalDose(String isDelete,Criteria criteria);
	int updateOhPersonalDose(OhPersonalDose ohPersonalDose);
	//放射工作人员个人剂量和健康监护档案==============================================
	//个人剂量检测结果
	PageList<OhDoseDetection> searchOhDoseDetectionList(Page page,Criteria criteria);
	OhDoseDetection searchOhDoseDetection(Criteria criteria);
	int addOhDoseDetection(OhDoseDetection ohDoseDetection);
	int deleteOhDoseDetection(String isDelete,Criteria criteria);
	int updateOhDoseDetection(OhDoseDetection ohDoseDetection);
	//放射工作人员年工作量
	PageList<OhWorkload> searchOhWorkload(Page page,Criteria criteria);
	OhWorkload searchOhWorkload(Criteria criteria);
	int addOhWorkload(OhWorkload ohWorkload);
	int deleteOhWorkload(String isDelete,Criteria criteria);
	int updateOhWorkload(OhWorkload ohWorkload);
	//培训情况
	PageList<OhTraining> searchOhTraining(Page page,Criteria criteria);
	OhTraining searchOhTraining(Criteria criteria);
	int addOhTraining(OhTraining ohTraining);
	int deleteOhTraining(String isDelete,Criteria criteria);
	int updateOhTraining(OhTraining ohTraining);

}
