<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  tagdir="/WEB-INF/tags" prefix="tag"%>
<script src="${pageContext.request.contextPath}/js/views/idm/malaria/distribution.js" type="text/javascript"></script>
<div class="postcontent">
	<div style="background: none repeat scroll 0 0 #FFFCEB;border: 1px solid #EED97C;padding: 0 5px;">
		<div style="border-bottom: 1px dotted #EED97C;height: 25px;line-height: 25px;padding: 4px 8px;">
		<strong>当前选择人员：</strong>
		</div>
		<div style="padding: 10px 8px;">
			${names}
		</div>
	</div>
	<form id="distributionForm">
		<input type="hidden" id="ids" value="${ids}">
		<div class="postdiv">
			<div class="toolbarsublist">
				<table class="formtable">
					<colgroup>
						<col style="width:15%;"/>
						<col style="width:85%;"/>
					</colgroup>					
						<tr>
							<th><label class="required">分配单位:</label></th>
							<td>
								<ehr:dic-town-centre-station centreId="acceptUnitId" centreName="acceptUnit" centreValue="${acceptUnit}" stationName="" 
									townId="acceptTownId" townName="acceptTown" townValue="${acceptTown}"  style="width:220px;"/>
							</td>
						</tr>
				</table>
			</div>
		</div>	
	</form>
	<br>
	<div class="toolbarpop">
		<input type="button" id="distributionBtn" name="distribution" value="分配" onclick="distribution.save()">
		<input type="button" id="cancelDisBtn" name="cancelDis" value="取消" onclick="idmCommon.closePopUp('disDialog')">
	</div>
</div>