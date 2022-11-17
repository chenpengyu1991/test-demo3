package com.founder.rhip.ehr.entity.ihm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "HM_TARGET_DIVISOR_LINK")
public class HmTargetDivisorLink implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "TARGET_CODE", columnDefinition = "VARCHAR2|指标编码||", length = 20, nullable = true)
	private String targetCode;

	@Column(name = "DIVISOR_CODE", columnDefinition = "VARCHAR2|因子编码||", length = 20, nullable = true)
	private String divisorCode;

	@Column(name = "OPERATOR_SYMBOL", columnDefinition = "VARCHAR2|运算符号||", length = 20, nullable = true)
	private String operatorSymbol;

	@Column(name = "OPERATOR_ORDER", columnDefinition = "NUMBER|运算顺序||", length = 1, nullable = true)
	private Long operatorOrder;

	@Column(name = "IS_DELETE", columnDefinition = "NUMBER|删除标志||", length = 1, nullable = true)
	private Long isDelete;

	public String getTargetCode() {
		return this.targetCode;
	}

	public void setTargetCode(String targetCode) {
		this.targetCode = targetCode;
	}

	public String getDivisorCode() {
		return this.divisorCode;
	}

	public void setDivisorCode(String divisorCode) {
		this.divisorCode = divisorCode;
	}

	public String getOperatorSymbol() {
		return this.operatorSymbol;
	}

	public void setOperatorSymbol(String operatorSymbol) {
		this.operatorSymbol = operatorSymbol;
	}

	public Long getOperatorOrder() {
		return this.operatorOrder;
	}

	public void setOperatorOrder(Long operatorOrder) {
		this.operatorOrder = operatorOrder;
	}

	public Long getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Long isDelete) {
		this.isDelete = isDelete;
	}

}