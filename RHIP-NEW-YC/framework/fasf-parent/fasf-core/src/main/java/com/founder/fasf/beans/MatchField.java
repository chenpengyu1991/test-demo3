package com.founder.fasf.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MatchField extends BaseField {
	private static final long serialVersionUID = -4012644666481353904L;
	private Double agreementProbability;
	private Double disagreementProbability;
	private Double agreementWeight;
	private Double disagreementWeight;
	private String functionName;
	private Double matchThreshold;
	private String nullValue;
	private Integer qualityNumber;	
	private Integer indexNumber;
	private boolean isComplexField;
	
	public MatchField() {
	}

	public MatchField(String fieldName,String propertyName,String nullValue,String functionName,Double matchThreshold,Double agreementProbability,Double disagreementProbability,Double agreementWeight,Double disagreementWeight){
		this.fieldName = fieldName;
		this.propertyName=propertyName;
		this.nullValue = nullValue;
		this.functionName = functionName;
		this.matchThreshold = matchThreshold;
		this.agreementProbability = agreementProbability;
		this.disagreementProbability = disagreementProbability;
		this.agreementWeight = agreementWeight;
		this.disagreementWeight = disagreementWeight;

	}
	public Double getAgreementProbability() {
		return agreementProbability;
	}

	public void setAgreementProbability(Double agreementProbability) {
		this.agreementProbability = agreementProbability;
	}

	public Double getDisagreementProbability() {
		return disagreementProbability;
	}

	public void setDisagreementProbability(Double disagreementProbability) {
		this.disagreementProbability = disagreementProbability;
	}

	public Double getMatchThreshold() {
		return matchThreshold;
	}

	public void setMatchThreshold(Double matchThreshold) {
		this.matchThreshold = matchThreshold;
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof MatchField))
			return false;
		MatchField castOther = (MatchField) other;
		return new EqualsBuilder()
				.append(fieldName, castOther.fieldName)
				.append(agreementProbability, castOther.agreementProbability)
				.append(disagreementProbability,castOther.disagreementProbability)
				//.append(comparatorFunction, castOther.comparatorFunction)
				.append(matchThreshold, castOther.matchThreshold).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(fieldName)
				.append(agreementProbability).append(disagreementProbability)
				//.append(comparatorFunction)
				.append(matchThreshold).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append(super.toString())
				.append("agreementProbability", agreementProbability)
				.append("disagreementProbability", disagreementProbability)
				//.append("comparatorFunctionName", comparatorFunction)
				.append("matchThreshold", matchThreshold).toString();
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getNullValue() {
		return nullValue;
	}

	public void setNullValue(String nullValue) {
		this.nullValue = nullValue;
	}

	public Integer getQualityNumber() {
		return qualityNumber;
	}

	public void setQualityNumber(Integer qualityNumber) {
		this.qualityNumber = qualityNumber;
	}

	public boolean isComplexField() {
		return isComplexField;
	}

	public void setComplexField(boolean isComplexField) {
		this.isComplexField = isComplexField;
	}

	public Integer getIndexNumber() {
		return indexNumber;
	}

	public void setIndexNumber(Integer indexNumber) {
		this.indexNumber = indexNumber;
	}

	
	public Double getAgreementWeight() {
		return agreementWeight;
	}

	
	public void setAgreementWeight(Double agreementWeight) {
		this.agreementWeight = agreementWeight;
	}

	
	public Double getDisagreementWeight() {
		return disagreementWeight;
	}

	
	public void setDisagreementWeight(Double disagreementWeight) {
		this.disagreementWeight = disagreementWeight;
	}

}
