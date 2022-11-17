<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<script src="${pageContext.request.contextPath}/js/views/mhm/mhmCommon.js" type="text/javascript"></script>
<%--集成转诊信息页面 --%>
<div class="toolbar" style="margin-top: -8px;">
     <!-- <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)"><b class="fanhui">返回</b></a> -->
     <a href="javascript:void(0)" onclick="javascript:mhmCommon.returnSearch(managementSearch.search)" ><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
</div>
<div style="margin: 10px 20px;" class="divFixed105">
	<div id="managementResultDiv">
		<div class="repeattable">
            详细转诊信息如下：
			<table class="layui-table x-admin-sm-table-list-middle">
				<colgroup>
					<col style="min-width:20px;width:4%;"/>
			        <col style="min-width:60px;width:8%;"/>
					<col style="min-width:30px;width:5%;"/>
					<col style="min-width:30px;width:5%;"/>
					<col style="min-width:80px;width:8%;"/>
					<col style="min-width:60px;width:10%;"/>
					<col style="min-width:80px;width:15%;"/>
					<col style="min-width:80px;width:15%;"/>
				</colgroup>	
				<thead>
					<tr>
						<th>编号</th>
						<th>姓名</th>
						<th>性别</th>
						<th>年龄(岁)</th>
						<th>转诊类型</th>
						<th>转诊日期</th>
						<th>转出机构名称</th>
						<th>转入机构名称</th>
					</tr>
				</thead>
				<tbody>
		        <c:forEach var="referral" items="${referrals}" varStatus="status">
		            <tr>
		                <td class="centertd">${status.count}</td>
		                <td class="centertd"><ehr:tip>${referral.name}</ehr:tip></td>
		                <td class="centertd"><ehr:tip><ehr:dic dicmeta="GBT226112003" code="${referral.gender}" /></ehr:tip></td>
		                <td class="centertd">${referral.age}</td>
		                <td class="centertd"><ehr:dic dicmeta="FS10286" code="${referral.dualReferralType}"/></td>
		                <td class="centertd">
		                    <fmt:formatDate value="${referral.referralDate}" pattern="yyyy/MM/dd" />
		                </td>
		                <td><ehr:tip>${referral.destDeptName}</ehr:tip></td>
		                <td><ehr:tip>${referral.referralHospitalName}</ehr:tip></td>
		            </tr>
		        </c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
