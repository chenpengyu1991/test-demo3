package com.founder.fasf.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * @author DenggaoLi
 * 
 */
@SuppressWarnings("rawtypes")
public class RecordPair implements Comparable {
	private int leftId;
	private int rightId;	
	private MatchFlag matchFlag;
	private Double weight;
	

	public RecordPair(int leftId, int rightId) {
		this.setLeftId(leftId);
		this.setRightId(rightId);
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof RecordPair))
			return false;
		RecordPair castOther = (RecordPair) other;
		return new EqualsBuilder().append(leftId,castOther.getLeftId()).append(rightId,castOther.getRightId()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(leftId).append(rightId).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("leftId", leftId)
				.append("rightId", rightId).append("weight", weight).append("matchFlag",matchFlag)
				.toString();
	}

	public int getLeftId() {
		return leftId;
	}

	public void setLeftId(int leftId) {
		this.leftId = leftId;
	}


	public int getRightId() {
		return rightId;
	}


	public void setRightId(int rightId) {
		this.rightId = rightId;
	}



	
	public MatchFlag getMatchFlag() {
		return matchFlag;
	}

	
	public void setMatchFlag(MatchFlag matchFlag) {
		this.matchFlag = matchFlag;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	} 

	@Override
	public int compareTo(Object o) {
		RecordPair rp =(RecordPair)o;		
        return weight==null?-1: weight>rp.weight?(weight==rp.weight?-1:0):1;
	}
}
