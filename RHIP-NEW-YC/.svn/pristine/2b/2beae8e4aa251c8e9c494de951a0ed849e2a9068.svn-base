<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
    <table id="link_record_table">
        <colgroup>
        	<col style="width: 5%"/>
            <col style="width: 30%"/>
            <col style="width: 30%"/>
            <col style="width: 10%"/>
            <col style="width: 25%"/>
        </colgroup>
        <thead>
			<tr>
				<th>序号</th>
				<th>机构名称</th>
				<th>链接网址</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${organizationlink}" var="link">
					<tr>
						<td title="${link.orderNum}">${link.orderNum}</td>
						<td title="${link.orgName}">${link.orgName}</td>
						<td title="${link.url}">${link.url}</td>
						<td title="${link.status}" style="text-align: center;">
							<ehr:tip><ehr:dic dicmeta="LH00008" code="${link.status}"/></ehr:tip>	
						</td>
						<td style="text-align: center;">
							<a href="#this" id="viewLink${link.id}" data-linkId="${link.id}">查看</a>
								<c:choose>
									<c:when test="${link.status==1}">
										<ehr:authorize ifAnyGranted="01,39">
											<a href="#this" id="unpublishLink${link.id}" data-linkId="${link.id}">撤销</a>
											<a href="#this" id="deleteLink${link.id}" data-linkId="${link.id}">删除</a>
										</ehr:authorize>
									</c:when>
									<c:otherwise>
									    <a href="#this" id="modifyLink${link.id}" data-linkId="${link.id}">修改</a>
										<ehr:authorize ifAnyGranted="01,39">
											<a href="#this" id="publishLink${link.id}" data-linkId="${link.id}">审核通过</a>
											<a href="#this" id="deleteLink${link.id}" data-linkId="${link.id}">删除</a>
										</ehr:authorize>
									</c:otherwise>
								</c:choose>
						</td>
					</tr>
				</c:forEach>
		</tbody> 
	</table>
	<ehr:paging />
</div>

