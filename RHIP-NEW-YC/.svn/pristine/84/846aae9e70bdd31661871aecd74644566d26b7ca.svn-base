<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<div class="postcontent">
<i class="popno">
	预防接种卡<br/>
</i>
<fieldset class="layui-elem-field">
<legend>基本信息</legend>
	<table class="posttable">
		<colgroup>
			<col style="width:25%;"/>
	        <col style="width:25%;"/>
			<col style="width:25%;"/>
	        <col style="min-width:80px;width:25%"/>
		</colgroup>
		<tr>
		    <th>姓名：</th>
			<td style="text-align: left">${vaccinationMgmt.name}</td>
			<th>编号：</th>
			<td style="text-align: left">${vaccinationMgmt.vaccinationCode}</td>
		</tr>
		<tr>
		    <th>性别：</th>
			<td style="text-align: left"><ehr:dic code="${vaccinationMgmt.gender}" dicmeta="GBT226112003"/></td>
			<th>出生日期：</th>
			<td style="text-align: left"><fmt:formatDate pattern="yyyy/MM/dd" value="${vaccinationMgmt.birthday}"/></td>
		</tr>
		<tr>
		    <th>监护人姓名：</th>
			<td style="text-align: left">${vaccinationMgmt.guarderName}</td>
			<th>与儿童关系：</th>
			<td style="text-align: left">${vaccinationMgmt.guarderRelationCode}</td>
		</tr>
		<tr>
		    <th>联系电话：</th>
			<td style="text-align: left">${vaccinationMgmt.phone}</td>
		</tr>
		<tr>
		    <th>家庭现住址：</th>
			<td colspan="3" style="text-align: left">${vaccinationMgmt.paaddress}</td>
		</tr>
		<tr>
		    <th>户籍地址：</th>
			<td colspan="3" style="text-align: left">${vaccinationMgmt.hrprovince}${vaccinationMgmt.hrcity}
			${vaccinationMgmt.hrcounty}${vaccinationMgmt.hrtownShip}${vaccinationMgmt.hrstreet}${vaccinationMgmt.hrhouseNumber}</td>
		</tr>
		
		<tr>
		    <th>迁入时间：</th>
			<td style="text-align: left"><fmt:formatDate pattern="yyyy/MM/dd" value="${vaccinationMgmt.immigrationDate}"/></td>
			<th>迁出时间：</th>
			<td style="text-align: left"><fmt:formatDate pattern="yyyy/MM/dd" value="${vaccinationMgmt.evacuationDate}"/></td>
		</tr>
		<tr>
		    <th>迁出原因：</th>
			<td colspan="3" style="text-align: left">${vaccinationMgmt.evacuationCause}</td>
		</tr>
		<%--<tr>--%>
		    <%--<th>疫苗异常反应史：</th>--%>
			<%--<td colspan="3" style="text-align: left">&lt;%&ndash; ${vaccinationMgmt.} &ndash;%&gt;</td>--%>
		<%--</tr>--%>
		<%--<tr>--%>
		    <%--<th>接种禁忌：</th>--%>
			<%--<td colspan="3" style="text-align: left">&lt;%&ndash; ${vaccinationMgmt.} &ndash;%&gt;</td>--%>
		<%--</tr>--%>
		<tr>
		    <th>传染病史：</th>
			<td colspan="3" style="text-align: left">${vaccinationMgmt.infectiousHistory}</td>
		</tr>
		<tr>
		    <th>建卡日期：</th>
			<td style="text-align: left"><fmt:formatDate pattern="yyyy/MM/dd" value="${vaccinationMgmt.createCardDate}"/> </td>
			<th>建卡人：</th>
			<td style="text-align: left">${vaccinationMgmt.createCardName}</td>
		</tr>
	</table>
</fieldset>
</div>
<div class="repeattable" style=" padding: 0 10px 30px 10px;">
<fieldset  class="layui-elem-field">
<legend>疫苗详情</legend>
		<table class="layui-table x-admin-sm-table-list-middle">
			<colgroup>
				<col style="width:15%;"/>
		        <col style="width:10%;"/>
				<col style="width:10%;"/>
		        <col style="width:15%"/>
		        <col style="width:15%"/>
		        <col style="width:15%"/>
		        <col style="width:20%"/>
			</colgroup>
			<thead>
			<tr>
				<th>疫苗名称</th>
				<th>疫苗剂次</th>
				<th>接种日期</th>
				<th>接种部位</th>
				<th>疫苗批号</th>
				<th>接种医生</th>
				<th>备注</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="vaccinationInfo" items="${vaccinationInfos }">
				<tr>
					<td>${vaccinationInfo.vaccineName}</td>
					<td>${vaccinationInfo.immuDoses}</td>
					<td><fmt:formatDate pattern="yyyy/MM/dd" value="${vaccinationInfo.vaccinationDate}"/></td>
					<td>${vaccinationInfo.immuPosition}</td>
					<td>${vaccinationInfo.vaccineLotNumber}</td>
					<td>${vaccinationInfo.vaccinationDoctorName}</td>
					<td>${vaccinationInfo.remark}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	
</fieldset>
</div>