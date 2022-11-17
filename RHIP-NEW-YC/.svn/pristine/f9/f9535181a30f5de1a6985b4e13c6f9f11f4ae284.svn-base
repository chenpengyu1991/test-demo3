<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 20%"/>
			<col style="width: 20%"/>
			<col style="width: 10%"/>
			<col style="width: 5%"/>
			<col style="width: 5%"/>
			<col style="width: 15%"/>
		</colgroup>
		<thead>
		<tr>
			<th>姓名</th>
			<th>性别</th>
			<th>年龄(岁)</th>
			<th>转诊类型</th>
			<th>转出单位</th>
			<th>转入单位</th>
			<th>转诊时间</th>
			<th>转诊来源</th>
			<th>转诊状态</th>
			<th>操作</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="referral" items="${referralList}">
			<tr>
				<td>${referral.name}</td>
				<td><ehr:dic dicmeta="GBT226112003" code="${referral.gender}"/></td>
				<td>${referral.age}</td>
				<td><ehr:dic dicmeta="FS10286" code="${referral.dualReferralType}"/></td>
				<td>${referral.destDeptName}</td>
				<td>${referral.referralHospitalName}</td>
				<td><fmt:formatDate value="${referral.referralDate}" pattern="yyyy-MM-dd"/></td>
				<td>${referral.referralSource eq '1'?'手机App':(referral.referralSource eq '2'?'平台':'')}</td>
				<td>${referral.referralStatus eq '0'?'未接收':(referral.referralStatus eq '1'?'已接收':(referral.referralStatus eq '2'?'拒绝接收':''))}</td>
				<td>
					<a href="javascript:void(0)" onclick="dualReferralSearch.detail(${referral.id})">查看</a>
					<a href="javascript:void(0)" onclick="dualReferralSearch.edit(${referral.id})">修改</a>
					<a href="javascript:void(0)" onclick="dualReferralSearch.del(${referral.id})">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="dualReferralSearch.search"/>
		</tr>
	</table>
</div>
<div><input type="hidden" id="indexPage" value="${indexPage}"/></div>