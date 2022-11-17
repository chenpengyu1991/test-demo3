<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:100px;width: 10%;"/>
			<col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
	        <col style="min-width:100px;width: 10%;"/>
		</colgroup>
		<thead>
			<tr>
				<th>医疗机构</th>
                <th title="退药单/发票">单据号</th>
				<th>退药类型</th>
				<th>退药科室</th>
				<th>退往药房</th>
				<th>病人姓名</th>
				<th>门诊号</th>
				<th>住院号</th>
				<th>退药日期</th>
				<th>备注</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pharmacyCancel" items="${pharmacyCancels}" varStatus="status">
				<tr>
					<td><ehr:tip><ehr:org  code="${pharmacyCancel.ORGAN_CODE}"/></ehr:tip></td>
                    <td>
						<c:choose>
	                        <c:when test='${pharmacyCancel.CANCEL_TYPE_CODE == "3"}'><ehr:tip>${pharmacyCancel.INVOICE_NO}</ehr:tip></c:when>
	                        <c:otherwise><ehr:tip>${pharmacyCancel.BATCH_NO}</ehr:tip></c:otherwise>
		                </c:choose>	                    
                    </td>
                    <td><ehr:tip><ehr:dic dicmeta="DA00013" code="${pharmacyCancel.CANCEL_TYPE_CODE}"/></ehr:tip></td>
                    <td><ehr:tip>${pharmacyCancel.CANCEL_DEPARTMENT_NAME}</ehr:tip></td>
                    <td>
                    <ehr:tip>
                    <ehr:dic dicmeta="DA00015" code="${pharmacyCancel.TARGET_PHARMACY_TYPE}"/>
                    </ehr:tip>
                    </td>     
                    <td><ehr:tip>${pharmacyCancel.PATIENT_NAME}</ehr:tip></td>   
                    <td>
                    	<c:if test='${pharmacyCancel.PATIENT_TYPE == "1" || pharmacyCancel.PATIENT_TYPE =="2"}'>
                    		<ehr:tip>${pharmacyCancel.PATIENT_MZH}</ehr:tip>
                    	</c:if>
                    </td>   
                    <td>
                    	<c:if test='${pharmacyCancel.PATIENT_TYPE == "3"}'>
                    		<ehr:tip>${pharmacyCancel.PATIENT_MZH}</ehr:tip>
                    	</c:if>					
					</td>                  
                    <td><ehr:tip><fmt:formatDate value="${pharmacyCancel.CANCEL_DT}" pattern="yyyy/MM/dd" /></ehr:tip></td>
                    <td><ehr:tip>${pharmacyCancel.COMMENTS}</ehr:tip></td>
                    <td>
                    	<a href="javascript:void(0)" onclick="pharmacyCancelSearch.detailSearch('${pharmacyCancel.BATCH_NO}')" class="person-link-btn">查看</a>
                    </td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="pharmacyCancelSearch.search" colspan="11"/>
		</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="pharmacyCancelSearch.search" />
		</tr>
	</table> --%>
</div>