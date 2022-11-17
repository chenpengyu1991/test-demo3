package com.founder.rhip.ehr.dto;

import java.util.ArrayList;
import java.util.List;

public class FissureSealantReportDTO implements IFissureSealantReportLine {
	
	private List<IFissureSealantReportLine> lines = new ArrayList<IFissureSealantReportLine>();
	
	@Override
	public int getTotleNumber() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getTotleNumber();
		}
		return totle;
	}
	
	@Override
	public int getCheckMnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getCheckMnum();
		}
		return totle;
	}

	@Override
	public int getCheckFnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getCheckFnum();
		}
		return totle;
	}

	@Override
	public int getCheckTnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getCheckTnum();
		}
		return totle;
	}

	@Override
	public int getTeethMnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getTeethMnum();
		}
		return totle;
	}

	@Override
	public int getTeethFnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getTeethFnum();
		}
		return totle;
	}

	@Override
	public int getTeethTnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getTeethTnum();
		}
		return totle;
	}

	@Override
	public int getEurodonticusMnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getEurodonticusMnum();
		}
		return totle;
	}

	@Override
	public int getEurodonticusFnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getEurodonticusFnum();
		}
		return totle;
	}

	@Override
	public int getEurodonticusTnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getEurodonticusTnum();
		}
		return totle;
	}

	@Override
	public int getDentalCariesMnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getDentalCariesMnum();
		}
		return totle;
	}

	@Override
	public int getDentalCariesFnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getDentalCariesFnum();
		}
		return totle;
	}

	@Override
	public int getDentalCariesTnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getDentalCariesTnum();
		}
		return totle;
	}

	@Override
	public int getClosedMnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getClosedMnum();
		}
		return totle;
	}

	@Override
	public int getClosedFnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getClosedFnum();
		}
		return totle;
	}

	@Override
	public int getClosedTnum() {
		int totle = 0;
		for (IFissureSealantReportLine line : lines) {
			totle += line.getClosedTnum();
		}
		return totle;
	}
	
	public void addReportLine(IFissureSealantReportLine line) {
		lines.add(line);
	}
	
	public List<IFissureSealantReportLine> getLines() {
		return lines;
	}
	
	public static class ReportSchool extends FissureSealantReportDTO {
		
		private String schoolName = "";
		
		private int totleNumber;//实际人数
		
		public int getTotleNumber() {
			return totleNumber;
		}
		
		public void setTotleNumber(int totleNumber) {
			this.totleNumber = totleNumber;
		}
		
		public String getSchoolName() {
			return schoolName;
		}

		public void setSchoolName(String schoolName) {
			this.schoolName = schoolName;
		}
	}
	
	public static class ReportClass extends FissureSealantReportDTO {
		
		private String classCode;//班级
		
		private int totleNumber;//实际人数
		
		public int getTotleNumber() {
			return totleNumber;
		}
		
		public void setTotleNumber(int totleNumber) {
			this.totleNumber = totleNumber;
		}

		public String getClassCode() {
			return classCode;
		}

		public void setClassCode(String classCode) {
			this.classCode = classCode;
		}
	}

	public static class ReportLine implements IFissureSealantReportLine {
		
		private String nativeStudent;//是否本地学生
		
		private int checkMnum;//检查人数-男
		private int checkFnum;//检查人数-女
		
		private int teethMnum;//检查牙数-男
		private int teethFnum;//检查牙数-女
		
		private int eurodonticusMnum;//龋患人数-男
		private int eurodonticusFnum;//龋患人数-女
		
		private int dentalCariesMnum;//龋齿数-男
		private int dentalCariesFnum;//龋齿数-女
		
		private int closedMnum;//封闭牙数-男
		private int closedFnum;//封闭牙数-女
		
		public int getCheckMnum() {
			return checkMnum;
		}
		public void setCheckMnum(int checkMnum) {
			this.checkMnum = checkMnum;
		}
		public int getCheckFnum() {
			return checkFnum;
		}
		public void setCheckFnum(int checkFnum) {
			this.checkFnum = checkFnum;
		}
		public int getCheckTnum() {
			return checkMnum + checkFnum;
		}
		public int getTeethMnum() {
			return teethMnum;
		}
		public void setTeethMnum(int teethMnum) {
			this.teethMnum = teethMnum;
		}
		public int getTeethFnum() {
			return teethFnum;
		}
		public void setTeethFnum(int teethFnum) {
			this.teethFnum = teethFnum;
		}
		public int getTeethTnum() {
			return teethMnum + teethFnum;
		}
		public int getEurodonticusMnum() {
			return eurodonticusMnum;
		}
		public void setEurodonticusMnum(int eurodonticusMnum) {
			this.eurodonticusMnum = eurodonticusMnum;
		}
		public int getEurodonticusFnum() {
			return eurodonticusFnum;
		}
		public void setEurodonticusFnum(int eurodonticusFnum) {
			this.eurodonticusFnum = eurodonticusFnum;
		}
		public int getEurodonticusTnum() {
			return eurodonticusMnum + eurodonticusFnum;
		}
		public int getDentalCariesMnum() {
			return dentalCariesMnum;
		}
		public void setDentalCariesMnum(int dentalCariesMnum) {
			this.dentalCariesMnum = dentalCariesMnum;
		}
		public int getDentalCariesFnum() {
			return dentalCariesFnum;
		}
		public void setDentalCariesFnum(int dentalCariesFnum) {
			this.dentalCariesFnum = dentalCariesFnum;
		}
		public int getDentalCariesTnum() {
			return dentalCariesMnum + dentalCariesFnum;
		}
		public int getClosedMnum() {
			return closedMnum;
		}
		public void setClosedMnum(int closedMnum) {
			this.closedMnum = closedMnum;
		}
		public int getClosedFnum() {
			return closedFnum;
		}
		public void setClosedFnum(int closedFnum) {
			this.closedFnum = closedFnum;
		}
		public int getClosedTnum() {
			return closedMnum + closedFnum;
		}

		public String getNativeStudent() {
			return nativeStudent;
		}

		public void setNativeStudent(String nativeStudent) {
			this.nativeStudent = nativeStudent;
		}
		
		@Override
		public int getTotleNumber() {
			return 0;
		}
		
	}
}
