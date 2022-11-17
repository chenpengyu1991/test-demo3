package com.founder.rhip.ehr.statisticsdto;

import com.founder.fasf.util.NumberUtil;

/**
 * 慢病和肿瘤年报
 * @author liuk
 *
 */
public class DmYearReport {

	public DmYearReport() {
	}

	public DmYearReport(String disType, String subDisType) {
		super();
		this.disType = disType;
		this.subDisType = subDisType;
	}

	public DmYearReport(String disType, String subDisType, String subDisTypeName) {
		super();
		this.disType = disType;
		this.subDisType = subDisType;
		this.subDisTypeName = subDisTypeName;
	}
	
	

	public DmYearReport(String disType) {
		super();
		this.disType = disType;
	}

	private String disType;
	private String disTypeName;
	private String subDisType;
	private String subDisTypeName;
	private Integer manCount = 0;
	private Integer wmmanCount = 0;
	private Integer total = 0;
	private Double manIncidence = 0.0D;
	private Double wmmanIncidence = 0.0D;
	private Double totalIncidence = 0.0D;
	private boolean isSum;
	private Integer zero = 0;
	private Integer one = 0;
	private Integer two = 0;
	private Integer three = 0;
	private Integer four = 0;
	private Integer five = 0;
	private Integer six = 0;
	private Integer serven = 0;
	private Integer eight = 0;
	private Integer nine = 0;
	private Integer ten = 0;
	private Integer eleven = 0;
	private Integer twelve = 0;
	private Integer thirteen = 0;
	private Integer fourteen = 0;
	private Integer fifteen = 0;
	private Integer sixteen = 0;
	private Integer seventeen = 0;
	private Integer eighteen = 0;
	private Integer nineteen = 0;
	private Double subIncidence = 0.0D;

	public void calIncidence(Integer manTotalCount, Integer wmTotalCount, Integer totalCount) {
		if (null!=manTotalCount&&manTotalCount>0) {
			manIncidence = NumberUtil.div(this.manCount * 100000, manTotalCount, 4);
		}
		if (null!=wmTotalCount&&wmTotalCount>0) {
			wmmanIncidence = NumberUtil.div(this.wmmanCount * 100000, wmTotalCount, 4);
		}
		if (null!=totalCount&&totalCount>0) {
			totalIncidence = NumberUtil.div(this.total * 100000, totalCount, 4);
		}
	
	}

	public void calSubIncidence(Integer totalCount) {
		if (null!=totalCount&&totalCount>0) {
			subIncidence = NumberUtil.div(this.total, totalCount, 4);
		}
	}

	public void add(DmYearReport dmYearReport) {
		manCount += dmYearReport.getManCount();
		wmmanCount += dmYearReport.getWmmanCount();
		total += dmYearReport.getTotal();
		zero += dmYearReport.getZero();
		one += dmYearReport.getOne();
		two += dmYearReport.getTwo();
		three += dmYearReport.getThree();
		four += dmYearReport.getFour();
		five += dmYearReport.getFive();
		six += dmYearReport.getSix();
		serven += dmYearReport.getServen();
		eight += dmYearReport.getEight();
		nine += dmYearReport.getNine();
		ten += dmYearReport.getTen();
		eleven += dmYearReport.getEleven();
		twelve += dmYearReport.getTwelve();
		thirteen += dmYearReport.getThirteen();
		fourteen += dmYearReport.getFourteen();
		fifteen += dmYearReport.getFifteen();
		sixteen += dmYearReport.getSixteen();
		seventeen += dmYearReport.getSeventeen();
		eighteen += dmYearReport.getEighteen();
		nineteen += dmYearReport.getNineteen();
	}

	public String getSubDisType() {
		return subDisType;
	}

	public void setSubDisType(String subDisType) {
		this.subDisType = subDisType;
	}

	public Integer getManCount() {
		return manCount;
	}

	public void setManCount(Integer manCount) {
		this.manCount = manCount;
	}

	public Integer getWmmanCount() {
		return wmmanCount;
	}

	public void setWmmanCount(Integer wmmanCount) {
		this.wmmanCount = wmmanCount;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public boolean isSum() {
		return isSum;
	}

	public void setSum(boolean isSum) {
		this.isSum = isSum;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public Double getManIncidence() {
		return manIncidence;
	}

	public void setManIncidence(Double manIncidence) {
		this.manIncidence = manIncidence;
	}

	public Double getWmmanIncidence() {
		return wmmanIncidence;
	}

	public void setWmmanIncidence(Double wmmanIncidence) {
		this.wmmanIncidence = wmmanIncidence;
	}

	public Double getTotalIncidence() {
		return totalIncidence;
	}

	public void setTotalIncidence(Double totalIncidence) {
		this.totalIncidence = totalIncidence;
	}

	public Integer getOne() {
		return one;
	}

	public void setOne(Integer one) {
		this.one = one;
	}

	public Integer getThree() {
		return three;
	}

	public void setThree(Integer three) {
		this.three = three;
	}

	public Integer getFour() {
		return four;
	}

	public void setFour(Integer four) {
		this.four = four;
	}

	public Integer getFive() {
		return five;
	}

	public void setFive(Integer five) {
		this.five = five;
	}

	public Integer getSix() {
		return six;
	}

	public void setSix(Integer six) {
		this.six = six;
	}

	public Integer getServen() {
		return serven;
	}

	public void setServen(Integer serven) {
		this.serven = serven;
	}

	public Integer getEight() {
		return eight;
	}

	public void setEight(Integer eight) {
		this.eight = eight;
	}

	public Integer getNine() {
		return nine;
	}

	public void setNine(Integer nine) {
		this.nine = nine;
	}

	public Integer getTen() {
		return ten;
	}

	public void setTen(Integer ten) {
		this.ten = ten;
	}

	public Integer getEleven() {
		return eleven;
	}

	public void setEleven(Integer eleven) {
		this.eleven = eleven;
	}

	public Integer getTwelve() {
		return twelve;
	}

	public void setTwelve(Integer twelve) {
		this.twelve = twelve;
	}

	public Integer getThirteen() {
		return thirteen;
	}

	public void setThirteen(Integer thirteen) {
		this.thirteen = thirteen;
	}

	public Integer getFourteen() {
		return fourteen;
	}

	public void setFourteen(Integer fourteen) {
		this.fourteen = fourteen;
	}

	public Integer getFifteen() {
		return fifteen;
	}

	public void setFifteen(Integer fifteen) {
		this.fifteen = fifteen;
	}

	public Integer getSixteen() {
		return sixteen;
	}

	public void setSixteen(Integer sixteen) {
		this.sixteen = sixteen;
	}

	public Integer getSeventeen() {
		return seventeen;
	}

	public void setSeventeen(Integer seventeen) {
		this.seventeen = seventeen;
	}

	public Integer getEighteen() {
		return eighteen;
	}

	public void setEighteen(Integer eighteen) {
		this.eighteen = eighteen;
	}

	public Integer getNineteen() {
		return nineteen;
	}

	public void setNineteen(Integer nineteen) {
		this.nineteen = nineteen;
	}

	public Double getSubIncidence() {
		return subIncidence;
	}

	public void setSubIncidence(Double subIncidence) {
		this.subIncidence = subIncidence;
	}

	public Integer getTwo() {
		return two;
	}

	public void setTwo(Integer two) {
		this.two = two;
	}

	public Integer getZero() {
		return zero;
	}

	public void setZero(Integer zero) {
		this.zero = zero;
	}

	public String getSubDisTypeName() {
		return subDisTypeName;
	}

	public void setSubDisTypeName(String subDisTypeName) {
		this.subDisTypeName = subDisTypeName;
	}

	public String getDisTypeName() {
		return disTypeName;
	}

	public void setDisTypeName(String disTypeName) {
		this.disTypeName = disTypeName;
	}
}
