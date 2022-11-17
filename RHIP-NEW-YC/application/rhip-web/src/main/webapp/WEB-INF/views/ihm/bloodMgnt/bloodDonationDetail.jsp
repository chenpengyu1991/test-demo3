<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
		<table class="posttable">
			<colgroup>
				<col style="min-width: 150px; width: 20%;" />
				<col />
				<col style="min-width: 150px; width: 20%;" />
				<col />
			</colgroup>
			<tr>
				<th>献血序列号：</th>
				<td style="text-align: left">${result.bloodNo}</td>
				<th>献血者识别码：</th>
				<td style="text-align: left">${result.bloodDonorNo}</td>
			</tr>
			<tr>
				<th>姓名：</th>
				<td style="text-align: left">${result.name}</td>
				<th>血液品种名称：</th>
				<td style="text-align: left">${result.bloodCategory}</td>
			</tr>
			<tr>
				<th>身份证件号码：</th>
				<td style="text-align: left">${result.idcard}</td>
				<th>其他证件类型：</th>
				<td style="text-align: left">${result.otherIdcardType}</td>
			</tr>
			<tr>
				<th>其他证件号码：</th>
				<td style="text-align: left">${result.otherIdcard}</td>
				<th>性别：</th>
				<td style="text-align: left">${result.gender}</td>
			</tr>
			<tr>
			    <th>出生日期：</th>
				<td style="text-align: left"><fmt:formatDate value="${result.birthday}" pattern="yyyy/MM/dd"></fmt:formatDate></td>	
				<th>国籍：</th>
				<td style="text-align: left">${result.nationality}</td>
			</tr>
			<tr>
				<th>民族：</th>
				<td style="text-align: left">${result.nation}</td>
				<th>年龄：</th>
				<td style="text-align: left">${result.age}</td>
			</tr>
			<tr>
				<th>职业：</th>
				<td style="text-align: left">${result.occupation}</td>
				<th>文化程度：</th>
				<td style="text-align: left">${result.education}</td>
			</tr>
			<tr>
				<th>常住类型：</th>
				<td style="text-align: left">${result.householdType}</td>
				<th>单位名称：</th>
				<td style="text-align: left">${result.unitName}</td>
			</tr>
			<tr>
				<th>ABO血型：</th>
				<td style="text-align: left">${result.aboBloodType}</td>
				<th>Rh血型：</th>
				<td style="text-align: left">
                    <c:choose>
                        <c:when test="${empty result.rhBloodType}">
                        </c:when>
                        <c:when test="${result.rhBloodType eq '**D**'}">
                            阳性
                        </c:when>
                        <c:when test="${result.rhBloodType eq '不详'}">
                            不详
                        </c:when>
                        <c:when test="${result.rhBloodType eq '未查'}">
                            未查
                        </c:when>
                        <c:otherwise>
                            阴性
                        </c:otherwise>
                    </c:choose>
                </td>
			</tr>
			<tr>
				<th>献血方式：</th>
				<td style="text-align: left">${result.bloodType}</td>
				<th>采血类型：</th>
				<td style="text-align: left">${result.bloodSampleType}</td>
			</tr>
			<tr>
				<th>采血异常：</th>
				<td style="text-align: left">${result.bloodSampleError}</td>
				<th>献血量(默认单位ml)：</th>
				<td style="text-align: left">${result.booldVolume}</td>
			</tr>
			<tr>
				<th>实际采血量：</th>
				<td style="text-align: left">${result.actualBooldVolume}</td>
				<th>检验结论：</th>
				<td style="text-align: left">${result.checkResult}</td>
			</tr>
			<tr>
				<th>采血者工作证编号：</th>
				<td style="text-align: left">${result.operatorJobNo}</td>
				<th>采血者姓名：</th>
				<td style="text-align: left">${result.operatorName}</td>
			</tr>
			<tr>
				<th>采血者身份证号：</th>
				<td style="text-align: left">${result.operatorIdcard}</td>
				<th>动员方式：</th>
				<td style="text-align: left">${result.mobilizationType}</td>
			</tr>
			<tr>
				<th>动员单位：</th>
				<td style="text-align: left">${result.mobilizationUnit}</td>
				<th>是否是爱心血库成员：</th>
				<td style="text-align: left">${result.bloodBankFlag}</td>
			</tr>
			<tr>
				<th>是否是单采自愿者：</th>
				<td style="text-align: left">${result.volunteerFlag}</td>
				<th>适宜献血日期：</th>
			    <td style="text-align: left"><fmt:formatDate value="${result.suitableDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
			</tr>
			<tr>
				<th>联系方式：</th>
				<td style="text-align: left">${result.contactTel}</td>
				<th>创建人姓名：</th>
				<td style="text-align: left">${result.createUserName}</td>
			</tr>
			<tr>
				<th>创建人身份证：</th>
				<td style="text-align: left">${result.createIdcard}</td>
				<th>创建机构代码：</th>
				<td style="text-align: left">${result.createOrganCode}</td>
			</tr>
			<tr>
				<th>创建机构名称：</th>
				<td style="text-align: left">${result.createOrganName}</td>
				<th>创建科室代码：</th>
				<td style="text-align: left">${result.createDepartmentCode}</td>
			</tr>
			<tr>
				<th>创建科室名称：</th>
				<td style="text-align: left">${result.createDepartmentName}</td>
				<th>创建时间：</th>
			 	<td style="text-align: left"><fmt:formatDate value="${result.createDate}" pattern="yyyy/MM/dd HH:mm:ss"></fmt:formatDate></td>
			</tr>
			<tr>
				<th>采血日期：</th>
				<td style="text-align: left"><fmt:formatDate value="${result.bloodDate}" pattern="yyyy/MM/dd"></fmt:formatDate></td>
				<th>献血类型及献血量：</th>
				<td style="text-align: left">${result.donBlood}</td>
			</tr>
		</table>
</div>