<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/flyAdd.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
	  <form:form id="flyForm" modelAttribute="fly" >
	  	<input type="hidden" name="createBy" value="${createBy}" />
		<input type="hidden" name="createTime" value="${createTime}" />
	  	<form:hidden path="monitorId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset>
			<legend>捕蝇记录:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">环境类型</label></th>
					<td>
						<ehr:dic-list name="environment" dicmeta="DMBC00007" reg='{"required":"true"}' value="${fly.environment}"/>
					</td>
				</tr>
				<tr>
					<th ><label class="required">地点</label></th>
					<td><form:input path="place" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr>
					<th ><label class="required">蝇笼数</label></th>
					<td><form:input path="cageCount" reg='{"required":"true","digits":"true","maxlength":"5"}'/></td>
				</tr>
				<tr>
					<th><label >家蝇</label></th>
					<td>
						<form:input path="houseFly" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >市蝇</label></th>
					<td>
						<form:input path="muscaSorbens" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >丝光绿蝇</label></th>
					<td>
						<form:input path="lucilliaSericata" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >铜绿蝇</label></th>
					<td>
						<form:input path="luciliaCuprina" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				
				<tr>
					<th><label >亮绿蝇</label></th>
					<td>
						<form:input path="luciliaIllustris" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >大头金蝇</label></th>
					<td>
						<form:input path="chrysomyiaMegacephala" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >伏蝇</label></th>
					<td>
						<form:input path="phormiaRegina" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				
				<tr>
					<th><label >新陆原伏蝇</label></th>
					<td>
						<form:input path="protophormiaTerraenovae" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >巨尾阿丽蝇</label></th>
					<td>
						<form:input path="aldrichinaGrahami" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >红头丽蝇</label></th>
					<td>
						<form:input path="calliphoraVicina" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >厩腐蝇</label></th>
					<td>
						<form:input path="muscinaStabulans" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >夏厕蝇</label></th>
					<td>
						<form:input path="fanniaCanicularis" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >元厕蝇</label></th>
					<td>
						<form:input path="fanniaPrisca" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>	
				<tr>
					<th><label >棕尾别麻蝇</label></th>
					<td>
						<form:input path="boettcheriscaPeregrina" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th><label >其它</label></th>
					<td>
						<form:input path="other" reg='{"digits":"true","maxlength":"3"}'/>
					</td>
				</tr>
				<tr>
					<th>备注</th>
					<td><form:textarea path="remarks"  reg='{"maxlength":"40"}' /></td>
				</tr>
			</table>
		</fieldset>
		</form:form>
		<p style="margin-top: 15px;" align="center">
			<input type="button" id="saveButton" value="保 存" class="btnopr" /> 
			<input type="button" id="cancelButton" value="关 闭" class="btnopr" />
		</p>
	</div>
</div>
