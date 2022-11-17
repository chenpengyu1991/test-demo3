<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tag" %>
<%--病原学检测结果--%>
<div  class="repeattable">
<table>
	<colgroup>
        <%--不要超过520px--%>
		<col style="width:60px;"/>
		<col style="width:80px;"/>
        <col style="width:100px;"/>
		<col style="width:100px;"/>
		<col style="width:100px;"/>
		<col style="width:100px;"/>		
	</colgroup>	
	<thead>
		<tr>
			<th class="centerth" style="vertical-align:middle;" rowspan="2">标本类型</th>
	        <th class="centerth" style="vertical-align:middle;" rowspan="2">采样时间</th>
	        <th class="centerth" colspan="4">检测项目及结果</th>
		</tr>
		<tr>
	        <th class="centerth">PCR</th>
	        <th class="centerth">RT-PCR</th>
	        <th class="centerth">核酸测序</th>
	        <th class="centerth">病毒分离</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>粪便</td>
			<td>
				<tag:dateInput nullToToday="true" name="labExamine.stoolCollecttime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.labExamine.stoolCollecttime}" onlypast="true" style="width: 80px"></tag:dateInput> 			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.stoolPcr" dicmeta="PH00004" value="${caseDto.labExamine.stoolPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.stoolRtPcr" dicmeta="PH00004" value="${caseDto.labExamine.stoolRtPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.stoolSequencing" dicmeta="PH00004" value="${caseDto.labExamine.stoolSequencing}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.stoolViralIsolation" dicmeta="PH00004" value="${caseDto.labExamine.stoolViralIsolation}"
					code="1,2,3" />			
			</td>									
		</tr>
		<tr>
			<td>咽拭液</td>
			<td>
				<tag:dateInput nullToToday="true" name="labExamine.throatSwabCollecttime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.labExamine.throatSwabCollecttime}" onlypast="true" style="width: 80px"></tag:dateInput> 			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.throatSwabPcr" dicmeta="PH00004" value="${caseDto.labExamine.throatSwabPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.throatSwabRtPcr" dicmeta="PH00004" value="${caseDto.labExamine.throatSwabRtPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.throatSwabSequencing" dicmeta="PH00004" value="${caseDto.labExamine.throatSwabSequencing}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.throatSwabViralIsolation" dicmeta="PH00004" value="${caseDto.labExamine.throatSwabViralIsolation}"
					code="1,2,3" />			
			</td>									
		</tr>
		<tr>
			<td>痰</td>
			<td>
				<tag:dateInput nullToToday="true" name="labExamine.phlegmCollecttime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.labExamine.phlegmCollecttime}" onlypast="true" style="width: 80px"></tag:dateInput> 			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.phlegmPcr" dicmeta="PH00004" value="${caseDto.labExamine.phlegmPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.phlegmRtPcr" dicmeta="PH00004" value="${caseDto.labExamine.phlegmRtPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.phlegmSequencing" dicmeta="PH00004" value="${caseDto.labExamine.phlegmSequencing}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.phlegmViralIsolation" dicmeta="PH00004" value="${caseDto.labExamine.phlegmViralIsolation}"
					code="1,2,3" />			
			</td>									
		</tr>
		<tr>
			<td>血液</td>
			<td>
				<tag:dateInput nullToToday="true" name="labExamine.bloodCollecttime" pattern="yyyy/MM/dd" 
	            	date="${caseDto.labExamine.bloodCollecttime}" onlypast="true" style="width: 80px"></tag:dateInput> 			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.bloodPcr" dicmeta="PH00004" value="${caseDto.labExamine.bloodPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.bloodRtPcr" dicmeta="PH00004" value="${caseDto.labExamine.bloodRtPcr}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.bloodSequencing" dicmeta="PH00004" value="${caseDto.labExamine.bloodSequencing}"
					code="1,2,3" />			
			</td>
			<td>
        		<ehr:dic-list  name="labExamine.bloodViralIsolation" dicmeta="PH00004" value="${caseDto.labExamine.bloodViralIsolation}"
					code="1,2,3" />			
			</td>									
		</tr>						
	</tbody>
</table>
</div>


