<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<script src="${pageContext.request.contextPath}/js/views/dmbc/vertor/roachAdd.js" type="text/javascript"></script>
<div>
	<div class="postcontent">
	  <form:form id="roachForm" modelAttribute="roach" >
	  	<form:hidden path="createBy" />
		<form:hidden path="createTime" />
	  	<form:hidden path="monitorId" />
	  	<form:hidden path="id" />
	  	<form:hidden path="isDelete" value="0" />
	  	<input type="hidden" id="type" value="${type}" />
		<fieldset>
			<legend>捕蟑螂记录:</legend>
			<table class="formtable">
				<tr>
					<th ><label class="required">布放场所</label></th>
					<td><form:input path="place" reg='{"required":"true","maxlength":"20"}'/></td>
				</tr>
				<tr ><th rowspan="4"><label >德国小蠊</label></th></tr>
				<tr>
					
					<td>
						<label >若</label>
						<form:input path="blaGermanicaN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="blaGerDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="blaGerDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						
					</td>
				</tr><tr>
					<td>
						<label >雌</label>
						<form:input path="blaGermanicaF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="blaGerDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="blaGerDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						
					</td>
				</tr><tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="blaGermanicaM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="blaGerDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="blaGerDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr ><th rowspan="4"><label >美洲大蠊</label></th></tr>
				<tr>
					<td>
						<label >若</label>
						<form:input path="perAmericanaN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perAmeDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perAmeDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr>
					<td>
					<label>雌</label>
					<form:input path="perAmericanaF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
					<label>密度</label>
					<form:input path="perAmeDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					<label >侵害率</label>
					<form:input path="perAmeDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>	
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="perAmericanaM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perAmeDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perAmeDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr ><th rowspan="4"><label >澳洲大蠊</label></th></tr>
				<tr>
					<td>
						<label >若</label>
						<form:input path="perAustralasiaeN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perAusDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perAusDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr>
					<td>
						<label >雌</label>
						<form:input path="perAustralasiaeF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perAusDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perAusDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="perAustralasiaeM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perAusDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perAusDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr ><th rowspan="4"><label >黑胸大蠊</label></th></tr>
				<tr>
					<td>
						<label >若</label>
						<form:input path="perFuliginosaN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perFulDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perFulDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr>
					<td>
						<label >雌</label>
						<form:input path="perFuliginosaF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perFulDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perFulDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="perFuliginosaM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perFulDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perFulDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr ><th rowspan="4"><label >褐斑大蠊</label></th></tr>
				<tr>
					<td>
						<label >若</label>
						<form:input path="perBrunneaBurmeisterN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perBruDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perBruDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr>
					<td>
						<label >雌</label>
						<form:input path="perBrunneaBurmeisterF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perBruDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perBruDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="perBrunneaBurmeisterM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perBruDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perBruDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr ><th rowspan="4"><label >日本大蠊</label></th></tr>
				<tr>
					<td>
						<label >若</label>
						<form:input path="perJaponicaN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perJapDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perJapDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr>
					<td>
						<label >雌</label>
						<form:input path="perJaponicaF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perJapDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perJapDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="perJaponicaM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="perJapDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="perJapDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr ><th rowspan="4"><label >其它</label></th></tr>
				<tr>
					<td>
						<label >若</label>
						<form:input path="otherN" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="otherDensityN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="otherDgRateN" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr>
					<td>
						<label >雌</label>
						<form:input path="otherF" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="otherDensityF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="otherDgRateF" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
					</td>
				</tr>
				<tr style="border-bottom:1px solid #A9C3D0">
					<td>
						<label >雄</label>
						<form:input path="otherM" reg='{"digits":"true","maxlength":"3"}' style="width:40px"/>
						<label >密度</label>
						<form:input path="otherDensityM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
						<label >侵害率</label>
						<form:input path="otherDgRateM" reg='{"number":"true","scale":2,"max":999.99}' style="width:40px"/>
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
