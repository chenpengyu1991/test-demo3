<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page import="com.founder.rhip.idm.common.SchDiagnosis" %>
<%@ page import="com.founder.rhip.idm.common.SchStatus" %>
<c:set var="LATER"  value="<%=SchDiagnosis.LATER.getValue()%>" />
<c:set var="CURE" value="<%=SchStatus.CURE.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:4%;"/>
	        <col style="width:7%;"/>
			<col style="width:4%;"/>
			<col style="width:4%;"/>
			<col style="width:10%;"/>
			<col style="width:8%;"/>
			<col style="width:8%;"/>
			<col style="width:12%;"/>
			<col style="width:6%;"/>
			<col style="width:5%;"/>
		</colgroup>	
		<thead>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>身份证号</th>
				<th>管理所在镇</th>
				<th>登记日期</th>
				<th>诊断</th>
				<th>个案管理方式</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
        <c:forEach var="mgnt" items="${mhmMgnts}" varStatus="status">
            <tr <c:if test="${mgnt.logoff == 1}">class="offedperson"</c:if>>
                <td class="centertd">${status.count}</td>
                <td class="centertd"><ehr:tip>${mgnt.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${mgnt.gender}" /></ehr:tip></td>
                <td class="centertd">${mgnt.age}</td>
                <td class="centertd"><ehr:tip>${mgnt.idcard}</ehr:tip></td>
                <td class="centertd">
                    <ehr:tip><ehr:dic dicmeta="FS990001" code="${mgnt.managementTown}"/></ehr:tip>
                </td>
                <td class="centertd">
                    <fmt:formatDate value="${mgnt.fillDate}" pattern="yyyy/MM/dd" />
                </td>
                <td class="centertd"><ehr:tip>${mgnt.diagnosisContent}</ehr:tip></td>
				<td class="centertd">
                    <ehr:tip><ehr:dic dicmeta="MH00006" code="${mgnt.bringIntoMode}"/></ehr:tip>
                </td>                
                <td class="centertd">
					<c:if test="${mgnt.logoff != 1}">
					<c:if test="${searchSource eq '1'}">
						<a href="javascript:void(0);" onclick="followupSearch.editFollowup(${mgnt.statusId})"  title="" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon" >&#xe642;</i>随访</a>
					</c:if>
					<c:if test="${searchSource eq '2'}">
						<a href="javascript:void(0);" onclick="followupSearch.editPhysicExam(${mgnt.statusId})"  title="" class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;"><i class="layui-icon" >&#xe642;</i>体检</a>
					</c:if>
					</c:if>
                </td>
            </tr>
        </c:forEach>
        <tr>
			<ehr:pagination action="followupSearch.searchFollowup" colspan="10"/>
		</tr>
		</tbody>
	</table>

</div>