package com.founder.rhip.ehr.dto;

import java.util.ArrayList;
import java.util.List;

public class StudentExamReportDTO {
	
	/** 性别：男 */
	public static final String MALE                 = "1";
	/** 性别：女 */
	public static final String FEMALE                 = "2";
	
	private static double computer(double a, double b) {
		if (b == 0) {
			return 0;
		}
		return a / b;
	}
	
	public static class SchoolReport extends ReportDataList {
		//学校
		private String school;
		//年级
		private String grade;
		
		public String getSchool() {
			return school;
		}

		public void setSchool(String school) {
			this.school = school;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}
	}
	
	public static class ReportDataList implements IStudentExamReportData {
		
		private List<IStudentExamReportData> datas = new ArrayList<IStudentExamReportData>();
		
		public void addReportData(IStudentExamReportData data) {
			datas.add(data);
		}
		
		public List<IStudentExamReportData> getDatas() {
			return datas;
		}

		@Override
		public int getExamNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getExamNumber();
			}
			return totle;
		}

		@Override
		public int getExamNumberMale(){
			int totle = 0;
			for (IStudentExamReportData data : datas) {
					totle += data.getExamNumberMale();
			}
			return totle;
		}

		@Override
		public int getExamNumberFeMale(){
			int totle = 0;
			for (IStudentExamReportData data : datas) {
					totle += data.getExamNumberFeMale();
			}
			return totle;
		}
		
		@Override
		public int getNormalNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNormalNumber();
			}
			return totle;
		}

		@Override
		public int getOverweightNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getOverweightNumber();
			}
			return totle;
		}

		@Override
		public int getObesityNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getObesityNumber();
			}
			return totle;
		}

		@Override
		public int getSlowGrowthNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSlowGrowthNumber();
			}
			return totle;
		}

		@Override
		public int getSmallNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSmallNumber();
			}
			return totle;
		}

		@Override
		public int getModerateThinNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getModerateThinNumber();
			}
			return totle;
		}

		@Override
		public int getMildThinNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getMildThinNumber();
			}
			return totle;
		}

		@Override
		public int getMildPoorVisionNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getMildPoorVisionNumber();
			}
			return totle;
		}

		@Override
		public int getModeratePoorVisionNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getModeratePoorVisionNumber();
			}
			return totle;
		}

		@Override
		public int getSeverePoorVisionNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSeverePoorVisionNumber();
			}
			return totle;
		}

		@Override
		public int getNormalVisionLastYearNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNormalVisionLastYearNumber();
			}
			return totle;
		}

		@Override
		public int getNewPoorVisionNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNewPoorVisionNumber();
			}
			return totle;
		}

		@Override
		public int getTrachomaEyeNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getTrachomaEyeNumber();
			}
			return totle;
		}

		@Override
		public int getBabyEurodonticusNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyEurodonticusNumber();
			}
			return totle;
		}

		@Override
		public int getBabyDentalCariesNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyDentalCariesNumber();
			}
			return totle;
		}

		@Override
		public int getBabyCariesFillingNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyCariesFillingNumber();
			}
			return totle;
		}

		@Override
		public int getPermanentEurodonticusNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentEurodonticusNumber();
			}
			return totle;
		}

		@Override
		public int getPermanentDentalCariesNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentDentalCariesNumber();
			}
			return totle;
		}

		@Override
		public int getPermanentCariesFillingNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentCariesFillingNumber();
			}
			return totle;
		}

		@Override
		public int getEurodonticusNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getEurodonticusNumber();
			}
			return totle;
		}

		@Override
		public int getDentalCariesNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getDentalCariesNumber();
			}
			return totle;
		}

		@Override
		public int getCariesFillingNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getCariesFillingNumber();
			}
			return totle;
		}

		@Override
		public int getPeriodontalDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPeriodontalDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getHeartDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getHeartDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getLungDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getLungDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getSpleenDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSpleenDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getNeckDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNeckDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getLimbsDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getLimbsDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getSpineDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSpineDiseaseNumber();
			}
			return totle;
		}

		@Override
		public int getSkinDiseaseNumber() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSkinDiseaseNumber();
			}
			return totle;
		}
		
		public double getNormalPercent() {
			return computer(getNormalNumber(), getExamNumber());
		}

		public double getNormalPercentMale() {
			return computer(getNormalNumberMale(), getExamNumberMale());
		}
		
		public double getNormalPercentFeMale() {
			return computer(getNormalNumberFeMale(), getExamNumberFeMale());
		}
		
		
		public double getOverweightPercent() {
			return computer(getOverweightNumber(), getExamNumber());
		}

		public double getOverweightPercentMale() {
			return computer(getOverweightNumberMale(), getExamNumberMale());
		}
		
		public double getOverweightPercentFeMale() {
			return computer(getOverweightNumberFeMale(), getExamNumberFeMale());
		}
		
		
		public double getObesityPercent() {
			return computer(getObesityNumber(), getExamNumber());
		}
		
		public double getObesityPercentMale() {
			return computer(getObesityNumberMale(), getExamNumberMale());
		}
		
		public double getObesityPercentFeMale() {
			return computer(getObesityNumberFeMale(), getExamNumberFeMale());
		}
		
		

		public double getSlowGrowthPercent() {
			return computer(getSlowGrowthNumber(), getExamNumber());
		}
		
		public double getSlowGrowthPercentMale() {
			return computer(getSlowGrowthNumberMale(), getExamNumberMale());
		}
		
		public double getSlowGrowthPercentFeMale() {
			return computer(getSlowGrowthNumberFeMale(), getExamNumberFeMale());
		}

		
		public double getSmallPercent() {
			return computer(getSmallNumber(), getExamNumber());
		}
		
		public double getSmallPercentMale() {
			return computer(getSmallNumberMale(), getExamNumberMale());
		}
		
		public double getSmallPercentFeMale() {
			return computer(getSmallNumberFeMale(), getExamNumberFeMale());
		}

		
		public double getModerateThinPercent() {
			return computer(getModerateThinNumber(), getExamNumber());
		}
		
		public double getModerateThinPercentMale() {
			return computer(getModerateThinNumberMale(), getExamNumberMale());
		}
		
		public double getModerateThinPercentFeMale() {
			return computer(getModerateThinNumberFeMale(), getExamNumberFeMale());
		}

		public double getMildThinPercent() {
			return computer(getMildThinNumber(), getExamNumber());
		}
		
		public double getMildThinPercentMale() {
			return computer(getMildThinNumberMale(), getExamNumberMale());
		}
		
		public double getMildThinPercentFeMale() {
			return computer(getMildThinNumberFeMale(), getExamNumberFeMale());
		}

		public double getMildPoorVisionPercent() {
			return computer(getMildPoorVisionNumber(), getExamNumber());
		}
		public double getMildPoorVisionPercentMale() {
			return computer(getMildPoorVisionNumberMale(), getExamNumberMale());
		}
		public double getMildPoorVisionPercentFeMale() {
			return computer(getMildPoorVisionNumberFeMale(), getExamNumberFeMale());
		}

		public double getModeratePoorVisionPercent() {
			return computer(getModeratePoorVisionNumber(), getExamNumber());
		}
		public double getModeratePoorVisionPercentMale() {
			return computer(getModeratePoorVisionNumberMale(), getExamNumberMale());
		}
		public double getModeratePoorVisionPercentFeMale() {
			return computer(getModeratePoorVisionNumberFeMale(), getExamNumberFeMale());
		}

		public double getSeverePoorVisionPercent() {
			return computer(getSeverePoorVisionNumber(), getExamNumber());
		}
		public double getSeverePoorVisionPercentMale() {
			return computer(getSeverePoorVisionNumberMale(), getExamNumberMale());
		}
		public double getSeverePoorVisionPercentFeMale() {
			return computer(getSeverePoorVisionNumberFeMale(), getExamNumberFeMale());
		}

		public double getNewPoorVisionPercent() {
			return computer(getNewPoorVisionNumber(), getNormalVisionLastYearNumber());
		}
		public double getNewPoorVisionPercentMale() {
			return computer(getNewPoorVisionNumberMale(), getNormalVisionLastYearNumberMale());
		}
		public double getNewPoorVisionPercentFeMale() {
			return computer(getNewPoorVisionNumberFeMale(), getNormalVisionLastYearNumberFeMale());
		}

		public double getTrachomaEyePercent() {
			return computer(getTrachomaEyeNumber(), getExamNumber());
		}
		public double getTrachomaEyePercentMale() {
			return computer(getTrachomaEyeNumberMale(), getExamNumberMale());
		}
		public double getTrachomaEyePercentFeMale() {
			return computer(getTrachomaEyeNumberFeMale(), getExamNumberFeMale());
		}
		
		public double getBabyDentalCariesPercent() {
			return computer(getBabyEurodonticusNumber(), getExamNumber());
		}
		public double getBabyDentalCariesPercentMale() {
			return computer(getBabyEurodonticusNumberMale(), getExamNumberMale());
		}
		public double getBabyDentalCariesPercentFeMale() {
			return computer(getBabyEurodonticusNumberFeMale(), getExamNumberFeMale());
		}

		public double getBabyCariesFillingPercent() {
			return computer(getBabyCariesFillingNumber(), getBabyDentalCariesNumber());
		}
		public double getBabyCariesFillingPercentMale() {
			return computer(getBabyCariesFillingNumberMale(), getBabyDentalCariesNumberMale());
		}
		public double getBabyCariesFillingPercentFeMale() {
			return computer(getBabyCariesFillingNumberFeMale(), getBabyDentalCariesNumberFeMale());
		}

		public double getBabyDentalCariesAverage() {
			return computer(getBabyDentalCariesNumber(), getExamNumber());
		}
		public double getBabyDentalCariesAverageMale() {
			return computer(getBabyDentalCariesNumberMale(), getExamNumberMale());
		}
		public double getBabyDentalCariesAverageFeMale() {
			return computer(getBabyDentalCariesNumberFeMale(), getExamNumberFeMale());
		}

		public double getPermanentDentalCariesPercent() {
			return computer(getPermanentEurodonticusNumber(), getExamNumber());
		}
		public double getPermanentDentalCariesPercentMale() {
			return computer(getPermanentEurodonticusNumberMale(), getExamNumberMale());
		}
		public double getPermanentDentalCariesPercentFeMale() {
			return computer(getPermanentEurodonticusNumberFeMale(), getExamNumberFeMale());
		}

		public double getPermanentCariesFillingPercent() {
			return computer(getPermanentCariesFillingNumber(), getPermanentDentalCariesNumber());
		}
		public double getPermanentCariesFillingPercentMale() {
			return computer(getPermanentCariesFillingNumberMale(), getPermanentDentalCariesNumberMale());
		}
		public double getPermanentCariesFillingPercentFeMale() {
			return computer(getPermanentCariesFillingNumberFeMale(), getPermanentDentalCariesNumberFeMale());
		}

		public double getPermanentDentalCariesAverage() {
			return computer(getPermanentDentalCariesNumber(), getExamNumber());
		}
		public double getPermanentDentalCariesAverageMale() {
			return computer(getPermanentDentalCariesNumberMale(), getExamNumberMale());
		}
		public double getPermanentDentalCariesAverageFeMale() {
			return computer(getPermanentDentalCariesNumberFeMale(), getExamNumberFeMale());
		}

		public double getDentalCariesPercent() {
			return computer(getEurodonticusNumber(), getExamNumber());
		}
		public double getDentalCariesPercentMale() {
			return computer(getEurodonticusNumberMale(), getExamNumberMale());
		}
		public double getDentalCariesPercentFeMale() {
			return computer(getEurodonticusNumberFeMale(), getExamNumberFeMale());
		}

		public double getCariesFillingPercent() {
			return computer(getCariesFillingNumber(), getDentalCariesNumber());
		}
		public double getCariesFillingPercentMale() {
			return computer(getCariesFillingNumberMale(), getDentalCariesNumberMale());
		}
		public double getCariesFillingPercentFeMale() {
			return computer(getCariesFillingNumberFeMale(), getDentalCariesNumberFeMale());
		}

		public double getDentalCariesAverage() {
			return computer(getDentalCariesNumber(), getExamNumber());
		}
		public double getDentalCariesAverageMale() {
			return computer(getDentalCariesNumberMale(), getExamNumberMale());
		}
		public double getDentalCariesAverageFeMale() {
			return computer(getDentalCariesNumberFeMale(), getExamNumberFeMale());
		}

		public double getPeriodontalDiseasePercent() {
			return computer(getPeriodontalDiseaseNumber(), getExamNumber());
		}
		public double getPeriodontalDiseasePercentMale() {
			return computer(getPeriodontalDiseaseNumberMale(), getExamNumberMale());
		}
		public double getPeriodontalDiseasePercentFeMale() {
			return computer(getPeriodontalDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getHeartDiseasePercent() {
			return computer(getHeartDiseaseNumber(), getExamNumber());
		}
		public double getHeartDiseasePercentMale() {
			return computer(getHeartDiseaseNumberMale(), getExamNumberMale());
		}
		public double getHeartDiseasePercentFeMale() {
			return computer(getHeartDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getLungDiseasePercent() {
			return computer(getLungDiseaseNumber(), getExamNumber());
		}
		public double getLungDiseasePercentMale() {
			return computer(getLungDiseaseNumberMale(), getExamNumberMale());
		}
		public double getLungDiseasePercentFeMale() {
			return computer(getLungDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getSpleenDiseasePercent() {
			return computer(getSpleenDiseaseNumber(), getExamNumber());
		}
		public double getSpleenDiseasePercentMale() {
			return computer(getSpleenDiseaseNumberMale(), getExamNumberMale());
		}
		public double getSpleenDiseasePercentFeMale() {
			return computer(getSpleenDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getNeckDiseasePercent() {
			return computer(getNeckDiseaseNumber(), getExamNumber());
		}
		public double getNeckDiseasePercentMale() {
			return computer(getNeckDiseaseNumberMale(), getExamNumberMale());
		}
		public double getNeckDiseasePercentFeMale() {
			return computer(getNeckDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getLimbsDiseasePercent() {
			return computer(getLimbsDiseaseNumber(), getExamNumber());
		}
		public double getLimbsDiseasePercentMale() {
			return computer(getLimbsDiseaseNumberMale(), getExamNumberMale());
		}
		public double getLimbsDiseasePercentFeMale() {
			return computer(getLimbsDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getSpineDiseasePercent() {
			return computer(getSpineDiseaseNumber(), getExamNumber());
		}
		public double getSpineDiseasePercentMale() {
			return computer(getSpineDiseaseNumberMale(), getExamNumberMale());
		}
		public double getSpineDiseasePercentFeMale() {
			return computer(getSpineDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		public double getSkinDiseasePercent() {
			return computer(getSkinDiseaseNumber(), getExamNumber());
		}
		public double getSkinDiseasePercentMale() {
			return computer(getSkinDiseaseNumberMale(), getExamNumberMale());
		}
		public double getSkinDiseasePercentFeMale() {
			return computer(getSkinDiseaseNumberFeMale(), getExamNumberFeMale());
		}

		@Override
		public int getNormalNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNormalNumberMale();
			}
			return totle;
		}

		@Override
		public int getNormalNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNormalNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getOverweightNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getOverweightNumberMale();
			}
			return totle;
		}

		@Override
		public int getOverweightNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getOverweightNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getObesityNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getObesityNumberMale();
			}
			return totle;
		}

		@Override
		public int getObesityNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getObesityNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getSlowGrowthNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSlowGrowthNumberMale();
			}
			return totle;
		}

		@Override
		public int getSlowGrowthNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSlowGrowthNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getSmallNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSmallNumberMale();
			}
			return totle;
		}

		@Override
		public int getSmallNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSmallNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getModerateThinNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getModerateThinNumberMale();
			}
			return totle;
		}

		@Override
		public int getModerateThinNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getModerateThinNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getMildThinNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getMildThinNumberMale();
			}
			return totle;
		}

		@Override
		public int getMildThinNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getMildThinNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getMildPoorVisionNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getMildPoorVisionNumberMale();
			}
			return totle;
		}

		@Override
		public int getMildPoorVisionNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getMildPoorVisionNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getModeratePoorVisionNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getModeratePoorVisionNumberMale();
			}
			return totle;
		}

		@Override
		public int getModeratePoorVisionNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getModeratePoorVisionNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getSeverePoorVisionNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSeverePoorVisionNumberMale();
			}
			return totle;
		}

		@Override
		public int getSeverePoorVisionNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSeverePoorVisionNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getNormalVisionLastYearNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNormalVisionLastYearNumberMale();
			}
			return totle;
		}

		@Override
		public int getNormalVisionLastYearNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNormalVisionLastYearNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getNewPoorVisionNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNewPoorVisionNumberMale();
			}
			return totle;
		}

		@Override
		public int getNewPoorVisionNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNewPoorVisionNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getTrachomaEyeNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getTrachomaEyeNumberMale();
			}
			return totle;
		}

		@Override
		public int getTrachomaEyeNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getTrachomaEyeNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getBabyEurodonticusNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyEurodonticusNumberMale();
			}
			return totle;
		}

		@Override
		public int getBabyEurodonticusNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyEurodonticusNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getBabyDentalCariesNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyDentalCariesNumberMale();
			}
			return totle;
		}

		@Override
		public int getBabyDentalCariesNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyDentalCariesNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getBabyCariesFillingNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyCariesFillingNumberMale();
			}
			return totle;
		}

		@Override
		public int getBabyCariesFillingNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getBabyCariesFillingNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getPermanentEurodonticusNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentEurodonticusNumberMale();
			}
			return totle;
		}

		@Override
		public int getPermanentEurodonticusNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentEurodonticusNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getPermanentDentalCariesNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentDentalCariesNumberMale();
			}
			return totle;
		}

		@Override
		public int getPermanentDentalCariesNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentDentalCariesNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getPermanentCariesFillingNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentCariesFillingNumberMale();
			}
			return totle;
		}

		@Override
		public int getPermanentCariesFillingNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPermanentCariesFillingNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getEurodonticusNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getEurodonticusNumberMale();
			}
			return totle;
		}

		@Override
		public int getEurodonticusNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getEurodonticusNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getDentalCariesNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getDentalCariesNumberMale();
			}
			return totle;
		}

		@Override
		public int getDentalCariesNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getDentalCariesNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getCariesFillingNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getCariesFillingNumberMale();
			}
			return totle;
		}

		@Override
		public int getCariesFillingNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getCariesFillingNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getPeriodontalDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPeriodontalDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getPeriodontalDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getPeriodontalDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getHeartDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getHeartDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getHeartDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getHeartDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getLungDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getLungDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getLungDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getLungDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getSpleenDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSpleenDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getSpleenDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSpleenDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getNeckDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNeckDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getNeckDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getNeckDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getLimbsDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getLimbsDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getLimbsDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getLimbsDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getSpineDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSpineDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getSpineDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSpineDiseaseNumberFeMale();
			}
			return totle;
		}

		@Override
		public int getSkinDiseaseNumberMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSkinDiseaseNumberMale();
			}
			return totle;
		}

		@Override
		public int getSkinDiseaseNumberFeMale() {
			int totle = 0;
			for (IStudentExamReportData data : datas) {
				totle += data.getSkinDiseaseNumberFeMale();
			}
			return totle;
		}
	}

	public static class ReportData implements IStudentExamReportData {
		
		//add by yejianfei 20140228
		private String gender;//性别
	
		
		private int examNumber;//体检数
		
		private int normalNumber;//正常数
		
		private int overweightNumber;//营养状况-超重数
		
		private int obesityNumber;//营养状况-肥胖数
		
		private int slowGrowthNumber;//营养状况-生长迟缓数
		
		private int smallNumber;//营养状况-身材矮小数
		
		private int moderateThinNumber;//营养状况-重中度消瘦
		
		private int mildThinNumber;//营养状况-轻度消瘦
		
		private int mildPoorVisionNumber;//视力不良-轻
		
		private int moderatePoorVisionNumber;//视力不良-中
		
		private int severePoorVisionNumber;//视力不良-重
		
		private int normalVisionLastYearNumber;//视力新发-去年正常数
		
		private int newPoorVisionNumber;//视力新发-今年低下数
		
		private int trachomaEyeNumber;//沙眼数
		
		private int babyEurodonticusNumber;//乳牙龋齿-总龋齿人数R
		
		private int babyDentalCariesNumber;//乳牙龋齿-龋齿数
		
		private int babyCariesFillingNumber;//乳牙龋齿-龋补数
		
		private int permanentEurodonticusNumber;//恒牙龋齿-总龋齿人数R
		
		private int permanentDentalCariesNumber;//恒牙龋齿-龋齿数
		
		private int permanentCariesFillingNumber;//恒牙龋齿-龋补数
		
		private int eurodonticusNumber;//恒牙龋齿（12岁）-总龋齿人数R
		
		private int dentalCariesNumber;//恒牙龋齿（12岁）-龋齿数
		
		private int cariesFillingNumber;//恒牙龋齿（12岁）-龋补数
		
		private int periodontalDiseaseNumber;//牙周病-人数
		
		private int heartDiseaseNumber;//心杂音、早博-人数
		
		private int lungDiseaseNumber;//哮鸣音-人数
		
		private int spleenDiseaseNumber;//肝脾肿大-人数
		
		private int neckDiseaseNumber;//甲状腺肿大-人数
		
		private int limbsDiseaseNumber;//淋巴结肿大-人数
		
		private int spineDiseaseNumber;//脊柱弯曲-人数
		
		private int skinDiseaseNumber;//皮肤病-人数

		public int getExamNumber() {
			return examNumber;
		}

		public void setExamNumber(int examNumber) {
			this.examNumber = examNumber;
		}
		
		public int getNormalNumber() {
			return normalNumber;
		}

		public void setNormalNumber(int normalNumber) {
			this.normalNumber = normalNumber;
		}

		public int getOverweightNumber() {
			return overweightNumber;
		}

		public void setOverweightNumber(int overweightNumber) {
			this.overweightNumber = overweightNumber;
		}
		
		public int getObesityNumber() {
			return obesityNumber;
		}

		public void setObesityNumber(int obesityNumber) {
			this.obesityNumber = obesityNumber;
		}

		public int getSlowGrowthNumber() {
			return slowGrowthNumber;
		}

		public void setSlowGrowthNumber(int slowGrowthNumber) {
			this.slowGrowthNumber = slowGrowthNumber;
		}

		public int getSmallNumber() {
			return smallNumber;
		}

		public void setSmallNumber(int smallNumber) {
			this.smallNumber = smallNumber;
		}
		
		public int getModerateThinNumber() {
			return moderateThinNumber;
		}

		public void setModerateThinNumber(int moderateThinNumber) {
			this.moderateThinNumber = moderateThinNumber;
		}
		
		public int getMildThinNumber() {
			return mildThinNumber;
		}

		public void setMildThinNumber(int mildThinNumber) {
			this.mildThinNumber = mildThinNumber;
		}

		public int getMildPoorVisionNumber() {
			return mildPoorVisionNumber;
		}

		public void setMildPoorVisionNumber(int mildPoorVisionNumber) {
			this.mildPoorVisionNumber = mildPoorVisionNumber;
		}

		public int getModeratePoorVisionNumber() {
			return moderatePoorVisionNumber;
		}

		public void setModeratePoorVisionNumber(int moderatePoorVisionNumber) {
			this.moderatePoorVisionNumber = moderatePoorVisionNumber;
		}
		
		public int getSeverePoorVisionNumber() {
			return severePoorVisionNumber;
		}

		public void setSeverePoorVisionNumber(int severePoorVisionNumber) {
			this.severePoorVisionNumber = severePoorVisionNumber;
		}
		
		public int getNormalVisionLastYearNumber() {
			return normalVisionLastYearNumber;
		}

		public void setNormalVisionLastYearNumber(int normalVisionLastYearNumber) {
			this.normalVisionLastYearNumber = normalVisionLastYearNumber;
		}

		public int getNewPoorVisionNumber() {
			return newPoorVisionNumber;
		}

		public void setNewPoorVisionNumber(int newPoorVisionNumber) {
			this.newPoorVisionNumber = newPoorVisionNumber;
		}

		public int getTrachomaEyeNumber() {
			return trachomaEyeNumber;
		}

		public void setTrachomaEyeNumber(int trachomaEyeNumber) {
			this.trachomaEyeNumber = trachomaEyeNumber;
		}

		public int getBabyEurodonticusNumber() {
			return babyEurodonticusNumber;
		}

		public void setBabyEurodonticusNumber(int babyEurodonticusNumber) {
			this.babyEurodonticusNumber = babyEurodonticusNumber;
		}

		public int getBabyDentalCariesNumber() {
			return babyDentalCariesNumber;
		}

		public void setBabyDentalCariesNumber(int babyDentalCariesNumber) {
			this.babyDentalCariesNumber = babyDentalCariesNumber;
		}

		public int getBabyCariesFillingNumber() {
			return babyCariesFillingNumber;
		}

		public void setBabyCariesFillingNumber(int babyCariesFillingNumber) {
			this.babyCariesFillingNumber = babyCariesFillingNumber;
		}

		public int getPermanentEurodonticusNumber() {
			return permanentEurodonticusNumber;
		}

		public void setPermanentEurodonticusNumber(int permanentEurodonticusNumber) {
			this.permanentEurodonticusNumber = permanentEurodonticusNumber;
		}

		public int getPermanentDentalCariesNumber() {
			return permanentDentalCariesNumber;
		}

		public void setPermanentDentalCariesNumber(int permanentDentalCariesNumber) {
			this.permanentDentalCariesNumber = permanentDentalCariesNumber;
		}

		public int getPermanentCariesFillingNumber() {
			return permanentCariesFillingNumber;
		}

		public void setPermanentCariesFillingNumber(int permanentCariesFillingNumber) {
			this.permanentCariesFillingNumber = permanentCariesFillingNumber;
		}

		public int getEurodonticusNumber() {
			return eurodonticusNumber;
		}

		public void setEurodonticusNumber(int eurodonticusNumber) {
			this.eurodonticusNumber = eurodonticusNumber;
		}

		public int getDentalCariesNumber() {
			return dentalCariesNumber;
		}

		public void setDentalCariesNumber(int dentalCariesNumber) {
			this.dentalCariesNumber = dentalCariesNumber;
		}

		public int getCariesFillingNumber() {
			return cariesFillingNumber;
		}

		public void setCariesFillingNumber(int cariesFillingNumber) {
			this.cariesFillingNumber = cariesFillingNumber;
		}

		public int getPeriodontalDiseaseNumber() {
			return periodontalDiseaseNumber;
		}

		public void setPeriodontalDiseaseNumber(int periodontalDiseaseNumber) {
			this.periodontalDiseaseNumber = periodontalDiseaseNumber;
		}

		public int getHeartDiseaseNumber() {
			return heartDiseaseNumber;
		}

		public void setHeartDiseaseNumber(int heartDiseaseNumber) {
			this.heartDiseaseNumber = heartDiseaseNumber;
		}

		public int getLungDiseaseNumber() {
			return lungDiseaseNumber;
		}

		public void setLungDiseaseNumber(int lungDiseaseNumber) {
			this.lungDiseaseNumber = lungDiseaseNumber;
		}

		public int getSpleenDiseaseNumber() {
			return spleenDiseaseNumber;
		}

		public void setSpleenDiseaseNumber(int spleenDiseaseNumber) {
			this.spleenDiseaseNumber = spleenDiseaseNumber;
		}

		public int getNeckDiseaseNumber() {
			return neckDiseaseNumber;
		}

		public void setNeckDiseaseNumber(int neckDiseaseNumber) {
			this.neckDiseaseNumber = neckDiseaseNumber;
		}
		
		public int getLimbsDiseaseNumber() {
			return limbsDiseaseNumber;
		}

		public void setLimbsDiseaseNumber(int limbsDiseaseNumber) {
			this.limbsDiseaseNumber = limbsDiseaseNumber;
		}

		public int getSpineDiseaseNumber() {
			return spineDiseaseNumber;
		}

		public void setSpineDiseaseNumber(int spineDiseaseNumber) {
			this.spineDiseaseNumber = spineDiseaseNumber;
		}

		public int getSkinDiseaseNumber() {
			return skinDiseaseNumber;
		}

		public void setSkinDiseaseNumber(int skinDiseaseNumber) {
			this.skinDiseaseNumber = skinDiseaseNumber;
		}
		
		public double getNormalPercent() {
			return computer(normalNumber, examNumber);
		}

		public double getOverweightPercent() {
			return computer(overweightNumber, examNumber);
		}

		public double getObesityPercent() {
			return computer(obesityNumber, examNumber);
		}

		public double getSlowGrowthPercent() {
			return computer(slowGrowthNumber, examNumber);
		}

		public double getSmallPercent() {
			return computer(smallNumber, examNumber);
		}

		public double getModerateThinPercent() {
			return computer(moderateThinNumber, examNumber);
		}

		public double getMildThinPercent() {
			return computer(mildThinNumber, examNumber);
		}

		public double getMildPoorVisionPercent() {
			return computer(mildPoorVisionNumber, examNumber);
		}

		public double getModeratePoorVisionPercent() {
			return computer(moderatePoorVisionNumber, examNumber);
		}

		public double getSeverePoorVisionPercent() {
			return computer(severePoorVisionNumber, examNumber);
		}

		public double getNewPoorVisionPercent() {
			return computer(newPoorVisionNumber, normalVisionLastYearNumber);
		}

		public double getTrachomaEyePercent() {
			return computer(trachomaEyeNumber, examNumber);
		}

		public double getBabyDentalCariesPercent() {
			return computer(babyEurodonticusNumber, examNumber);
		}

		public double getBabyCariesFillingPercent() {
			return computer(babyCariesFillingNumber, babyDentalCariesNumber);
		}

		public double getBabyDentalCariesAverage() {
			return computer(babyDentalCariesNumber, examNumber);
		}

		public double getPermanentDentalCariesPercent() {
			return computer(permanentEurodonticusNumber, examNumber);
		}

		public double getPermanentCariesFillingPercent() {
			return computer(permanentCariesFillingNumber, permanentDentalCariesNumber);
		}

		public double getPermanentDentalCariesAverage() {
			return computer(permanentDentalCariesNumber, examNumber);
		}

		public double getDentalCariesPercent() {
			return computer(eurodonticusNumber, examNumber);
		}

		public double getCariesFillingPercent() {
			return computer(cariesFillingNumber, dentalCariesNumber);
		}

		public double getDentalCariesAverage() {
			return computer(dentalCariesNumber, examNumber);
		}

		public double getPeriodontalDiseasePercent() {
			return computer(periodontalDiseaseNumber, examNumber);
		}

		public double getHeartDiseasePercent() {
			return computer(heartDiseaseNumber, examNumber);
		}

		public double getLungDiseasePercent() {
			return computer(lungDiseaseNumber, examNumber);
		}

		public double getSpleenDiseasePercent() {
			return computer(spleenDiseaseNumber, examNumber);
		}

		public double getNeckDiseasePercent() {
			return computer(neckDiseaseNumber, examNumber);
		}

		public double getLimbsDiseasePercent() {
			return computer(limbsDiseaseNumber, examNumber);
		}

		public double getSpineDiseasePercent() {
			return computer(spineDiseaseNumber, examNumber);
		}

		public double getSkinDiseasePercent() {
			return computer(skinDiseaseNumber, examNumber);
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getExamNumberMale() {
			if(gender.equals(MALE)){
				return examNumber;
			}else{
				return 0;
			}
		}

		public int getExamNumberFeMale() {
			if(gender.equals(FEMALE)){
				return examNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNormalNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNormalNumberMale() {
			if(gender.equals(MALE)){
				return normalNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNormalNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNormalNumberFeMale() {
			if(gender.equals(FEMALE)){
				return normalNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getOverweightNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getOverweightNumberMale() {
			if(gender.equals(MALE)){
				return overweightNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getOverweightNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getOverweightNumberFeMale() {
			if(gender.equals(FEMALE)){
				return overweightNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getObesityNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getObesityNumberMale() {
			if(gender.equals(MALE)){
				return obesityNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getObesityNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getObesityNumberFeMale() {
			if(gender.equals(FEMALE)){
				return obesityNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSlowGrowthNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSlowGrowthNumberMale() {
			if(gender.equals(MALE)){
				return slowGrowthNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSlowGrowthNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSlowGrowthNumberFeMale() {
			if(gender.equals(FEMALE)){
				return slowGrowthNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSmallNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSmallNumberMale() {
			if(gender.equals(MALE)){
				return smallNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSmallNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSmallNumberFeMale() {
			if(gender.equals(FEMALE)){
				return smallNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModerateThinNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getModerateThinNumberMale() {
			if(gender.equals(MALE)){
				return moderateThinNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModerateThinNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getModerateThinNumberFeMale() {
			if(gender.equals(FEMALE)){
				return moderateThinNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildThinNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getMildThinNumberMale() {
			if(gender.equals(MALE)){
				return mildThinNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildThinNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getMildThinNumberFeMale() {
			if(gender.equals(FEMALE)){
				return mildThinNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildPoorVisionNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getMildPoorVisionNumberMale() {
			if(gender.equals(MALE)){
				return mildPoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildPoorVisionNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getMildPoorVisionNumberFeMale() {
			if(gender.equals(FEMALE)){
				return mildPoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModeratePoorVisionNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getModeratePoorVisionNumberMale() {
			if(gender.equals(MALE)){
				return moderatePoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModeratePoorVisionNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getModeratePoorVisionNumberFeMale() {
			if(gender.equals(FEMALE)){
				return moderatePoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSeverePoorVisionNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSeverePoorVisionNumberMale() {
			if(gender.equals(MALE)){
				return severePoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSeverePoorVisionNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSeverePoorVisionNumberFeMale() {
			if(gender.equals(FEMALE)){
				return severePoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNormalVisionLastYearNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNormalVisionLastYearNumberMale() {
			if(gender.equals(MALE)){
				return normalVisionLastYearNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNormalVisionLastYearNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNormalVisionLastYearNumberFeMale() {
			if(gender.equals(FEMALE)){
				return normalVisionLastYearNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNewPoorVisionNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNewPoorVisionNumberMale() {
			if(gender.equals(MALE)){
				return newPoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNewPoorVisionNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNewPoorVisionNumberFeMale() {
			if(gender.equals(FEMALE)){
				return newPoorVisionNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getTrachomaEyeNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getTrachomaEyeNumberMale() {
			if(gender.equals(MALE)){
				return trachomaEyeNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getTrachomaEyeNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getTrachomaEyeNumberFeMale() {
			if(gender.equals(FEMALE)){
				return trachomaEyeNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyEurodonticusNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getBabyEurodonticusNumberMale() {
			if(gender.equals(MALE)){
				return babyEurodonticusNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyEurodonticusNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getBabyEurodonticusNumberFeMale() {
			if(gender.equals(FEMALE)){
				return babyEurodonticusNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyDentalCariesNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getBabyDentalCariesNumberMale() {
			if(gender.equals(MALE)){
				return babyDentalCariesNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyDentalCariesNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getBabyDentalCariesNumberFeMale() {
			if(gender.equals(FEMALE)){
				return babyDentalCariesNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyCariesFillingNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getBabyCariesFillingNumberMale() {
			if(gender.equals(MALE)){
				return babyCariesFillingNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyCariesFillingNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getBabyCariesFillingNumberFeMale() {
			if(gender.equals(FEMALE)){
				return babyCariesFillingNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentEurodonticusNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPermanentEurodonticusNumberMale() {
			if(gender.equals(MALE)){
				return permanentEurodonticusNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentEurodonticusNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPermanentEurodonticusNumberFeMale() {
			if(gender.equals(FEMALE)){
				return permanentEurodonticusNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentDentalCariesNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPermanentDentalCariesNumberMale() {
			if(gender.equals(MALE)){
				return permanentDentalCariesNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentDentalCariesNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPermanentDentalCariesNumberFeMale() {
			if(gender.equals(FEMALE)){
				return permanentDentalCariesNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentCariesFillingNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPermanentCariesFillingNumberMale() {
			if(gender.equals(MALE)){
				return permanentCariesFillingNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentCariesFillingNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPermanentCariesFillingNumberFeMale() {
			if(gender.equals(FEMALE)){
				return permanentCariesFillingNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getEurodonticusNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getEurodonticusNumberMale() {
			if(gender.equals(MALE)){
				return eurodonticusNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getEurodonticusNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getEurodonticusNumberFeMale() {
			if(gender.equals(FEMALE)){
				return eurodonticusNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getDentalCariesNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getDentalCariesNumberMale() {
			if(gender.equals(MALE)){
				return dentalCariesNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getDentalCariesNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getDentalCariesNumberFeMale() {
			if(gender.equals(FEMALE)){
				return dentalCariesNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getCariesFillingNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getCariesFillingNumberMale() {
			if(gender.equals(MALE)){
				return cariesFillingNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getCariesFillingNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getCariesFillingNumberFeMale() {
			if(gender.equals(FEMALE)){
				return cariesFillingNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPeriodontalDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPeriodontalDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return periodontalDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPeriodontalDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getPeriodontalDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return periodontalDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getHeartDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getHeartDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return heartDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getHeartDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getHeartDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return heartDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLungDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getLungDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return lungDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLungDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getLungDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return lungDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpleenDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSpleenDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return spleenDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpleenDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSpleenDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return spleenDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNeckDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNeckDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return neckDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNeckDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getNeckDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return neckDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLimbsDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getLimbsDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return limbsDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLimbsDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getLimbsDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return limbsDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpineDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSpineDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return spineDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpineDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSpineDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return spineDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSkinDiseaseNumberMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSkinDiseaseNumberMale() {
			if(gender.equals(MALE)){
				return skinDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSkinDiseaseNumberFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public int getSkinDiseaseNumberFeMale() {
			if(gender.equals(FEMALE)){
				return skinDiseaseNumber;
			}else{
				return 0;
			}
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNormalPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getNormalPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNormalPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getNormalPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getOverweightPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getOverweightPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getOverweightPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getOverweightPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getObesityPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getObesityPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getObesityPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getObesityPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSlowGrowthPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSlowGrowthPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSlowGrowthPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSlowGrowthPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSmallPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSmallPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSmallPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSmallPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModerateThinPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getModerateThinPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModerateThinPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getModerateThinPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildThinPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getMildThinPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildThinPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getMildThinPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildPoorVisionPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getMildPoorVisionPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getMildPoorVisionPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getMildPoorVisionPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModeratePoorVisionPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getModeratePoorVisionPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getModeratePoorVisionPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getModeratePoorVisionPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSeverePoorVisionPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSeverePoorVisionPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSeverePoorVisionPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSeverePoorVisionPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNewPoorVisionPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getNewPoorVisionPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNewPoorVisionPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getNewPoorVisionPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getTrachomaEyePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getTrachomaEyePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getTrachomaEyePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getTrachomaEyePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyDentalCariesPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getBabyDentalCariesPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyDentalCariesPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getBabyDentalCariesPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyCariesFillingPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getBabyCariesFillingPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyCariesFillingPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getBabyCariesFillingPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyDentalCariesAverageMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getBabyDentalCariesAverageMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getBabyDentalCariesAverageFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getBabyDentalCariesAverageFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentDentalCariesPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPermanentDentalCariesPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentDentalCariesPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPermanentDentalCariesPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentCariesFillingPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPermanentCariesFillingPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentCariesFillingPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPermanentCariesFillingPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentDentalCariesAverageMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPermanentDentalCariesAverageMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPermanentDentalCariesAverageFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPermanentDentalCariesAverageFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getDentalCariesPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getDentalCariesPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getDentalCariesPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getDentalCariesPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getCariesFillingPercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getCariesFillingPercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getCariesFillingPercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getCariesFillingPercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getDentalCariesAverageMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getDentalCariesAverageMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getDentalCariesAverageFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getDentalCariesAverageFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPeriodontalDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPeriodontalDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getPeriodontalDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getPeriodontalDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getHeartDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getHeartDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getHeartDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getHeartDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLungDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getLungDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLungDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getLungDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpleenDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSpleenDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpleenDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSpleenDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNeckDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getNeckDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getNeckDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getNeckDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLimbsDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getLimbsDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getLimbsDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getLimbsDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpineDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSpineDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSpineDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSpineDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSkinDiseasePercentMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSkinDiseasePercentMale() {
			// TODO Auto-generated method stub
			return 0;
		}

		/* 
		 * @see com.founder.rhip.ehr.dto.StudentExamReportDTO.IStudentExamReportData#getSkinDiseasePercentFeMale()
		 * @author Ye jianfei
		 */
		@Override
		public double getSkinDiseasePercentFeMale() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
	
	public static interface IStudentExamReportData {
		
		/**
		 * 体检数
		 * @return
		 */
		public int getExamNumber();

		/**
		 * 体检数-男
		 * @return
		 */
		public int getExamNumberMale();

		/**
		 * 体检数-女
		 * @return
		 */
		public int getExamNumberFeMale();
		
		
		
		/**
		 * 正常数
		 * @return
		 */
		public int getNormalNumber();

		/**
		 * 正常数-男
		 * @return
		 */
		public int getNormalNumberMale();
		
		/**
		 * 正常数-女
		 * @return
		 */
		public int getNormalNumberFeMale();
		
		
		
		/**
		 * 超重数
		 * @return
		 */
		public int getOverweightNumber();
		
		/**
		 * 超重数-男
		 * @return
		 */
		public int getOverweightNumberMale();
		
		/**
		 * 超重数-女
		 * @return
		 */
		public int getOverweightNumberFeMale();		
		
		
		
		/**
		 * 肥胖数
		 * @return
		 */
		public int getObesityNumber();
		
		/**
		 * 肥胖数-男
		 * @return
		 */
		public int getObesityNumberMale();
		
		/**
		 * 肥胖数-女
		 * @return
		 */
		public int getObesityNumberFeMale();
		

		
		
		/**
		 * 生长迟缓数
		 * @return
		 */
		public int getSlowGrowthNumber();
		
		/**
		 * 生长迟缓数-男
		 * @return
		 */
		public int getSlowGrowthNumberMale();
		
		/**
		 * 生长迟缓数-女
		 * @return
		 */
		public int getSlowGrowthNumberFeMale();
		
		
		
		/**
		 * 身材矮小数
		 * @return
		 */
		public int getSmallNumber();
		
		/**
		 * 身材矮小数-男
		 * @return
		 */
		public int getSmallNumberMale();
		
		/**
		 * 身材矮小数-女
		 * @return
		 */
		public int getSmallNumberFeMale();
		
		
		
		/**
		 * 重中度消瘦
		 * @return
		 */
		public int getModerateThinNumber();
		
		/**
		 * 重中度消瘦-男
		 * @return
		 */
		public int getModerateThinNumberMale();
		
		/**
		 * 重中度消瘦-女
		 * @return
		 */
		public int getModerateThinNumberFeMale();
		
		
		
		
		/**
		 * 轻度消瘦
		 * @return
		 */
		public int getMildThinNumber();
		
		/**
		 * 轻度消瘦-男
		 * @return
		 */
		public int getMildThinNumberMale();
		
		/**
		 * 轻度消瘦-女
		 * @return
		 */
		public int getMildThinNumberFeMale();
		
		
		
		/**
		 * 视力不良-轻
		 * @return
		 */
		public int getMildPoorVisionNumber();
		
		/**
		 * 视力不良-轻-男
		 * @return
		 */
		public int getMildPoorVisionNumberMale();
		
		/**
		 * 视力不良-轻-女
		 * @return
		 */
		public int getMildPoorVisionNumberFeMale();
		
		
		
		/**
		 * 视力不良-中
		 * @return
		 */
		public int getModeratePoorVisionNumber();
		
		/**
		 * 视力不良-中-男
		 * @return
		 */
		public int getModeratePoorVisionNumberMale();
		/**
		 * 视力不良-中-女
		 * @return
		 */
		public int getModeratePoorVisionNumberFeMale();
		
		
		/**
		 * 视力不良-重
		 * @return
		 */
		public int getSeverePoorVisionNumber();
		
		/**
		 * 视力不良-重-男
		 * @return
		 */
		public int getSeverePoorVisionNumberMale();
		
		/**
		 * 视力不良-重-女
		 * @return
		 */
		public int getSeverePoorVisionNumberFeMale();
		
		
		
		/**
		 * 视力新发-去年正常数
		 * @return
		 */
		public int getNormalVisionLastYearNumber();
		
		/**
		 * 视力新发-去年正常数-男
		 * @return
		 */
		public int getNormalVisionLastYearNumberMale();
		
		/**
		 * 视力新发-去年正常数-女
		 * @return
		 */
		public int getNormalVisionLastYearNumberFeMale();
		
		
		
		/**
		 * 视力新发-今年低下数
		 * @return
		 */
		public int getNewPoorVisionNumber();
		
		/**
		 * 视力新发-今年低下数-男
		 * @return
		 */
		public int getNewPoorVisionNumberMale();
		
		/**
		 * 视力新发-今年低下数-女
		 * @return
		 */
		public int getNewPoorVisionNumberFeMale();
		
		
		
		/**
		 * 沙眼数
		 * @return
		 */
		public int getTrachomaEyeNumber();
		
		/**
		 * 沙眼数-男
		 * @return
		 */
		public int getTrachomaEyeNumberMale();
		
		/**
		 * 沙眼数-女
		 * @return
		 */
		public int getTrachomaEyeNumberFeMale();
		
		
		
		/**
		 * 乳牙龋齿-总龋齿人数R
		 * @return
		 */
		public int getBabyEurodonticusNumber();
		
		/**
		 * 乳牙龋齿-总龋齿人数R-男
		 * @return
		 */
		public int getBabyEurodonticusNumberMale();
		
		/**
		 * 乳牙龋齿-总龋齿人数R-女
		 * @return
		 */
		public int getBabyEurodonticusNumberFeMale();
		
		/**
		 * 乳牙龋齿-龋齿数
		 * @return
		 */
		public int getBabyDentalCariesNumber();
		
		/**
		 * 乳牙龋齿-龋齿数-男
		 * @return
		 */
		public int getBabyDentalCariesNumberMale();
		
		/**
		 * 乳牙龋齿-龋齿数-女
		 * @return
		 */
		public int getBabyDentalCariesNumberFeMale();
		
		
		
		/**
		 * 乳牙龋齿-龋补数
		 * @return
		 */
		public int getBabyCariesFillingNumber();
		
		/**
		 * 乳牙龋齿-龋补数-男
		 * @return
		 */
		public int getBabyCariesFillingNumberMale();
		
		/**
		 * 乳牙龋齿-龋补数-女
		 * @return
		 */
		public int getBabyCariesFillingNumberFeMale();
		
		
		
		/**
		 * 恒牙龋齿-总龋齿人数R
		 * @return
		 */
		public int getPermanentEurodonticusNumber();
		
		/**
		 * 恒牙龋齿-总龋齿人数R-男
		 * @return
		 */
		public int getPermanentEurodonticusNumberMale();
		
		/**
		 * 恒牙龋齿-总龋齿人数R-女
		 * @return
		 */
		public int getPermanentEurodonticusNumberFeMale();
		
		
		
		/**
		 * 恒牙龋齿-龋齿数
		 * @return
		 */
		public int getPermanentDentalCariesNumber();
		
		/**
		 * 恒牙龋齿-龋齿数-男
		 * @return
		 */
		public int getPermanentDentalCariesNumberMale();
		
		/**
		 * 恒牙龋齿-龋齿数-女
		 * @return
		 */
		public int getPermanentDentalCariesNumberFeMale();
		
		
		
		/**
		 * 恒牙龋齿-龋补数
		 * @return
		 */
		public int getPermanentCariesFillingNumber();
		
		/**
		 * 恒牙龋齿-龋补数-男
		 * @return
		 */
		public int getPermanentCariesFillingNumberMale();
		
		/**
		 * 恒牙龋齿-龋补数-女
		 * @return
		 */
		public int getPermanentCariesFillingNumberFeMale();
		
		
		
		/**
		 * 恒牙龋齿（12岁）-总龋齿人数R
		 * @return
		 */
		public int getEurodonticusNumber();
		
		/**
		 * 恒牙龋齿（12岁）-总龋齿人数R-男
		 * @return
		 */
		public int getEurodonticusNumberMale();
		
		/**
		 * 恒牙龋齿（12岁）-总龋齿人数R-女
		 * @return
		 */
		public int getEurodonticusNumberFeMale();
		
		
		
		/**
		 * 恒牙龋齿（12岁）-龋齿数
		 * @return
		 */
		public int getDentalCariesNumber();
		
		/**
		 * 恒牙龋齿（12岁）-龋齿数-男
		 * @return
		 */
		public int getDentalCariesNumberMale();
		
		/**
		 * 恒牙龋齿（12岁）-龋齿数-女
		 * @return
		 */
		public int getDentalCariesNumberFeMale();
		
		
		
		/**
		 * 恒牙龋齿（12岁及以上）-龋补数
		 * @return
		 */
		public int getCariesFillingNumber();
		
		/**
		 * 恒牙龋齿（12岁及以上）-龋补数-男
		 * @return
		 */
		public int getCariesFillingNumberMale();
		
		/**
		 * 恒牙龋齿（12岁及以上）-龋补数-女
		 * @return
		 */
		public int getCariesFillingNumberFeMale();
		
		
		
		/**
		 * 牙周病-人数
		 * @return
		 */
		public int getPeriodontalDiseaseNumber();
		
		/**
		 * 牙周病-人数-男
		 * @return
		 */
		public int getPeriodontalDiseaseNumberMale();
		
		/**
		 * 牙周病-人数-女
		 * @return
		 */
		public int getPeriodontalDiseaseNumberFeMale();
		
		
		
		/**
		 * 杂音、早博-人数
		 * @return
		 */
		public int getHeartDiseaseNumber();
		
		/**
		 * 杂音、早博-人数-男
		 * @return
		 */
		public int getHeartDiseaseNumberMale();
		
		/**
		 * 杂音、早博-人数-女
		 * @return
		 */
		public int getHeartDiseaseNumberFeMale();
		
		
		/**
		 * 哮鸣音-人数
		 * @return
		 */
		public int getLungDiseaseNumber();
		
		/**
		 * 哮鸣音-人数-男
		 * @return
		 */
		public int getLungDiseaseNumberMale();
		
		/**
		 * 哮鸣音-人数-女
		 * @return
		 */
		public int getLungDiseaseNumberFeMale();
		
		
		
		/**
		 * 肝脾肿大-人数
		 * @return
		 */
		public int getSpleenDiseaseNumber();
		
		/**
		 * 肝脾肿大-人数-男
		 * @return
		 */
		public int getSpleenDiseaseNumberMale();
		
		/**
		 * 肝脾肿大-人数-女
		 * @return
		 */
		public int getSpleenDiseaseNumberFeMale();
		
		
		
		/**
		 * 甲状腺肿大-人数
		 * @return
		 */
		public int getNeckDiseaseNumber();
		
		/**
		 * 甲状腺肿大-人数-男
		 * @return
		 */
		public int getNeckDiseaseNumberMale();
		
		/**
		 * 甲状腺肿大-人数-女
		 * @return
		 */
		public int getNeckDiseaseNumberFeMale();
		
		
		
		/**
		 * 淋巴结肿大-人数
		 * @return
		 */
		public int getLimbsDiseaseNumber();
		
		/**
		 * 淋巴结肿大-人数-男
		 * @return
		 */
		public int getLimbsDiseaseNumberMale();
		
		/**
		 * 淋巴结肿大-人数-女
		 * @return
		 */
		public int getLimbsDiseaseNumberFeMale();
		
		
		
		/**
		 * 脊柱弯曲-人数
		 * @return
		 */
		public int getSpineDiseaseNumber();
		
		/**
		 * 脊柱弯曲-人数-男
		 * @return
		 */
		public int getSpineDiseaseNumberMale();
		
		/**
		 * 脊柱弯曲-人数-女
		 * @return
		 */
		public int getSpineDiseaseNumberFeMale();
		
		
		/**
		 * 皮肤病-人数
		 * @return
		 */
		public int getSkinDiseaseNumber();
		
		/**
		 * 皮肤病-人数-男
		 * @return
		 */
		public int getSkinDiseaseNumberMale();
		
		/**
		 * 皮肤病-人数-女
		 * @return
		 */
		public int getSkinDiseaseNumberFeMale();
		
		//正常率
		public double getNormalPercent();
		//正常率-男
		public double getNormalPercentMale();
		//正常率-女
		public double getNormalPercentFeMale();

		
		//超重率
		public double getOverweightPercent();
		//超重率-男
		public double getOverweightPercentMale();
		//超重率-女
		public double getOverweightPercentFeMale();

		
		//肥胖率
		public double getObesityPercent();
		//肥胖率-男
		public double getObesityPercentMale();
		//肥胖率-女
		public double getObesityPercentFeMale();


		//生长迟缓率
		public double getSlowGrowthPercent();
		//生长迟缓率-男
		public double getSlowGrowthPercentMale();
		//生长迟缓率-女
		public double getSlowGrowthPercentFeMale();


		//身材矮小率
		public double getSmallPercent();
		//身材矮小率-男
		public double getSmallPercentMale();
		//身材矮小率-女
		public double getSmallPercentFeMale();
		
		
		//重中度消瘦率
		public double getModerateThinPercent();
		//重中度消瘦率-男
		public double getModerateThinPercentMale();
		//重中度消瘦率-女
		public double getModerateThinPercentFeMale();
		
		
		//轻度消瘦瘦率
		public double getMildThinPercent();
		//轻度消瘦瘦率-男
		public double getMildThinPercentMale();
		//轻度消瘦瘦率-女
		public double getMildThinPercentFeMale();
		
		
		//视力不良-轻度率
		public double getMildPoorVisionPercent();
		//视力不良-轻度率-男
		public double getMildPoorVisionPercentMale();
		//视力不良-轻度率-女
		public double getMildPoorVisionPercentFeMale();
		
		
		//视力不良-中度率
		public double getModeratePoorVisionPercent();
		//视力不良-中度率-男
		public double getModeratePoorVisionPercentMale();
		//视力不良-中度率-女
		public double getModeratePoorVisionPercentFeMale();
		
		
		//视力不良-重度率
		public double getSeverePoorVisionPercent();
		//视力不良-重度率-男
		public double getSeverePoorVisionPercentMale();
		//视力不良-重度率-女
		public double getSeverePoorVisionPercentFeMale();
		
		
		//视力新发率
		public double getNewPoorVisionPercent();
		//视力新发率-男
		public double getNewPoorVisionPercentMale();
		//视力新发率-女
		public double getNewPoorVisionPercentFeMale();
		
		
		//沙眼率
		public double getTrachomaEyePercent();
		//沙眼率-男
		public double getTrachomaEyePercentMale();
		//沙眼率-女
		public double getTrachomaEyePercentFeMale();
		
		
		//乳牙龋齿-龋齿率
		public double getBabyDentalCariesPercent();
		//乳牙龋齿-龋齿率-男
		public double getBabyDentalCariesPercentMale();
		//乳牙龋齿-龋齿率-女
		public double getBabyDentalCariesPercentFeMale();
		
		//乳牙龋齿-龋补率
		public double getBabyCariesFillingPercent();
		//乳牙龋齿-龋补率-男
		public double getBabyCariesFillingPercentMale();
		//乳牙龋齿-龋补率-女
		public double getBabyCariesFillingPercentFeMale();
		
		//乳牙龋齿-龋均
		public double getBabyDentalCariesAverage();
		//乳牙龋齿-龋均-男
		public double getBabyDentalCariesAverageMale();
		//乳牙龋齿-龋均-女
		public double getBabyDentalCariesAverageFeMale();
		
		//恒牙龋齿-龋齿率
		public double getPermanentDentalCariesPercent();
		//恒牙龋齿-龋齿率-男
		public double getPermanentDentalCariesPercentMale();
		//恒牙龋齿-龋齿率-女
		public double getPermanentDentalCariesPercentFeMale();
		
		
		//恒牙龋齿-龋补率
		public double getPermanentCariesFillingPercent();
		//恒牙龋齿-龋补率-男
		public double getPermanentCariesFillingPercentMale();
		//恒牙龋齿-龋补率-女
		public double getPermanentCariesFillingPercentFeMale();
		
		
		//恒牙龋齿-龋均
		public double getPermanentDentalCariesAverage();
		//恒牙龋齿-龋均-男
		public double getPermanentDentalCariesAverageMale();
		//恒牙龋齿-龋均-女
		public double getPermanentDentalCariesAverageFeMale();
		
		
		//恒牙龋齿（12岁）-龋齿率
		public double getDentalCariesPercent();
		//恒牙龋齿（12岁）-龋齿率-男
		public double getDentalCariesPercentMale();
		//恒牙龋齿（12岁）-龋齿率-女
		public double getDentalCariesPercentFeMale();
		
		
		//恒牙龋齿（12岁）-龋补率
		public double getCariesFillingPercent();
		//恒牙龋齿（12岁）-龋补率-男
		public double getCariesFillingPercentMale();
		//恒牙龋齿（12岁）-龋补率-女
		public double getCariesFillingPercentFeMale();
		
		
		//恒牙龋齿（12岁）-龋均
		public double getDentalCariesAverage();
		//恒牙龋齿（12岁）-龋均-男
		public double getDentalCariesAverageMale();
		//恒牙龋齿（12岁）-龋均-女
		public double getDentalCariesAverageFeMale();
		
		
		//牙周病-率（%）
		public double getPeriodontalDiseasePercent();
		//牙周病-率（%）-男
		public double getPeriodontalDiseasePercentMale();
		//牙周病-率（%）-女
		public double getPeriodontalDiseasePercentFeMale();
		
		
		//心杂音、早博-率（%）
		public double getHeartDiseasePercent();
		//心杂音、早博-率（%）-男
		public double getHeartDiseasePercentMale();
		//心杂音、早博-率（%）-女
		public double getHeartDiseasePercentFeMale();
		
		
		//哮鸣音-率（%）
		public double getLungDiseasePercent();
		//哮鸣音-率（%）-男
		public double getLungDiseasePercentMale();
		//哮鸣音-率（%）-女
		public double getLungDiseasePercentFeMale();
		
		
		//肝脾肿大-率（%）
		public double getSpleenDiseasePercent();
		//肝脾肿大-率（%）-男
		public double getSpleenDiseasePercentMale();		
		//肝脾肿大-率（%）-女
		public double getSpleenDiseasePercentFeMale();
		
		
		//甲状腺肿大-率（%）
		public double getNeckDiseasePercent();
		//甲状腺肿大-率（%）-男
		public double getNeckDiseasePercentMale();
		//甲状腺肿大-率（%）-女
		public double getNeckDiseasePercentFeMale();
		
		
		//淋巴结肿大-率（%）
		public double getLimbsDiseasePercent();
		//淋巴结肿大-率（%）-男
		public double getLimbsDiseasePercentMale();
		//淋巴结肿大-率（%）-女
		public double getLimbsDiseasePercentFeMale();
		
		
		//脊柱弯曲-率（%）
		public double getSpineDiseasePercent();
		//脊柱弯曲-率（%）-男
		public double getSpineDiseasePercentMale();
		//脊柱弯曲-率（%）-女
		public double getSpineDiseasePercentFeMale();
		
		
		//皮肤病-率（%）
		public double getSkinDiseasePercent();
		//皮肤病-率（%）-男
		public double getSkinDiseasePercentMale();
		//皮肤病-率（%）-女
		public double getSkinDiseasePercentFeMale();		
	}
	
}
