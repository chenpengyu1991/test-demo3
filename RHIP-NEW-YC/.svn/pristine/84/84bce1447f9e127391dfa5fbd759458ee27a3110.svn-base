<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="tubercCensusTable" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 10%;" />
			<col style="width: 18%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
			<col style="width: 9%;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">区县</th>
				<th rowspan="2">机构</th>
				<th colspan="8">肺结核患者健康管理统计报表</th>
			</tr>
			<tr>
				<th>辖区同期内经上级定点医疗机构确诊并通知基层医疗卫生机构管理的肺结核患者人数</th>
				<th>已管理的肺结核患者人数</th>
				<th>肺结核患者管理率</th>
				<th>同期辖区内已完成治疗的肺结核患者人数</th>
				<th>按照要求规则服药的肺结核患者人数</th>
				<th>肺结核患者规则服药率</th>
				<th>推介转诊结核病患者人数</th>
				<th>推介转诊率</th>
			</tr>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
					</td>
					<td>
						<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
					</td>
					<td title="${report.tubercNum }">${report.tubercNum }</td>
					<td title="${report.tubercManageNum }">${report.tubercManageNum }</td>
					<td title="<fmt:formatNumber value="${report.tubercNum==0?0:(report.tubercManageNum/report.tubercNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.tubercNum==0?0:(report.tubercManageNum/report.tubercNum)*100}" pattern="#,##0.0"/>% 
					</td>
					<td title="${report.tubercCureNum }">${report.tubercCureNum }</td>
					<td title="${report.tubercMedicationNum }">${report.tubercMedicationNum }</td>
					<td title="<fmt:formatNumber value="${report.tubercCureNum==0?0:(report.tubercMedicationNum/report.tubercCureNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.tubercCureNum==0?0:(report.tubercMedicationNum/report.tubercCureNum)*100}" pattern="#,##0.0"/>% 
					</td>
					<td title="${report.referralTbNum}">${report.referralTbNum}
					<input type="hidden" value="${report.householdNum}">
					<input type="hidden" value="${report.householdNum*0.002}">
					</td>
					<td title="<fmt:formatNumber value="${report.householdNum==0?0:(report.referralTbNum/(report.householdNum*0.002))*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${report.householdNum==0?0:(report.referralTbNum/(report.householdNum*0.002))*100}" pattern="#,##0.0"/>% 
					</td>
				</tr>
			</c:forEach>
			<c:if test="${tuberculosisServiceDto!=null}">
				<tr>
					<td colspan="2"><strong>合计</strong></td>
					<td title="${tuberculosisServiceDto.tubercNum }">${tuberculosisServiceDto.tubercNum }</td>
					<td title="${tuberculosisServiceDto.tubercManageNum }">${tuberculosisServiceDto.tubercManageNum }</td>
					<td title="<fmt:formatNumber value="${tuberculosisServiceDto.tubercNum==0?0:(tuberculosisServiceDto.tubercManageNum/tuberculosisServiceDto.tubercNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${tuberculosisServiceDto.tubercNum==0?0:(tuberculosisServiceDto.tubercManageNum/tuberculosisServiceDto.tubercNum)*100}" pattern="#,##0.0"/>% 
					</td>
					<td title="${tuberculosisServiceDto.tubercCureNum }">${tuberculosisServiceDto.tubercCureNum }</td>
					<td title="${tuberculosisServiceDto.tubercMedicationNum }">${tuberculosisServiceDto.tubercMedicationNum }</td>
					<td title="<fmt:formatNumber value="${tuberculosisServiceDto.tubercCureNum==0?0:(tuberculosisServiceDto.tubercMedicationNum/tuberculosisServiceDto.tubercCureNum)*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${tuberculosisServiceDto.tubercCureNum==0?0:(tuberculosisServiceDto.tubercMedicationNum/tuberculosisServiceDto.tubercCureNum)*100}" pattern="#,##0.0"/>% 
					</td>
					<td title="${tuberculosisServiceDto.referralTbNum}">${tuberculosisServiceDto.referralTbNum}
					 <input type="hidden" value="${tuberculosisServiceDto.householdNum}">
					</td>
					<td title="<fmt:formatNumber value="${tuberculosisServiceDto.householdNum==0?0:(tuberculosisServiceDto.referralTbNum/(tuberculosisServiceDto.householdNum*0.002))*100}" pattern="#,##0.0"/>%">
						<fmt:formatNumber value="${tuberculosisServiceDto.householdNum==0?0:(tuberculosisServiceDto.referralTbNum/(tuberculosisServiceDto.householdNum*0.002))*100}" pattern="#,##0.0"/>% 
					</td>
				</tr>
			</c:if>
		</tbody>
		
		<tbody id="editBody" style="display: none">
    <c:forEach items="${reportList}" var="report" varStatus="status">
        <tr>
            <td title=<ehr:org code="${report.orgCode}"></ehr:org>>
               <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].id" value="${report.id }">
               <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].orgCode" value="${report.orgCode }">
               <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].year" value="${report.year }">
               <input type="hidden" name="TuberculosisDto.TuberculosisDtoList[${status.index }].orgName" readonly="readonly" value="${report.orgName }"/>
           
				<ehr:tip><ehr:dic code="${report.gbCode}" dicmeta="FS990001"  /></ehr:tip>
			</td>
			<td>
				<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
			</td>
              <td>
                <input type="text" id="tubercNum_id" name="TuberculosisDto.TuberculosisDtoList[${status.index }].tubercNum" size="3" value="${report.tubercNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
              <td>
                <input type="text" id="tubercManageNum_id" name="TuberculosisDto.TuberculosisDtoList[${status.index }].tubercManageNum" size="3" value="${report.tubercManageNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
           	 	<span id="tubercManagePercent"><fmt:formatNumber value="${report.tubercNum==0?0:(report.tubercManageNum/report.tubercNum)*100}" pattern="#,##0.0"/>% </span>
            </td>
            
            <td>
                <input type="text" id="tubercCureNum_id" name="TuberculosisDto.TuberculosisDtoList[${status.index }].tubercCureNum" size="3" value="${report.tubercCureNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
              <td>
                <input type="text" id="tubercMedicationNum_id" name="TuberculosisDto.TuberculosisDtoList[${status.index }].tubercMedicationNum" size="3" value="${report.tubercMedicationNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
           	 	<span id="tubercMedicationPercent"><fmt:formatNumber value="${report.tubercCureNum==0?0:(report.tubercMedicationNum/report.tubercCureNum)*100}" pattern="#,##0.0"/>% </span>
            </td>
            
            <td>
                <input type="text" id="referralTb_id" name="TuberculosisDto.TuberculosisDtoList[${status.index }].referralTbNum" size="3" value="${report.referralTbNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
                <input type="hidden" id="householdNum_id" name="TuberculosisDto.TuberculosisDtoList[${status.index }].householdNum" value="${report.householdNum*0.002}"/>
            </td>
            <td>
            	<span id="referralTbPercent" ><fmt:formatNumber value="${report.householdNum==0?0:(report.referralTbNum/(report.householdNum*0.002))*100}" pattern="#,##0.0"/>%</span>
            </td>
        </tr>
    </c:forEach>
    </tbody> 
	</table>
</div>