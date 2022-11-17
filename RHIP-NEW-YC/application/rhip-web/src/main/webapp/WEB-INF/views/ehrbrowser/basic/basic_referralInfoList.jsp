<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.founder.rhip.ehr.common.RoleType" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<c:set var="ADMIN" value="<%=RoleType.ADMIN.getValue()%>"/>
<div>
	<table class="layui-table x-admin-sm-table-list-small" >
		<colgroup>
			<col style="width: 8%"/>
			<col style="width: 17%"/>
			<col style="width: 17%"/>
			<col style="width: 10%"/>
			<col style="width: 8%"/>
	<%-- 	<col style="width: 5%"/> --%>
			<col style="width: 15%"/>
		</colgroup>
		<thead>
		<tr>
			<th>转诊类型</th>
			<th>转出单位</th>
			<th>转入单位</th>
			<th>转诊时间</th>
			<th>转诊来源</th>
<!-- 			<th>转诊状态</th> -->
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="referral" items="${referralList}">
			<tr>
				<td><ehr:dic dicmeta="FS10286" code="${referral.dualReferralType}"/></td>
				<td>${referral.destDeptName}</td>
				<td>${referral.referralHospitalName}</td>
				<td><fmt:formatDate value="${referral.referralDate}" pattern="yyyy-MM-dd"/></td>
				<td>${referral.referralSource eq '1'?'手机App':(referral.referralSource eq '2'?'平台':'')}</td>
				<%-- <td>${referral.referralStatus eq '0'?'未接收':(referral.referralStatus eq '1'?'已接收':(referral.referralStatus eq '2'?'拒绝接收':''))}</td> --%>
				<td>
					<a class="view-link layui-btn layui-btn-normal layui-btn-xs" href="javascript:void(0)" title="查看" style="color: #FFF;" onclick="referralSearch.detail(${referral.id})"><i class="layui-icon" >&#xe615;</i>查看</a>&nbsp;
					<c:if test="${'personRecord' eq requestUrlType}">
					
						<a title="修改" class="edit-link layui-btn layui-btn-xs button" href="javascript:void(0)" style="color: #FFF;font-size: 12px;" onclick="referralSearch.edit(${referral.id})" ><i class="layui-icon">&#xe642;</i>修改</a>&nbsp;
					<a title="删除" class="delete-link layui-btn layui-btn-danger layui-btn-xs"  href="javascript:void(0)" style="color: #FFF;font-size: 12px;"  onclick="referralSearch.del(${referral.id})" title="删除" ><i class="layui-icon">&#xe640;</i>删除</a>
					
					</c:if>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<ehr:pagination action="referralSearch.search" colspan="6"/>
		</tr>
		</tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="referralSearch.search"/>
		</tr>
	</table> --%>
</div>
<div>
	<input type="hidden" id="indexPage" value="${indexPage}"/>
	<input type="hidden" id="requestUrlType" value="${requestUrlType}"/>
</div>