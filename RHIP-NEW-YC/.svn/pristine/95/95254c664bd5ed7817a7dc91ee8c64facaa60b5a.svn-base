<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.mhm.common.MhmMoveStatus" %>
<c:set var="OUT" value="<%=MhmMoveStatus.OUT.getValue()%>" />
<c:set var="BACK" value="<%=MhmMoveStatus.BACK.getValue()%>" />
<div class="repeattable">
	<table id="moveListId" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:40px;width:6%;"/>
            <col style="min-width:60px;width:12%;"/>
            <col style="min-width:40px;width:4%;"/>
			<col style="min-width:80px;width:13%;"/>
			<col style="min-width:40px;width:6%;"/>
			<col style="min-width:40px;width:6%;"/>
			<col style="min-width:40px;width:8%;"/>
			<col style="min-width:60px;width:11%;"/>
			<col style="min-width:40px;width:8%;"/>
            <col style="min-width:60px;width:11%;"/>
            <col style="min-width:100px;width:7%;"/>
            <col style="min-width:100px;width:8%;"/>
        </colgroup>
		<thead>
			<tr>
				<th>姓名</th>
                <th>身份证号</th>
                <th>性别</th>
				<th>家庭地址</th>
				<th>法定监护人</th>
                <th>监护人电话</th>
                <th>迁出时间</th>
				<th>迁出单位</th>
                <th>迁入时间</th>
                <th>迁入单位</th>
                <th>状态</th>
                <th>操作</th>
			</tr>
		</thead>
        <tbody>
        <c:forEach var="mgnt" items="${mhmMoves}" varStatus="status">
            <tr <c:if test="${mgnt.logoff == 1}">class="offedperson"</c:if> onclick="patientMoveSearch.rowClick(${mgnt.logoff})">
                <td class="hide">${mgnt.id}-${mgnt.eventId}:${mgnt.flag}</td>
                <td class="centertd"><ehr:tip>${mgnt.name}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${mgnt.idcard}</ehr:tip></td>
                <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${mgnt.gender}" /></ehr:tip></td>
                <td><ehr:tip>${mgnt.paAddress}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${mgnt.parentsName}</ehr:tip></td>
                <td class="centertd"><ehr:tip>${mgnt.guarderPhone}</ehr:tip></td>
                <td class="centertd">
                    <fmt:formatDate value="${mgnt.moveOutDt}" pattern="yyyy/MM/dd"/>
                </td>
                <td>
                    <ehr:org code="${mgnt.moveOutOrgan}"/>
                </td>
                <td class="centertd">
                    <fmt:formatDate value="${mgnt.moveInDt}" pattern="yyyy/MM/dd"/>
                </td>
                <td>
                    <ehr:org code="${mgnt.moveInOrgan}"/>
                </td>
                <td class="centertd"><ehr:dic code="${mgnt.flag}" dicmeta="MH00046"/></td>
                <td class="centertd">
                    <c:if test="${mgnt.flag==OUT && mgnt.moveInOrgan==currentLoginInfo.organization.organCode}">     <%--迁入后的操作--%>
                    <%-- <a href="javascript:void(0)" onclick="patientMoveSearch.popSransfer(2, '${mgnt.id}-${mgnt.eventId}:${mgnt.flag}')" class="person-link-btn">纳入</a> --%>
                    <a href="javascript:void(0)" onclick="patientMoveSearch.popSransfer(2, '${mgnt.id}-${mgnt.eventId}:${mgnt.flag}')" class="person-link-btn" title="纳入"><i class="layui-icon">&#xe608;</i></a>
                    </c:if>
                    <c:if test="${mgnt.flag==BACK && mgnt.moveOutOrgan==currentLoginInfo.organization.organCode && mgnt.logoff != 1}">     <%--退回后的操作--%>
                        <%-- <a href="javascript:void(0)" onclick="patientMoveSearch.popSransfer(1, '${mgnt.id}-${mgnt.eventId}:${mgnt.flag}')" class="person-link-btn">迁出</a> --%>
                        <a href="javascript:void(0)" onclick="patientMoveSearch.popSransfer(1, '${mgnt.id}-${mgnt.eventId}:${mgnt.flag}')" class="person-link-btn" title="迁出"><i class="layui-icon">&#xe65c;</i></a>
                        <%-- <a href="javascript:void(0)" onclick="patientMoveSearch.popSransfer(4, '${mgnt.id}-${mgnt.eventId}:${mgnt.flag}')" class="person-link-btn">取消</a> --%>
                        <a href="javascript:void(0)" onclick="patientMoveSearch.popSransfer(4, '${mgnt.id}-${mgnt.eventId}:${mgnt.flag}')" class="person-link-btn" title="取消"><i class="layui-icon">&#x1006;</i></a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="patientMoveSearch.searchPatientMove" />
		</tr>
	</table>
</div>