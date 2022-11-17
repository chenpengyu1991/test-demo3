<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="postcontent">
	<div style="padding-left: 15px; padding-right: 15px; width: auto;" class="postdiv">
	  <form id="adminForm">
			<table id="frList">
				<colgroup>
					<col style="width: 50%" />
					<col style="width: 50%" />
				</colgroup>
				<c:forEach var="used" items="${useds}" varStatus="status">
			        <c:if test="${status.index%2==0}"><tr></c:if>
			            <td>
			            	<input name="villageCodes" type="checkbox" value="${used.areaCode}" checked="checked" onchange="organizationInfoEdit.getVillageCode()"/>
			            	${used.itemName}
			            </td>
			        <c:if test="${status.count%2==0}"></tr></c:if>
			    </c:forEach>
			    <c:forEach var="dicItem" items="${noParents}" varStatus="status">
			        <c:if test="${status.index%2==0}"><tr></c:if>
			            <td>
			            	<input name="villageCodes" type="checkbox" value="${dicItem.itemCode}" onchange="organizationInfoEdit.getVillageCode()"/>
			            	<label id="${dicItem.itemCode}">${dicItem.itemName}</label>
			            </td>
			        <c:if test="${status.count%2==0}"></tr></c:if>
			    </c:forEach>
			</table>
		</form>
		<p style="margin-top: 15px;" align="center">
			<input type="button" id="sureButton" value="确定" class="btnopr" onclick="villageAdd.closePopUp('villageDia')"/> 
		</p>
	</div>
</div>
