<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ page import="com.founder.rhip.idm.common.MalariaStatus" %>
<c:set var="VERIFY" value="<%=MalariaStatus.VERIFY.getValue()%>" />
<c:set var="WRITE" value="<%=MalariaStatus.WRITE.getValue()%>" />
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
	        <col style="min-width:70px;width:100px;"/>
			<col style="min-width:60px;width:80px;"/>
	        <col style="min-width:50px;width:80px;"/>
			<col style="min-width:120px;width:180px;"/>
			<col style="min-width:80px;width:80px;"/>
			<col style="min-width:150px;width:80px;"/>
			<col/>
            <%--ehr:authorize ifNotGranted="14">--%>
                <col style="width:100px;"/>
            <%--</ehr:authorize>--%>
		</colgroup>	
		<thead>
			<tr>
				<th>姓名</th>
				<th>性别</th>
				<th>年龄</th>
				<th>现住址</th>
				<th>血检结果</th>
				<th>登记日期</th>
				<th>备注</th>
				<th>操作</th>
                <%--<ehr:authorize ifNotGranted="14">
				    <th>操作</th>
                </ehr:authorize>--%>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="regList" items="${regList}" varStatus="status">
				<tr>

					<td class="centertd" title="${regList.filDto.name}">${regList.filDto.name}</td>
					<td class="centertd" title="<ehr:dic dicmeta="GBT226112003" code="${regList.filDto.gender}" />"><ehr:dic dicmeta="GBT226112003" code="${regList.filDto.gender}" /></td>
					<td title="${regList.filDto.age}">${regList.filDto.age}</td>
					<td>
                        <ehr:tip>${regList.filDto.paAddress}</ehr:tip>
                    </td>
                    <td class="centertd"><ehr:tip><ehr:dic dicmeta="FS10043" code="${regList.filDto.testResult}" /></ehr:tip></td>
                    <td class="centertd"><ehr:tip><fmt:formatDate value="${regList.filDto.fillDate}" pattern="yyyy/MM/dd"/></ehr:tip></td>
                    <td><ehr:tip>${regList.filDto.comments}</ehr:tip></td>
                    <%--<ehr:authorize ifNotGranted="14">
                    <td style="text-align: center">
                            <a href="javascript:void(0)" onclick="filIndex.initEditReg(${regList.filDto.singleId})"class="person-link-btn">修改</a>
                    </td>
                    </ehr:authorize>--%>
					<td class="centertd">
					<c:if test="${regList.currentUnit eq currentLoginInfo.organization.organCode}">
						<a title="修改" class="person-link-btn layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" href="javascript:void(0)" onclick="filRegSearch.initEditReg(${regList.filDto.singleId})"><i class="layui-icon"></i>修改</a>
					</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<table>
		<tr>
			<ehr:pagination action="filIndex.searchRegister" />
		</tr>
	</table>
</div>