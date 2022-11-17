<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr" %>

<script src="${pageContext.request.contextPath}/js/views/cdm/reportCard/tumor.js" type="text/javascript"></script>

<form id="tumorFormId">
	<input type="hidden" id="organCodeId" value="${orgCode}"/>
	<div class="repeattable">
		<table class="posttable" id="tumorTableId">
			<tr>
				<th>肿瘤病名</th>
				<!-- <th>ICD-10编码</th> -->
				<th>诊断日期</th>
			</tr>
			<c:forEach var="tumor" items="${tumors}">
				<tr>
					<td>
						<label>
							<input type="radio" name="tumorIcdTenCode" reg="{'required':true}"
								   class="chk_selectone" value="${tumor.tumorIcdTenCode}"
								   data-id="${tumor.id}"
								   data-tumor-type="${tumor.tumorType}"
								   data-tumor-accident-date="<fmt:formatDate value="${tumor.tumorAccidentDate}" pattern="yyyy/MM/dd"/>"
								   data-tumor-diagnosis-date="<fmt:formatDate value="${tumor.tumorDiagnosisDate}" pattern="yyyy/MM/dd"/>"/> ${tumor.tumorType}

						</label>
					</td>
					<%-- <td>
						${tumor.tumorIcdTenCode}
					</td> --%>
					<td><fmt:formatDate value="${tumor.tumorDiagnosisDate}" pattern="yyyy/MM/dd"/></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="toolbarpop" style="padding: 0 0px 10px;">
		<input type="button" id="saveContact" value="保存" onclick="tumorAdd.saveOptionData('add','${rowIndex}')" class="btnopr">
		<input type="button" id="cancelContact" value="取消" onclick="tumorAdd.closeDialog()" class="btnopr">
	</div>
</form>


