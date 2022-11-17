<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <script src="${pageContext.request.contextPath}/js/views/cdm/standardization/cancel/renew.js" type="text/javascript"></script>

<div>
	<div class="toolbar">
	 <%-- <a href="javascript:void(0)" id="save"><b class="baocun">恢复</b></a> --%>
	 <a href="javascript:void(0)" id="save"><button class="layui-btn layui-btn-sm button"><i class="layui-icon">&#xe669;</i>恢复</button></a>
	</div>
	<form id="rollbackForm">
		<div class="postcontent">
			<input type="hidden" name="id" value="${dmDiseaseInfo.id}"/>
			<input type="hidden" name="personId" value="${dmDiseaseInfo.personId}"/>

			<table class="posttable" style="margin-top:50px;">
				<colgroup>
					<col style="width: 30%;"/>
					<col style="width: 70%;"/>
				</colgroup>
					<tr>
						<th><label class="required">患病类型：</label></th>
						<td>
							<c:if test="${dmDiseaseInfo.hbpFlag eq '1'}">
								<input name="hbpFlag" value="${dmDiseaseInfo.hbpFlag}" type="checkbox">高血压</input>
							</c:if>
							<c:if test="${dmDiseaseInfo.diFlag eq '1'}">
								<input name="diFlag" value="${dmDiseaseInfo.diFlag}" type="checkbox">糖尿病</input>
							</c:if>
							<c:if test="${dmDiseaseInfo.tumorFlag eq '1'}">
								<input name="tumorFlag" value="${dmDiseaseInfo.tumorFlag}" type="checkbox">肿瘤</input>
							</c:if>
							<c:if test="${dmDiseaseInfo.coronaryFlag eq '1'}">
								<input name="coronaryFlag" value="${dmDiseaseInfo.coronaryFlag}" type="checkbox">冠心病</input>
							</c:if>
							<c:if test="${dmDiseaseInfo.strokeFlag eq '1'}">
								<input name="strokeFlag" value="${dmDiseaseInfo.strokeFlag}" type="checkbox">脑卒中</input>
							</c:if>
						</td>
					</tr>
			</table>
		</div>
	</form>
</div>