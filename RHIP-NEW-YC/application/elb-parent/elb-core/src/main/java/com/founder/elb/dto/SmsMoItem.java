package com.founder.elb.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class SmsMoItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID",columnDefinition="NUMBER|标识",length=11,nullable=true)
	private Integer id;
	
	@Column(name = "RETURN_CNT", columnDefinition = "int|返回短信件数", length = 8, nullable = true)
	private int returnCnt;
	
	@Column(name = "MOBILES", columnDefinition = "String|发送短信的手机号码", length = 15, nullable = true)
	private String[] mobiles;
	
	@Column(name = "CONTENTS", columnDefinition = "String|短信回复内容", length = 1000, nullable = true)
	private String[] contents;
	
	@Column(name = "MO_TIMES", columnDefinition = "String|短信回复时间", length = 20, nullable = true)
	private String[] moTimes;
	
	@Column(name = "SM_IDS", columnDefinition = "long|短信尾码", length = 4, nullable = true)
	private long[] smIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getReturnCnt() {
		return returnCnt;
	}

	public void setReturnCnt(int returnCnt) {
		this.returnCnt = returnCnt;
	}

	public String[] getMobiles() {
		return mobiles;
	}

	public void setMobiles(String[] mobiles) {
		this.mobiles = mobiles;
	}

	public String[] getContents() {
		return contents;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}

	public String[] getMoTimes() {
		return moTimes;
	}

	public void setMoTimes(String[] moTimes) {
		this.moTimes = moTimes;
	}

	public long[] getSmIds() {
		return smIds;
	}

	public void setSmIds(long[] smIds) {
		this.smIds = smIds;
	}
	

}