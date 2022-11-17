<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div class="repeattable">
	<input type="hidden" id="currentPage" value="${page.currentPage }"/>
    <table id="person_record_table">
        <colgroup>
            <col style="width: 30%"/>
            <col style="width: 13%"/>
            <col style="width: 9%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 8%"/>
            <col style="width: 23%"/>
        </colgroup>
        <thead>
			<tr>
				<th>标题</th>
				<th>作者</th>
				<th>文档类型</th>
				<th>浏览次数</th>
				<th>更新时间</th>
				<th>审核状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${fileManagers}" var="file">
					<tr>
						<td title="${file.title}">${file.title}</td>
						<td title="<ehr:user-org userCode="${file.createUserCode}"/>">
							<ehr:user-org userCode="${file.createUserCode}"/>
						</td>
						<td style="text-align:center" title="<ehr:dic code="${file.fileType}" dicmeta="LH00001"/>"><ehr:dic code="${file.fileType}" dicmeta="LH00001"/> </td>
						<td style="text-align:center">${file.times}</td> 
						<td style="text-align:center"><fmt:formatDate pattern="yyyy-MM-dd" value="${file.updateDate}"/> </td>
						<td style="text-align: center;">
							<ehr:tip><ehr:dic dicmeta="LH00008" code="${file.status}"></ehr:dic></ehr:tip>
						</td>
						<td style="text-align: center;">
							<a href="#this" id="viewFile${file.id}" data-fileId="${file.id}">查看</a>
							<c:choose>
								<c:when test="${file.status == 0}">
									<a href="#this" id="modifyFile${file.id}" data-fileId="${file.id}">修改</a>
									<ehr:authorize ifAnyGranted="01,39">
										<a href="#this" id="publishFile${file.id}" data-fileId="${file.id}" data-status='${file.status}'>审核通过</a>
										<a href="#this" id="deleteFile${file.id}" data-fileId="${file.id}">删除</a>
									</ehr:authorize>
								</c:when>
								<c:otherwise>
								    <ehr:authorize ifAnyGranted="01,39">
								 	<a href="#this" id="unpublishFile${file.id}" data-fileId="${file.id}" data-status='${file.status}'>撤销</a>
									<a href="#this" id="deleteFile${file.id}" data-fileId="${file.id}">删除</a>
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

