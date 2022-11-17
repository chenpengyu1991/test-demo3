<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<link rel="stylesheet"
	  href="${pageContext.request.contextPath}/css/views/ehrbrowser/basic/basic.css" />

<div style="background-color: white; height: 515px;">
	<ul>
		<li style="text-align: center; font-size: 25px;">体弱儿专项档案</li>
	</ul>
	<br />
	<div class="table-basic">
		<table class="layui-table x-admin-sm-table-list-small">
			<colgroup>
				<col style="width: 20%;" />
				<col style="width: 30%;" />
				<col style="width: 20%;" />
				<col style="width: 30%;" />
			</colgroup>
			<tr>
				<th>体弱儿专项档案编号</th>
				<td>${frailInfantsFile.trezxdabh}</td>
				<th>健康档案编号</th>
				<td>${frailInfantsFile.jkdabh}</td>
			</tr><tr>
				<th>姓名</th>
				<td>${frailInfantsFile.xm}</td>
				<th>性别</th>
				<td>${frailInfantsFile.xb}</td>
			</tr>
			<tr>
				<th>出生日期</th>
				<td><fmt:formatDate value="${frailInfantsFile.csrq}" pattern="yyyy/MM/dd" /></td>
				<th>儿童信息编号</th>
				<td>${frailInfantsFile.etxxbh}</td>
			</tr>
			<tr>
				<th>母亲姓名</th>
				<td>${frailInfantsFile.mqxm}</td>
				<th>母亲身份证号码</th>
				<td>${frailInfantsFile.mqsfzhm}</td>
			</tr>
			<tr>
				<th>父亲姓名</th>
				<td>${frailInfantsFile.fqxm}</td>
				<th>父亲身份证号码</th>
				<td>${frailInfantsFile.fqsfzhm}</td>
			</tr>
			<tr>
				<th>儿童体弱因素</th>
				<td>
					<%--儿童体弱因素代码表--%>
					<c:choose>
						<c:when test="${frailInfantsFile.ettrysDm eq '99'}">${frailInfantsFile.ettrysqtxs}</c:when>
						<c:otherwise>${frailInfantsFile.ettrysMc}</c:otherwise>
					</c:choose>
				</td>
				<th>儿童体弱原因</th>
				<td>
					<%--儿童体弱原因代码表--%>
					<c:choose>
						<c:when test="${frailInfantsFile.ettryyDm eq '9'}">${frailInfantsFile.ettryyqtxs}</c:when>
						<c:otherwise>${frailInfantsFile.ettryyMc}</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>先天性疾病详述</th>
				<td colspan="3">${frailInfantsFile.xtxjbxs}</td>
			</tr>
			<tr>
				<th>围产期体弱因素详述</th>
				<td colspan="3">${frailInfantsFile.trqtxs}</td>
			</tr>
			<tr>
				<th>体弱其他详述</th>
				<td colspan="3">${frailInfantsFile.trqtxs}</td>
			</tr>
			<tr>
				<th>治疗结果</th>
				<%--治疗结果代码表--%>
				<td colspan="3">${frailInfantsFile.zljgMc}</td>
			</tr>


			<tr>
				<th>结案标志</th>
				<%--结案/未结案判断--%>
				<td <c:if test="${frailInfantsFile.jabzDm ne '1'}">colspan="3"</c:if>>${frailInfantsFile.jabz}</td>
				<c:if test="${frailInfantsFile.jabzDm eq '1'}">
					<th>结案日期</th>
					<td><fmt:formatDate value="${frailInfantsFile.jarq}" pattern="yyyy/MM/dd" /></td>
				</c:if>
			</tr>
			<c:if test="${frailInfantsFile.jabzDm eq '1'}">
				<tr>
					<th>结案说明</th>
					<td colspan="3">${frailInfantsFile.jasm}</td>
				</tr>
				<tr>
					<th>是否撤销结案</th>
					<%--是/否判断--%>
					<td <c:if test="${frailInfantsFile.sfcxjabsDm ne '2'}">colspan="3"</c:if>>${frailInfantsFile.sfcxjabsMc}</td>
					<c:if test="${frailInfantsFile.sfcxjabsDm eq '2'}">
						<th>撤销结案日期</th>
						<td><fmt:formatDate value="${frailInfantsFile.cxjarq}" pattern="yyyy/MM/dd" /></td>
					</c:if>
				</tr>
				<c:if test="${frailInfantsFile.sfcxjabsDm eq '2'}">
					<tr>
						<th>撤销结案说明</th>
						<td colspan="3">${frailInfantsFile.cxjasm}</td>
					</tr>
				</c:if>
			</c:if>
			<tr>
				<th>填表日期</th>
				<td><fmt:formatDate value="${frailInfantsFile.tbrq}" pattern="yyyy/MM/dd" /></td>
				<th>填表人</th>
				<td>${frailInfantsFile.tbr}</td>
			</tr>
			<tr>
				<th>是否体弱儿童</th>
				<td>${frailInfantsFile.sftretbzMc}</td>
				<th>出生孕周</th>
				<td>${frailInfantsFile.csyz}</td>
			</tr>
			<tr>
				<th>是否死亡</th>
				<%--是/否判断--%>
				<td <c:if test="${frailInfantsFile.sfswDm ne '2'}">colspan="3"</c:if>>${frailInfantsFile.sfswMc}</td>
				<c:if test="${frailInfantsFile.sfswDm eq '2'}">
					<th>死亡时间</th>
					<td><fmt:formatDate value="${frailInfantsFile.swsj}" pattern="yyyy/MM/dd" /></td>
				</c:if>
			</tr>
			<tr>
				<%--组织机构代码表--%>
				<th>建档机构</th>
				<td>${frailInfantsFile.jdjgMc}</td>
				<%--组织机构代码表--%>
				<th>管档机构</th>
				<td>${frailInfantsFile.gdjgMc}</td>
			</tr>
			<tr>
				<th>建档人</th>
				<td>${frailInfantsFile.jdrmc}</td>
				<th>建档机构人员编号</th>
				<td>${frailInfantsFile.jdrdm}</td>
			</tr>
			<tr>
				<th>建档人联系电话</th>
				<td>${frailInfantsFile.jdrxldhhm}</td>
				<th>建档日期</th>
				<td><fmt:formatDate value="${frailInfantsFile.jdrq}" pattern="yyyy/MM/dd"/></td>
			</tr>
			<tr>
				<th>备注</th>
				<td colspan="3">${frailInfantsFile.bz}</td>
			</tr>
		</table>
	</div>
</div>