package com.founder.rhip.ehr.entity.control.dmbc;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DMBC_ROACH_CAUGHT")
public class DmbcRoachCaught implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID", columnDefinition = "NUMBER|数据库唯一编号（自增长）||", length = 11, scale = 11, nullable = true)
	private Long id;

	@Column(name = "MONITOR_ID", columnDefinition = "NUMBER|蟑螂监测记录ID||", length = 11, scale = 11, nullable = true)
	private Long monitorId;

	@Column(name = "PLACE", columnDefinition = "VARCHAR2|布置场所||", length = 40, scale = 40, nullable = true)
	private String place;

	@Column(name = "BLA_GERMANICA_N", columnDefinition = "NUMBER|德国小蠊若||", length = 5, scale = 5, nullable = true)
	private Long blaGermanicaN;

	@Column(name = "BLA_GERMANICA_F", columnDefinition = "NUMBER|德国小蠊雌||", length = 5, scale = 5, nullable = true)
	private Long blaGermanicaF;

	@Column(name = "BLA_GERMANICA_M", columnDefinition = "NUMBER|德国小蠊雄||", length = 5, scale = 5, nullable = true)
	private Long blaGermanicaM;

	@Column(name = "BLA_GER_DENSITY_N", columnDefinition = "NUMBER|德国小蠊||", length = 5, scale = 5, nullable = true)
	private Double blaGerDensityN;

	@Column(name = "BLA_GER_DENSITY_F", columnDefinition = "NUMBER|德国小蠊||", length = 5, scale = 5, nullable = true)
	private Double blaGerDensityF;

	@Column(name = "BLA_GER_DENSITY_M", columnDefinition = "NUMBER|德国小蠊||", length = 5, scale = 5, nullable = true)
	private Double blaGerDensityM;

	@Column(name = "BLA_GER_DG_RATE_N", columnDefinition = "NUMBER|德国小蠊||", length = 5, scale = 5, nullable = true)
	private Double blaGerDgRateN;

	@Column(name = "BLA_GER_DG_RATE_F", columnDefinition = "NUMBER|德国小蠊||", length = 5, scale = 5, nullable = true)
	private Double blaGerDgRateF;

	@Column(name = "BLA_GER_DG_RATE_M", columnDefinition = "NUMBER|德国小蠊||", length = 5, scale = 5, nullable = true)
	private Double blaGerDgRateM;

	@Column(name = "PER_AMERICANA_N", columnDefinition = "NUMBER|美洲大蠊若||", length = 5, scale = 5, nullable = true)
	private Long perAmericanaN;

	@Column(name = "PER_AMERICANA_F", columnDefinition = "NUMBER|美洲大蠊雌||", length = 5, scale = 5, nullable = true)
	private Long perAmericanaF;

	@Column(name = "PER_AMERICANA_M", columnDefinition = "NUMBER|美洲大蠊雄||", length = 5, scale = 5, nullable = true)
	private Long perAmericanaM;

	@Column(name = "PER_AME_DENSITY_N", columnDefinition = "NUMBER|美洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAmeDensityN;

	@Column(name = "PER_AME_DENSITY_F", columnDefinition = "NUMBER|美洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAmeDensityF;

	@Column(name = "PER_AME_DENSITY_M", columnDefinition = "NUMBER|美洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAmeDensityM;

	@Column(name = "PER_AME_DG_RATE_N", columnDefinition = "NUMBER|美洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAmeDgRateN;

	@Column(name = "PER_AME_DG_RATE_F", columnDefinition = "NUMBER|美洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAmeDgRateF;

	@Column(name = "PER_AME_DG_RATE_M", columnDefinition = "NUMBER|美洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAmeDgRateM;

	@Column(name = "PER_AUSTRALASIAE_N", columnDefinition = "NUMBER|澳洲大蠊若||", length = 5, scale = 5, nullable = true)
	private Long perAustralasiaeN;

	@Column(name = "PER_AUSTRALASIAE_F", columnDefinition = "NUMBER|澳洲大蠊雌||", length = 5, scale = 5, nullable = true)
	private Long perAustralasiaeF;

	@Column(name = "PER_AUSTRALASIAE_M", columnDefinition = "NUMBER|澳洲大蠊雄||", length = 5, scale = 5, nullable = true)
	private Long perAustralasiaeM;

	@Column(name = "PER_AUS_DENSITY_N", columnDefinition = "NUMBER|澳洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAusDensityN;

	@Column(name = "PER_AUS_DENSITY_F", columnDefinition = "NUMBER|澳洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAusDensityF;

	@Column(name = "PER_AUS_DENSITY_M", columnDefinition = "NUMBER|澳洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAusDensityM;

	@Column(name = "PER_AUS_DG_RATE_N", columnDefinition = "NUMBER|澳洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAusDgRateN;

	@Column(name = "PER_AUS_DG_RATE_F", columnDefinition = "NUMBER|澳洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAusDgRateF;

	@Column(name = "PER_AUS_DG_RATE_M", columnDefinition = "NUMBER|澳洲大蠊||", length = 5, scale = 5, nullable = true)
	private Double perAusDgRateM;

	@Column(name = "PER_FULIGINOSA_N", columnDefinition = "NUMBER|黑胸大蠊若||", length = 5, scale = 5, nullable = true)
	private Long perFuliginosaN;

	@Column(name = "PER_FULIGINOSA_F", columnDefinition = "NUMBER|黑胸大蠊雌||", length = 5, scale = 5, nullable = true)
	private Long perFuliginosaF;

	@Column(name = "PER_FULIGINOSA_M", columnDefinition = "NUMBER|黑胸大蠊雄||", length = 5, scale = 5, nullable = true)
	private Long perFuliginosaM;

	@Column(name = "PER_FUL_DENSITY_N", columnDefinition = "NUMBER|黑胸大蠊||", length = 5, scale = 5, nullable = true)
	private Double perFulDensityN;

	@Column(name = "PER_FUL_DENSITY_F", columnDefinition = "NUMBER|黑胸大蠊||", length = 5, scale = 5, nullable = true)
	private Double perFulDensityF;

	@Column(name = "PER_FUL_DENSITY_M", columnDefinition = "NUMBER|黑胸大蠊||", length = 5, scale = 5, nullable = true)
	private Double perFulDensityM;

	@Column(name = "PER_FUL_DG_RATE_N", columnDefinition = "NUMBER|黑胸大蠊||", length = 5, scale = 5, nullable = true)
	private Double perFulDgRateN;

	@Column(name = "PER_FUL_DG_RATE_F", columnDefinition = "NUMBER|黑胸大蠊||", length = 5, scale = 5, nullable = true)
	private Double perFulDgRateF;

	@Column(name = "PER_FUL_DG_RATE_M", columnDefinition = "NUMBER|黑胸大蠊||", length = 5, scale = 5, nullable = true)
	private Double perFulDgRateM;

	@Column(name = "PER_BRUNNEA_BURMEISTER_N", columnDefinition = "NUMBER|褐斑大蠊若||", length = 5, scale = 5, nullable = true)
	private Long perBrunneaBurmeisterN;

	@Column(name = "PER_BRUNNEA_BURMEISTER_F", columnDefinition = "NUMBER|褐斑大蠊雌||", length = 5, scale = 5, nullable = true)
	private Long perBrunneaBurmeisterF;

	@Column(name = "PER_BRUNNEA_BURMEISTER_M", columnDefinition = "NUMBER|褐斑大蠊雄||", length = 5, scale = 5, nullable = true)
	private Long perBrunneaBurmeisterM;

	@Column(name = "PER_BRU_DENSITY_N", columnDefinition = "NUMBER|褐斑大蠊||", length = 5, scale = 5, nullable = true)
	private Double perBruDensityN;

	@Column(name = "PER_BRU_DENSITY_F", columnDefinition = "NUMBER|褐斑大蠊||", length = 5, scale = 5, nullable = true)
	private Double perBruDensityF;

	@Column(name = "PER_BRU_DENSITY_M", columnDefinition = "NUMBER|褐斑大蠊||", length = 5, scale = 5, nullable = true)
	private Double perBruDensityM;

	@Column(name = "PER_BRU_DG_RATE_N", columnDefinition = "NUMBER|褐斑大蠊||", length = 5, scale = 5, nullable = true)
	private Double perBruDgRateN;

	@Column(name = "PER_BRU_DG_RATE_F", columnDefinition = "NUMBER|褐斑大蠊||", length = 5, scale = 5, nullable = true)
	private Double perBruDgRateF;

	@Column(name = "PER_BRU_DG_RATE_M", columnDefinition = "NUMBER|褐斑大蠊||", length = 5, scale = 5, nullable = true)
	private Double perBruDgRateM;

	@Column(name = "PER_JAPONICA_N", columnDefinition = "NUMBER|日本大蠊若||", length = 5, scale = 5, nullable = true)
	private Long perJaponicaN;

	@Column(name = "PER_JAPONICA_F", columnDefinition = "NUMBER|日本大蠊雌||", length = 5, scale = 5, nullable = true)
	private Long perJaponicaF;

	@Column(name = "PER_JAPONICA_M", columnDefinition = "NUMBER|日本大蠊雄||", length = 5, scale = 5, nullable = true)
	private Long perJaponicaM;

	@Column(name = "PER_JAP_DENSITY_N", columnDefinition = "NUMBER|日本大蠊||", length = 5, scale = 5, nullable = true)
	private Double perJapDensityN;

	@Column(name = "PER_JAP_DENSITY_F", columnDefinition = "NUMBER|日本大蠊||", length = 5, scale = 5, nullable = true)
	private Double perJapDensityF;

	@Column(name = "PER_JAP_DENSITY_M", columnDefinition = "NUMBER|日本大蠊||", length = 5, scale = 5, nullable = true)
	private Double perJapDensityM;

	@Column(name = "PER_JAP_DG_RATE_N", columnDefinition = "NUMBER|日本大蠊||", length = 5, scale = 5, nullable = true)
	private Double perJapDgRateN;

	@Column(name = "PER_JAP_DG_RATE_F", columnDefinition = "NUMBER|日本大蠊||", length = 5, scale = 5, nullable = true)
	private Double perJapDgRateF;

	@Column(name = "PER_JAP_DG_RATE_M", columnDefinition = "NUMBER|日本大蠊||", length = 5, scale = 5, nullable = true)
	private Double perJapDgRateM;

	@Column(name = "OTHER_N", columnDefinition = "NUMBER|其他若||", length = 5, scale = 5, nullable = true)
	private Long otherN;

	@Column(name = "OTHER_F", columnDefinition = "NUMBER|其他雌||", length = 5, scale = 5, nullable = true)
	private Long otherF;

	@Column(name = "OTHER_M", columnDefinition = "NUMBER|其他雄||", length = 5, scale = 5, nullable = true)
	private Long otherM;

	@Column(name = "OTHER_DENSITY_N", columnDefinition = "NUMBER|其他||", length = 5, scale = 5, nullable = true)
	private Double otherDensityN;

	@Column(name = "OTHER_DENSITY_F", columnDefinition = "NUMBER|其他||", length = 5, scale = 5, nullable = true)
	private Double otherDensityF;

	@Column(name = "OTHER_DENSITY_M", columnDefinition = "NUMBER|其他||", length = 5, scale = 5, nullable = true)
	private Double otherDensityM;

	@Column(name = "OTHER_DG_RATE_N", columnDefinition = "NUMBER|其他||", length = 5, scale = 5, nullable = true)
	private Double otherDgRateN;

	@Column(name = "OTHER_DG_RATE_F", columnDefinition = "NUMBER|其他||", length = 5, scale = 5, nullable = true)
	private Double otherDgRateF;

	@Column(name = "OTHER_DG_RATE_M", columnDefinition = "NUMBER|其他||", length = 5, scale = 5, nullable = true)
	private Double otherDgRateM;

	@Column(name = "TOTAL_N", columnDefinition = "NUMBER|合计若||", length = 5, scale = 5, nullable = true)
	private Long totalN;

	@Column(name = "TOTAL_F", columnDefinition = "NUMBER|合计雌||", length = 5, scale = 5, nullable = true)
	private Long totalF;

	@Column(name = "TOTAL_M", columnDefinition = "NUMBER|合计雄||", length = 5, scale = 5, nullable = true)
	private Long totalM;

	private Double totalDensityN;

	private Double totalDensityF;

	private Double totalDgRateM;

	private Double totalDgRateN;

	private Double totalDgRateF;

	private Double totalDensityM;

	@Column(name = "TOTAL", columnDefinition = "NUMBER|合计||", length = 5, scale = 5, nullable = true)
	private Long total;

	@Column(name = "REMARKS", columnDefinition = "VARCHAR2|备注||", length = 40, scale = 40, nullable = true)
	private String remarks;

	@Column(name = "SPECIES_CODE", columnDefinition = "VARCHAR2|蟑螂种类代码||", length = 40, scale = 40, nullable = true)
	private String speciesCode;

	@Column(name = "CREATE_TIME", columnDefinition = "DATE|创建时间||", nullable = true)
	private Date createTime;

	@Column(name = "CREATE_BY", columnDefinition = "VARCHAR2|创建者||", length = 20, scale = 20, nullable = true)
	private String createBy;

	@Column(name = "UPDATE_TIME", columnDefinition = "DATE|更新时间||", nullable = true)
	private Date updateTime;

	@Column(name = "UPDATE_BY", columnDefinition = "VARCHAR2|更新者||", length = 20, scale = 20, nullable = true)
	private String updateBy;

	@Column(name = "IS_DELETE", columnDefinition = "INT|删除状态||", nullable = true)
	private Integer isDelete;

	public Double getTotalDensityN() {
		Double rs = 0d;
		int cnt=0;
		if (blaGerDensityN != null){
			rs += blaGerDensityN;
			cnt++;
		}
		if (perAmeDensityN != null){
			rs += perAmeDensityN;
			cnt++;
		}
		if (perAusDensityN != null){
			rs += perAusDensityN;
			cnt++;
		}
		if (perFulDensityN != null){
			rs += perFulDensityN;
			cnt++;
		}
		if (perBruDensityN != null){
			rs += perBruDensityN;
			cnt++;
		}
		if (perJapDensityN != null){
			rs += perJapDensityN;
			cnt++;
		}
		if (otherDensityN != null){
			rs += otherDensityN;
			cnt++;
		}
		if (cnt > 0) {
			DecimalFormat df=new DecimalFormat(".##");
			return Double.valueOf(df.format(rs/cnt));
		}
		return 0.00;
	}

	public void setTotalDensityN(Double totalDensityN) {
		this.totalDensityN = totalDensityN;
	}

	public Double getTotalDensityF() {
		Double rs = 0d;
		int cnt=0;
		if (blaGerDensityF != null){
			rs += blaGerDensityF;
			cnt++;
		}
		if (perAmeDensityF != null){
			rs += perAmeDensityF;
			cnt++;
		}
		if (perAusDensityF != null){
			rs += perAusDensityF;
			cnt++;
		}
		if (perFulDensityF != null){
			rs += perFulDensityF;
			cnt++;
		}
		if (perBruDensityF != null){
			rs += perBruDensityF;
			cnt++;
		}
		if (perJapDensityF != null){
			rs += perJapDensityF;
			cnt++;
		}
		if (otherDensityF != null){
			rs += otherDensityF;
			cnt++;
		}
		if (cnt > 0) {
			DecimalFormat df=new DecimalFormat(".##");
			return Double.valueOf(df.format(rs/cnt));
		}
		return 0.00;
	}

	public void setTotalDensityF(Double totalDensityF) {
		this.totalDensityF = totalDensityF;
	}

	public Double getTotalDgRateM() {
		Double rs = 0d;
		int cnt=0;
		if (blaGerDgRateM != null){
			rs += blaGerDgRateM;
			cnt++;
		}
		if (perAmeDgRateM != null){
			rs += perAmeDgRateM;
			cnt++;
		}
		if (perAusDgRateM != null){
			rs += perAusDgRateM;
			cnt++;
		}
		if (perFulDgRateM != null){
			rs += perFulDgRateM;
			cnt++;
		}
		if (perBruDgRateM != null){
			rs += perBruDgRateM;
			cnt++;
		}
		if (perJapDgRateM != null){
			rs += perJapDgRateM;
			cnt++;
		}
		if (otherDgRateM != null){
			rs += otherDgRateM;
			cnt++;
		}
		if (cnt > 0) {
			DecimalFormat df=new DecimalFormat(".##");
			return Double.valueOf(df.format(rs/cnt));
		}
		return 0.00;
	}

	public void setTotalDgRateM(Double totalDgRateM) {
		this.totalDgRateM = totalDgRateM;
	}

	public Double getTotalDgRateN() {
		Double rs = 0d;
		int cnt=0;
		if (blaGerDgRateN != null){
			rs += blaGerDgRateN;
			cnt++;
		}
		if (perAmeDgRateN != null){
			rs += perAmeDgRateN;
			cnt++;
		}
		if (perAusDgRateN != null){
			rs += perAusDgRateN;
			cnt++;
		}
		if (perFulDgRateN != null){
			rs += perFulDgRateN;
			cnt++;
		}
		if (perBruDgRateN != null){
			rs += perBruDgRateN;
			cnt++;
		}
		if (perJapDgRateN != null){
			rs += perJapDgRateN;
			cnt++;
		}
		if (otherDgRateN != null){
			rs += otherDgRateN;
			cnt++;
		}
		if (cnt > 0) {
			DecimalFormat df=new DecimalFormat(".##");
			return Double.valueOf(df.format(rs/cnt));
		}
		return 0.00;
	}

	public void setTotalDgRateN(Double totalDgRateN) {
		this.totalDgRateN = totalDgRateN;
	}

	public Double getTotalDgRateF() {
		Double rs = 0d;
		int cnt=0;
		if (blaGerDgRateF != null){
			rs += blaGerDgRateF;
			cnt++;
		}
		if (perAmeDgRateF != null){
			rs += perAmeDgRateF;
			cnt++;
		}
		if (perAusDgRateF != null){
			rs += perAusDgRateF;
			cnt++;
		}
		if (perFulDgRateF != null){
			rs += perFulDgRateF;
			cnt++;
		}
		if (perBruDgRateF != null){
			rs += perBruDgRateF;
			cnt++;
		}
		if (perJapDgRateF != null){
			rs += perJapDgRateF;
			cnt++;
		}
		if (otherDgRateF != null){
			rs += otherDgRateF;
			cnt++;
		}
		if (cnt > 0) {
			DecimalFormat df=new DecimalFormat(".##");
			return Double.valueOf(df.format(rs/cnt));
		}
		return 0.00;
	}

	public void setTotalDgRateF(Double totalDgRateF) {
		this.totalDgRateF = totalDgRateF;
	}

	public Double getTotalDensityM() {
		Double rs = 0d;
		int cnt=0;
		if (blaGerDensityM != null){
			rs += blaGerDensityM;
			cnt++;
		}
		if (perAmeDensityM != null){
			rs += perAmeDensityM;
			cnt++;
		}
		if (perAusDensityM != null){
			rs += perAusDensityM;
			cnt++;
		}
		if (perFulDensityM != null){
			rs += perFulDensityM;
			cnt++;
		}
		if (perBruDensityM != null){
			rs += perBruDensityM;
			cnt++;
		}
		if (perJapDensityM != null){
			rs += perJapDensityM;
			cnt++;
		}
		if (otherDensityM != null){
			rs += otherDensityM;
			cnt++;
		}
		if (cnt > 0) {
			DecimalFormat df=new DecimalFormat(".##");
			return Double.valueOf(df.format(rs/cnt));
		}
		return 0.00;
	}

	public void setTotalDensityM(Double totalDensityM) {
		this.totalDensityM = totalDensityM;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMonitorId() {
		return this.monitorId;
	}

	public void setMonitorId(Long monitorId) {
		this.monitorId = monitorId;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Long getBlaGermanicaN() {
		return this.blaGermanicaN;
	}

	public void setBlaGermanicaN(Long blaGermanicaN) {
		this.blaGermanicaN = blaGermanicaN;
	}

	public Long getBlaGermanicaF() {
		return this.blaGermanicaF;
	}

	public void setBlaGermanicaF(Long blaGermanicaF) {
		this.blaGermanicaF = blaGermanicaF;
	}

	public Long getBlaGermanicaM() {
		return this.blaGermanicaM;
	}

	public void setBlaGermanicaM(Long blaGermanicaM) {
		this.blaGermanicaM = blaGermanicaM;
	}

	public Long getPerAmericanaN() {
		return this.perAmericanaN;
	}

	public void setPerAmericanaN(Long perAmericanaN) {
		this.perAmericanaN = perAmericanaN;
	}

	public Long getPerAmericanaF() {
		return this.perAmericanaF;
	}

	public void setPerAmericanaF(Long perAmericanaF) {
		this.perAmericanaF = perAmericanaF;
	}

	public Long getPerAmericanaM() {
		return this.perAmericanaM;
	}

	public void setPerAmericanaM(Long perAmericanaM) {
		this.perAmericanaM = perAmericanaM;
	}

	public Long getPerAustralasiaeN() {
		return this.perAustralasiaeN;
	}

	public void setPerAustralasiaeN(Long perAustralasiaeN) {
		this.perAustralasiaeN = perAustralasiaeN;
	}

	public Long getPerAustralasiaeF() {
		return this.perAustralasiaeF;
	}

	public void setPerAustralasiaeF(Long perAustralasiaeF) {
		this.perAustralasiaeF = perAustralasiaeF;
	}

	public Long getPerAustralasiaeM() {
		return this.perAustralasiaeM;
	}

	public void setPerAustralasiaeM(Long perAustralasiaeM) {
		this.perAustralasiaeM = perAustralasiaeM;
	}

	public Long getPerFuliginosaN() {
		return this.perFuliginosaN;
	}

	public void setPerFuliginosaN(Long perFuliginosaN) {
		this.perFuliginosaN = perFuliginosaN;
	}

	public Long getPerFuliginosaF() {
		return this.perFuliginosaF;
	}

	public void setPerFuliginosaF(Long perFuliginosaF) {
		this.perFuliginosaF = perFuliginosaF;
	}

	public Long getPerFuliginosaM() {
		return this.perFuliginosaM;
	}

	public void setPerFuliginosaM(Long perFuliginosaM) {
		this.perFuliginosaM = perFuliginosaM;
	}

	public Long getPerBrunneaBurmeisterN() {
		return this.perBrunneaBurmeisterN;
	}

	public void setPerBrunneaBurmeisterN(Long perBrunneaBurmeisterN) {
		this.perBrunneaBurmeisterN = perBrunneaBurmeisterN;
	}

	public Long getPerBrunneaBurmeisterF() {
		return this.perBrunneaBurmeisterF;
	}

	public void setPerBrunneaBurmeisterF(Long perBrunneaBurmeisterF) {
		this.perBrunneaBurmeisterF = perBrunneaBurmeisterF;
	}

	public Long getPerBrunneaBurmeisterM() {
		return this.perBrunneaBurmeisterM;
	}

	public void setPerBrunneaBurmeisterM(Long perBrunneaBurmeisterM) {
		this.perBrunneaBurmeisterM = perBrunneaBurmeisterM;
	}

	public Long getPerJaponicaN() {
		return this.perJaponicaN;
	}

	public void setPerJaponicaN(Long perJaponicaN) {
		this.perJaponicaN = perJaponicaN;
	}

	public Long getPerJaponicaF() {
		return this.perJaponicaF;
	}

	public void setPerJaponicaF(Long perJaponicaF) {
		this.perJaponicaF = perJaponicaF;
	}

	public Long getPerJaponicaM() {
		return this.perJaponicaM;
	}

	public void setPerJaponicaM(Long perJaponicaM) {
		this.perJaponicaM = perJaponicaM;
	}

	public Long getOtherN() {
		return this.otherN;
	}

	public void setOtherN(Long otherN) {
		this.otherN = otherN;
	}

	public Long getOtherF() {
		return this.otherF;
	}

	public void setOtherF(Long otherF) {
		this.otherF = otherF;
	}

	public Long getOtherM() {
		return this.otherM;
	}

	public void setOtherM(Long otherM) {
		this.otherM = otherM;
	}

	public Double getBlaGerDensityN() {
		return blaGerDensityN;
	}

	public void setBlaGerDensityN(Double blaGerDensityN) {
		this.blaGerDensityN = blaGerDensityN;
	}

	public Double getBlaGerDensityF() {
		return blaGerDensityF;
	}

	public void setBlaGerDensityF(Double blaGerDensityF) {
		this.blaGerDensityF = blaGerDensityF;
	}

	public Double getBlaGerDensityM() {
		return blaGerDensityM;
	}

	public void setBlaGerDensityM(Double blaGerDensityM) {
		this.blaGerDensityM = blaGerDensityM;
	}

	public Double getBlaGerDgRateN() {
		return blaGerDgRateN;
	}

	public void setBlaGerDgRateN(Double blaGerDgRateN) {
		this.blaGerDgRateN = blaGerDgRateN;
	}

	public Double getBlaGerDgRateF() {
		return blaGerDgRateF;
	}

	public void setBlaGerDgRateF(Double blaGerDgRateF) {
		this.blaGerDgRateF = blaGerDgRateF;
	}

	public Double getBlaGerDgRateM() {
		return blaGerDgRateM;
	}

	public void setBlaGerDgRateM(Double blaGerDgRateM) {
		this.blaGerDgRateM = blaGerDgRateM;
	}

	public Double getPerAmeDensityN() {
		return perAmeDensityN;
	}

	public void setPerAmeDensityN(Double perAmeDensityN) {
		this.perAmeDensityN = perAmeDensityN;
	}

	public Double getPerAmeDensityF() {
		return perAmeDensityF;
	}

	public void setPerAmeDensityF(Double perAmeDensityF) {
		this.perAmeDensityF = perAmeDensityF;
	}

	public Double getPerAmeDensityM() {
		return perAmeDensityM;
	}

	public void setPerAmeDensityM(Double perAmeDensityM) {
		this.perAmeDensityM = perAmeDensityM;
	}

	public Double getPerAmeDgRateN() {
		return perAmeDgRateN;
	}

	public void setPerAmeDgRateN(Double perAmeDgRateN) {
		this.perAmeDgRateN = perAmeDgRateN;
	}

	public Double getPerAmeDgRateF() {
		return perAmeDgRateF;
	}

	public void setPerAmeDgRateF(Double perAmeDgRateF) {
		this.perAmeDgRateF = perAmeDgRateF;
	}

	public Double getPerAmeDgRateM() {
		return perAmeDgRateM;
	}

	public void setPerAmeDgRateM(Double perAmeDgRateM) {
		this.perAmeDgRateM = perAmeDgRateM;
	}

	public Double getPerAusDensityN() {
		return perAusDensityN;
	}

	public void setPerAusDensityN(Double perAusDensityN) {
		this.perAusDensityN = perAusDensityN;
	}

	public Double getPerAusDensityF() {
		return perAusDensityF;
	}

	public void setPerAusDensityF(Double perAusDensityF) {
		this.perAusDensityF = perAusDensityF;
	}

	public Double getPerAusDensityM() {
		return perAusDensityM;
	}

	public void setPerAusDensityM(Double perAusDensityM) {
		this.perAusDensityM = perAusDensityM;
	}

	public Double getPerAusDgRateN() {
		return perAusDgRateN;
	}

	public void setPerAusDgRateN(Double perAusDgRateN) {
		this.perAusDgRateN = perAusDgRateN;
	}

	public Double getPerAusDgRateF() {
		return perAusDgRateF;
	}

	public void setPerAusDgRateF(Double perAusDgRateF) {
		this.perAusDgRateF = perAusDgRateF;
	}

	public Double getPerAusDgRateM() {
		return perAusDgRateM;
	}

	public void setPerAusDgRateM(Double perAusDgRateM) {
		this.perAusDgRateM = perAusDgRateM;
	}

	public Double getPerFulDensityN() {
		return perFulDensityN;
	}

	public void setPerFulDensityN(Double perFulDensityN) {
		this.perFulDensityN = perFulDensityN;
	}

	public Double getPerFulDensityF() {
		return perFulDensityF;
	}

	public void setPerFulDensityF(Double perFulDensityF) {
		this.perFulDensityF = perFulDensityF;
	}

	public Double getPerFulDensityM() {
		return perFulDensityM;
	}

	public void setPerFulDensityM(Double perFulDensityM) {
		this.perFulDensityM = perFulDensityM;
	}

	public Double getPerFulDgRateN() {
		return perFulDgRateN;
	}

	public void setPerFulDgRateN(Double perFulDgRateN) {
		this.perFulDgRateN = perFulDgRateN;
	}

	public Double getPerFulDgRateF() {
		return perFulDgRateF;
	}

	public void setPerFulDgRateF(Double perFulDgRateF) {
		this.perFulDgRateF = perFulDgRateF;
	}

	public Double getPerFulDgRateM() {
		return perFulDgRateM;
	}

	public void setPerFulDgRateM(Double perFulDgRateM) {
		this.perFulDgRateM = perFulDgRateM;
	}

	public Double getPerBruDensityN() {
		return perBruDensityN;
	}

	public void setPerBruDensityN(Double perBruDensityN) {
		this.perBruDensityN = perBruDensityN;
	}

	public Double getPerBruDensityF() {
		return perBruDensityF;
	}

	public void setPerBruDensityF(Double perBruDensityF) {
		this.perBruDensityF = perBruDensityF;
	}

	public Double getPerBruDensityM() {
		return perBruDensityM;
	}

	public void setPerBruDensityM(Double perBruDensityM) {
		this.perBruDensityM = perBruDensityM;
	}

	public Double getPerBruDgRateN() {
		return perBruDgRateN;
	}

	public void setPerBruDgRateN(Double perBruDgRateN) {
		this.perBruDgRateN = perBruDgRateN;
	}

	public Double getPerBruDgRateF() {
		return perBruDgRateF;
	}

	public void setPerBruDgRateF(Double perBruDgRateF) {
		this.perBruDgRateF = perBruDgRateF;
	}

	public Double getPerBruDgRateM() {
		return perBruDgRateM;
	}

	public void setPerBruDgRateM(Double perBruDgRateM) {
		this.perBruDgRateM = perBruDgRateM;
	}

	public Double getPerJapDensityN() {
		return perJapDensityN;
	}

	public void setPerJapDensityN(Double perJapDensityN) {
		this.perJapDensityN = perJapDensityN;
	}

	public Double getPerJapDensityF() {
		return perJapDensityF;
	}

	public void setPerJapDensityF(Double perJapDensityF) {
		this.perJapDensityF = perJapDensityF;
	}

	public Double getPerJapDensityM() {
		return perJapDensityM;
	}

	public void setPerJapDensityM(Double perJapDensityM) {
		this.perJapDensityM = perJapDensityM;
	}

	public Double getPerJapDgRateN() {
		return perJapDgRateN;
	}

	public void setPerJapDgRateN(Double perJapDgRateN) {
		this.perJapDgRateN = perJapDgRateN;
	}

	public Double getPerJapDgRateF() {
		return perJapDgRateF;
	}

	public void setPerJapDgRateF(Double perJapDgRateF) {
		this.perJapDgRateF = perJapDgRateF;
	}

	public Double getPerJapDgRateM() {
		return perJapDgRateM;
	}

	public void setPerJapDgRateM(Double perJapDgRateM) {
		this.perJapDgRateM = perJapDgRateM;
	}

	public Double getOtherDensityN() {
		return otherDensityN;
	}

	public void setOtherDensityN(Double otherDensityN) {
		this.otherDensityN = otherDensityN;
	}

	public Double getOtherDensityF() {
		return otherDensityF;
	}

	public void setOtherDensityF(Double otherDensityF) {
		this.otherDensityF = otherDensityF;
	}

	public Double getOtherDensityM() {
		return otherDensityM;
	}

	public void setOtherDensityM(Double otherDensityM) {
		this.otherDensityM = otherDensityM;
	}

	public Double getOtherDgRateN() {
		return otherDgRateN;
	}

	public void setOtherDgRateN(Double otherDgRateN) {
		this.otherDgRateN = otherDgRateN;
	}

	public Double getOtherDgRateF() {
		return otherDgRateF;
	}

	public void setOtherDgRateF(Double otherDgRateF) {
		this.otherDgRateF = otherDgRateF;
	}

	public Double getOtherDgRateM() {
		return otherDgRateM;
	}

	public void setOtherDgRateM(Double otherDgRateM) {
		this.otherDgRateM = otherDgRateM;
	}

	public Long getTotalN() {
		totalN = 0L;
		if (blaGermanicaN != null)
			totalN += blaGermanicaN;
		if (perAmericanaN != null)
			totalN += perAmericanaN;
		if (perAustralasiaeN != null)
			totalN += perAustralasiaeN;
		if (perFuliginosaN != null)
			totalN += perFuliginosaN;
		if (perBrunneaBurmeisterN != null)
			totalN += perBrunneaBurmeisterN;
		if (perJaponicaN != null)
			totalN += perJaponicaN;
		if (otherN != null)
			totalN += otherN;
		return this.totalN;
	}

	public void setTotalN(Long totalN) {
		this.totalN = totalN;
	}

	public Long getTotalF() {
		totalF = 0l;
		if (blaGermanicaF != null)
			totalF += blaGermanicaF;
		if (perAmericanaF != null)
			totalF += perAmericanaF;
		if (perAustralasiaeF != null)
			totalF += perAustralasiaeF;
		if (perFuliginosaF != null)
			totalF += perFuliginosaF;
		if (perBrunneaBurmeisterF != null)
			totalF += perBrunneaBurmeisterF;
		if (perJaponicaF != null)
			totalF += perJaponicaF;
		if (otherF != null)
			totalF += otherF;
		return this.totalF;
	}

	public void setTotalF(Long totalF) {
		this.totalF = total;
	}

	public Long getTotalM() {
		totalM = 0l;
		if (blaGermanicaM != null)
			totalM += blaGermanicaM;
		if (perAmericanaM != null)
			totalM += perAmericanaM;
		if (perAustralasiaeM != null)
			totalM += perAustralasiaeM;
		if (perFuliginosaM != null)
			totalM += perFuliginosaM;
		if (perBrunneaBurmeisterM != null)
			totalM += perBrunneaBurmeisterM;
		if (perJaponicaM != null)
			totalM += perJaponicaM;
		if (otherM != null)
			totalM += otherM;
		return this.totalM;
	}

	public void setTotalM(Long totalM) {
		this.totalM = totalM;
	}

	public Long getTotal() {
		total = totalN + totalF + totalM;
		return this.total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSpeciesCode() {
		if (this.speciesCode != null) {
			return this.speciesCode;
		} else {
			StringBuilder sb = new StringBuilder();
			if (blaGermanicaN != null || blaGerDensityF != null || blaGerDensityM != null)
				sb.append("1,");
			if (perAmericanaN != null || perAmericanaF != null || perAmericanaM != null)
				sb.append("2,");
			if (perAustralasiaeN != null || perAustralasiaeF != null || perAustralasiaeM != null)
				sb.append("3,");
			if (perFuliginosaN != null || perFuliginosaF != null || perFuliginosaM != null)
				sb.append("4,");
			if (perBrunneaBurmeisterN != null || perBrunneaBurmeisterF != null || perBrunneaBurmeisterM != null)
				sb.append("5,");
			if (perJaponicaN != null || perJaponicaF != null || perJaponicaM != null)
				sb.append("6,");
			if (otherN != null)
				sb.append("99,");
			if (sb.indexOf(",") > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			return sb.toString();
		}
	}

	public void setSpeciesCode(String speciesCode) {
		this.speciesCode = speciesCode;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}