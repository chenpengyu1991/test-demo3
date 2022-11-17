<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>

<input type="hidden" id="pageIndex" value="${pageIndex}">
<div class="repeattable">
	<table>
		<colgroup>
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;" />
			<col style="width: 100px;"/>
		</colgroup>
		<thead>
			<tr>
				<th>机构名称</th>
				<th>宣传标题</th>
				<th>创建人</th>
				<th>创建日期</th>
				<th>是否发布</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${healthPromorions}"  var="promorion" >
				<tr>

                    <td>${promorion.organName}</td>
					<td>${promorion.promorionTitle}</td>
					<td>${promorion.userName}</td>
					<td style="text-align: center;"><fmt:formatDate value="${promorion.createDate}"
																	pattern="yyyy-MM-dd"/></td>
					<td><ehr:dic code="${promorion.status}" dicmeta="LH00007"/></td>
					<td style="text-align: center;">
							<%--<a href="javascript:void(0);"  onclick="searchHealthPromorionById(${promorion.id})">查看</a>--%>
						<a href="#this" onclick="promorionSearch.add(${promorion.id}, '1')">查看</a>
						<a href="#this" onclick="promorionSearch.add(${promorion.id}, '3')">修改</a>
						<c:choose>
							<c:when test="${promorion.status==1}">
								<a href="#this" onclick="promorionSearch.unpublish(${promorion.id})">撤销</a>
							</c:when>
							<c:otherwise>
								<a href="#this" onclick="promorionSearch.publish(${promorion.id})">发布</a>
							</c:otherwise>
						</c:choose>
						<a href="#this" onclick="promorionSearch.deletePromorion(${promorion.id})">删除</a>

					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    <table>
        <tr>
			<ehr:pagination action="promorionSearch.search"/>
        </tr>
    </table>
</div>