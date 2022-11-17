<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>


<div class="repeattable">
	<table id="healthVaccinationTable">
		<colgroup>
			<col style="width: 100px;" />
			<col style="width: 50px;" />
			<col style="width: 50px;" />
			<col style="width: 70px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
			<col style="width: 45px;" />
		</colgroup>
		<thead>
			<tr>
				<th rowspan="2">单位</th>
				<th rowspan="2">应建立预防接种证数(人)</th>
				<th rowspan="2">已建立预防接种证数(人)</th>
				<th rowspan="2">处理疑似预防接种异常反应例数(例)</th>
				<th colspan="2" >乙肝疫苗</th>
				<th colspan="2" >卡介苗(人)</th>
				<th colspan="2" >脊灰疫苗</th>
				<th colspan="2" >百白破疫苗</th>
				<th colspan="2">白破疫苗(人)</th>
				<th colspan="2">麻风疫苗(人)</th>
				<th colspan="2">麻腮风疫苗(人)</th>
				<th colspan="2">A群流脑疫苗</th>
				<th colspan="2">A+C群流脑疫苗</th>
				<th colspan="2">乙脑疫苗</th>
				<th colspan="2">甲肝疫苗</th>
				<!-- <th colspan="2">设置健康教育宣传栏</th>
				<th colspan="3">提供健康教育资料</th>
				<th colspan="2">开展公众健康咨询服务</th>
				<th colspan="2">举办健康知识讲座</th>
				<th colspan="2">其他健康教育活动</th> -->
			</tr>
			<tr>
				<th>应种剂次</th>
				<th>实种剂次</th>
				<th>应种人数</th>
				<th>实种人数</th>
				<th>应种剂次</th>
				<th>实种剂次</th>
				<th>应种剂次</th>
				<th>实种剂次</th>
				<th>应种人数</th>
				<th>实种人数</th>
				<th>应种人数</th>
				<th>实种人数</th>
				<th>应种人数</th>
				<th>实种人数</th>
				<th>应种剂次</th>
				<th>实种剂次</th>
				<th>应种剂次</th>
				<th>实种剂次</th>
				<th>应种剂次</th>
				<th>实种剂次</th>
				<th>应种人数</th>
				<th>实种人数</th>
				<!-- 
				<th>设置宣传栏数</th>
				<th>宣传栏内容更新数</th>
				<th>发放印刷资料</th>
				<th>播放影像资料次数</th>
				<th>接受影像教育人数</th>
				<th>次数</th>
				<th>接受健康教育人数</th>
				<th>次数</th>
				<th>接受健康教育人数</th>
				<th>次数</th>
				<th>接受健康教育人数</th> -->
			</tr>
		</thead>
		<tbody id="displayBody">
			 <c:forEach var="report" items="${reports}" >
				<tr>
					<td>
						<c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
					</td>
					<td title="${report.certificateShouldNum}">${report.certificateShouldNum}</td>
					<td title="${report.certificateHasNum}">${report.certificateHasNum}</td>
					<td title="${report.suspectedCertificateNum}">${report.suspectedCertificateNum}</td>
					<td title="${report.hepatitisShouldNum}">${report.hepatitisShouldNum}</td>
					<td title="${report.hepatitisHasNum}">${report.hepatitisHasNum}</td>
					<td title="${report.bcgShouldNum}">${report.bcgShouldNum}</td>
					<td title="${report.bcgHasNum}">${report.bcgHasNum}</td>
					
					<td title="${report.polioShouldNum}">${report.polioShouldNum}</td>
					<td title="${report.polioHasNum}">${report.polioHasNum}</td>
					<td title="${report.dptShouldNum}">${report.dptShouldNum}</td>
					<td title="${report.dptHasNum}">${report.dptHasNum}</td>
					
					<td title="${report.whiteVaccineShouldNum}">${report.whiteVaccineShouldNum}</td>
					<td title="${report.whiteVaccineHasNum}">${report.whiteVaccineHasNum}</td>
					<td title="${report.leprosyShouldNum}">${report.leprosyShouldNum}</td>
					<td title="${report.leprosyHasNum}">${report.leprosyHasNum}</td>
					
					<td title="${report.measlesShouldNum}">${report.measlesShouldNum}</td>
					<td title="${report.measlesHasNum}">${report.measlesHasNum}</td>
					<td title="${report.ameningococcalShouldNum}">${report.ameningococcalShouldNum}</td>
					<td title="${report.ameningococcalHasNum}">${report.ameningococcalHasNum}</td>
					
					<td title="${report.acmeningococcalShouldNum}">${report.acmeningococcalShouldNum}</td>
					<td title="${report.acmeningococcalHasNum}">${report.acmeningococcalHasNum}</td>
					
					<td title="${report.encephalitisShouldNum}">${report.encephalitisShouldNum}</td>
					<td title="${report.encephalitisHasNum}">${report.encephalitisHasNum}</td>
					<td title="${report.havShouldNum}">${report.havShouldNum}</td>
					<td title="${report.havHasNum}">${report.havHasNum}</td>
				</tr>
			</c:forEach>
			<tr>
			<td><strong>合计</strong></td>
					<td title="${vaccinationServiceDto.certificateShouldNum}">${vaccinationServiceDto.certificateShouldNum}</td>
					<td title="${vaccinationServiceDto.certificateHasNum}">${vaccinationServiceDto.certificateHasNum}</td>
					<td title="${vaccinationServiceDto.suspectedCertificateNum}">${vaccinationServiceDto.suspectedCertificateNum}</td>
					<td title="${vaccinationServiceDto.hepatitisShouldNum}">${vaccinationServiceDto.hepatitisShouldNum}</td>
					<td title="${vaccinationServiceDto.hepatitisHasNum}">${vaccinationServiceDto.hepatitisHasNum}</td>
					<td title="${vaccinationServiceDto.bcgShouldNum}">${vaccinationServiceDto.bcgShouldNum}</td>
					<td title="${vaccinationServiceDto.bcgHasNum}">${vaccinationServiceDto.bcgHasNum}</td>
					
					<td title="${vaccinationServiceDto.polioShouldNum}">${vaccinationServiceDto.polioShouldNum}</td>
					<td title="${vaccinationServiceDto.polioHasNum}">${vaccinationServiceDto.polioHasNum}</td>
					<td title="${vaccinationServiceDto.dptShouldNum}">${vaccinationServiceDto.dptShouldNum}</td>
					<td title="${vaccinationServiceDto.dptHasNum}">${vaccinationServiceDto.dptHasNum}</td>
					
					<td title="${vaccinationServiceDto.whiteVaccineShouldNum}">${vaccinationServiceDto.whiteVaccineShouldNum}</td>
					<td title="${vaccinationServiceDto.whiteVaccineHasNum}">${vaccinationServiceDto.whiteVaccineHasNum}</td>
					<td title="${vaccinationServiceDto.leprosyShouldNum}">${vaccinationServiceDto.leprosyShouldNum}</td>
					<td title="${vaccinationServiceDto.leprosyHasNum}">${vaccinationServiceDto.leprosyHasNum}</td>
					
					<td title="${vaccinationServiceDto.measlesShouldNum}">${vaccinationServiceDto.measlesShouldNum}</td>
					<td title="${vaccinationServiceDto.measlesHasNum}">${vaccinationServiceDto.measlesHasNum}</td>
					<td title="${vaccinationServiceDto.ameningococcalShouldNum}">${vaccinationServiceDto.ameningococcalShouldNum}</td>
					<td title="${vaccinationServiceDto.ameningococcalHasNum}">${vaccinationServiceDto.ameningococcalHasNum}</td>
					
					<td title="${vaccinationServiceDto.acmeningococcalShouldNum}">${vaccinationServiceDto.acmeningococcalShouldNum}</td>
					<td title="${vaccinationServiceDto.acmeningococcalHasNum}">${vaccinationServiceDto.acmeningococcalHasNum}</td>
					
					<td title="${vaccinationServiceDto.encephalitisShouldNum}">${vaccinationServiceDto.encephalitisShouldNum}</td>
					<td title="${vaccinationServiceDto.encephalitisHasNum}">${vaccinationServiceDto.encephalitisHasNum}</td>
					<td title="${vaccinationServiceDto.havShouldNum}">${vaccinationServiceDto.havShouldNum}</td>
					<td title="${vaccinationServiceDto.havHasNum}">${vaccinationServiceDto.havHasNum}</td>
			
			
		</tr>
		</tbody>
		
		<tbody id="editBody" style="display: none">
    <c:forEach items="${reportList}" var="report" varStatus="status">
        <tr>
            <td title=<ehr:org code="${report.orgCode}"></ehr:org>>
                <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].id" value="${report.id }">
                <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].orgCode" value="${report.orgCode }">
                <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].year" value="${report.year }">
                <input type="hidden" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].orgName" readonly="readonly" value="${report.orgName }"/>
                <ehr:org code="${report.orgCode}"></ehr:org>
            
            
            <c:choose>
							<c:when test="${not empty all}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
							<c:when test="${empty orgCode && empty centerOrgCode && empty gbcode}">
								<ehr:tip><ehr:dic code="${report.orgCode}" dicmeta="FS990001"  /></ehr:tip>
							</c:when>
							<c:when test="${not empty orgCode || not empty centerOrgCode || not empty gbcode}">
								<ehr:tip><ehr:org code="${report.orgCode}" /></ehr:tip>
							</c:when>
						</c:choose>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].certificateShouldNum" size="3" value="${report.certificateShouldNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].certificateHasNum" size="3" value="${report.certificateHasNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].suspectedCertificateNum" size="3" value="${report.suspectedCertificateNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].hepatitisShouldNum" size="3" value="${report.hepatitisShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].hepatitisHasNum" size="3" value="${report.hepatitisHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].bcgShouldNum" size="3" value="${report.bcgShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].bcgHasNum" size="3" value="${report.bcgHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].polioShouldNum" size="3" value="${report.polioShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].polioHasNum" size="3" value="${report.polioHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].dptShouldNum" size="3" value="${report.dptShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].dptHasNum" size="3" value="${report.dptHasNum}" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].whiteVaccineShouldNum" size="3" value="${report.whiteVaccineShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].whiteVaccineHasNum" size="3" value="${report.whiteVaccineHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].leprosyShouldNum" size="3" value="${report.leprosyShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].leprosyHasNum" size="3" value="${report.leprosyHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].measlesShouldNum" size="3" value="${report.measlesShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].measlesHasNum" size="3" value="${report.measlesHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].ameningococcalShouldNum" size="3" value="${report.ameningococcalShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].ameningococcalHasNum" size="3" value="${report.ameningococcalHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].acmeningococcalShouldNum" size="3" value="${report.acmeningococcalShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].acmeningococcalHasNum" size="3" value="${report.acmeningococcalHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].encephalitisShouldNum" size="3" value="${report.encephalitisShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].encephalitisHasNum" size="3" value="${report.encephalitisHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].havShouldNum" size="3" value="${report.havShouldNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
            <td>
                <input type="text" name="VaccinationServiceDto.VaccinationServiceList[${status.index }].havHasNum" size="3" value="${report.havHasNum }" maxlength="9" onkeypress="return event.keyCode>=48&&event.keyCode<=57||event.keyCode==8;" onpaste="return !clipboardData.getData('text').match(/\D/);" style="ime-mode: Disabled" ondragenter="return false"/>
            </td>
        </tr>
    </c:forEach>
    </tbody> 
	</table>
</div>