<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<%-- <script src="${pageContext.request.contextPath}/js/views/idm/tb/transfertreat.js" type="text/javascript"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery/jquery.jqprint.js"></script> --%>

<%-- <div class="toolbar">
	<a href="javascript:tbCommon.returnSearch('transfertreat.searchTemp')" id="cancelContact"><b class="fanhui">返回</b></a>
    <a href="javascript:void(0)" onclick="javascript:transfertreat.print()"><b class="dayin">打印</b></a>
    <input type="hidden" id="pageIndex" value="${pageIndex}">
</div> --%>
<form id="tbForm">
	<div class="postcontent" id="printPage">
		<i class="popno">第一联：转 诊 单 （病人持本单去结核病定点医院 永城市人民医院结防科）</i>
		<div class="postdiv">
			<table class="posttable">
				<colgroup>
					<col style="width: 20%" />
					<col style="width: 30%" />
					<col style="width: 20%" />
					<col style="width: 30%" />
				</colgroup>
				<tbody>
					<tr>
						<th>姓名：</th>
						<td>${tbSaveDto.generalCondition.name}</td>
						<th>性别:</th>
						<td>
							<ehr:dic code="${tbSaveDto.generalCondition.gender}" dicmeta="GBT226112003"/>
			            </td>
					</tr>
					<tr>
						<th>年龄：</th>
						<td>
							${tbSaveDto.generalCondition.age}<ehr:dic code="${tbSaveDto.generalCondition.ageUnit}" dicmeta="IDM00003"/>
						</td>
						<th>联系电话:</th>
						<td>${tbSaveDto.generalCondition.phoneNumber}</td>
					</tr>
					<tr>
						<th>身份证号：</th>
						<td>${tbSaveDto.generalCondition.idcard}</td>
					<tr>
		                <th>常住类型：</th>
		                <td><ehr:dic code="${tbSaveDto.generalCondition.floatPopulation}" dicmeta="FS10005"/></td>
		            </tr>
					<tr>
						<th>现住址：</th>
						<td colspan="3">
							<ehr:dic code="${tbSaveDto.generalCondition.patownShip}" dicmeta="FS990001"/>
							<ehr:dic code="${tbSaveDto.generalCondition.pastreet}" dicmeta="FS990001"/>${tbSaveDto.generalCondition.pahouseNumber}
							<c:if test="${tbSaveDto.generalCondition.pahouseNumber != ''}">
							(门牌号)
							</c:if>
			            </td>
					</tr>
					<tr>
						<th>户籍住址：</th>
						<td colspan="3">
							<ehr:dic code="${tbSaveDto.generalCondition.hrtownShip}" dicmeta="FS990001"/>
							<ehr:dic code="${tbSaveDto.generalCondition.hrstreet}" dicmeta="FS990001"/>${tbSaveDto.generalCondition.hrhouseNumber}
							<c:if test="${tbSaveDto.generalCondition.hrhouseNumber !=  ''}">
							(门牌号)
							</c:if>
			             </td>
					</tr>
					<tr>
						<th>转诊原因：</th>
						<td colspan="3">
							<ehr:dic code="${tbSaveDto.diagnosis.diagnosisReason}" dicmeta="IDM00218"/>
							<ehr:dic code="${tbSaveDto.diagnosis.transferTreatmentAccording}" dicmeta="PH00004"/>
						</td>
					</tr>
					<tr>
						<th>转诊单位：</th>
						<td><ehr:org code="${tbSaveDto.caseInformation.transferTreatmentUnit}"/></td>
						<th>转诊医师：</th>
						<td><ehr:user userCode="${tbSaveDto.caseInformation.transferTreatmentDoctor}"/></td>
					</tr>
					<tr>
						<th>转诊时间：</th>
						<td>
							<fmt:formatDate value="${tbSaveDto.caseInformation.transferTreatmentDt}" pattern="yyyy/MM/dd"/>
						</td>
					</tr>
				</tbody>
			</table>
		</div>

        <br/>
        <table class="posttable">
            <colgroup>
                <col style="width: 80px;">
                <col style="width: 95%;">

            </colgroup>
            <tr>
                <td>
                    <i>病人须知</i>
                </td>
                <td></td>
            </tr>
            <tr>
                <td></td>
				<td>
					1.病人持转诊单两天内到结核病定点医院（永城市结核病防治所）<br/>
					2.就诊前将24小时痰（须从肺部咳出的痰）留置于玻璃瓶内<br/>
					3.就诊时请将痰及X线胸片一并带至结核病定点医院（永城市结核病防治所）<br/>
					4.结核病定点医院（永城市结核病防治所）确诊为传染性肺结核的患者可享受国家规定的免费治疗和免费检查项目<br/>
					<b>结核病定点医院（永城市结核病防治所）地址： 庆丰街与Z003交叉口西50米  电话：0370-3697733(总机)</b>
				</td>
            </tr>
        </table>
	</div>
</form>