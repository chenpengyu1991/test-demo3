<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table id="subInfoType_record_table">
        <colgroup>
        	<col style="width:43%;"/>
            <col style="width:20%;"/>
            <col style="width:18%;"/>
            <col style="width:19%;">
        </colgroup>
			<thead> 
				<tr>
					<th>名称</th> 
					<th>创建者</th>
					<th>创建时间</th>
					<th>操作</th>	
				</tr>
			</thead>
			<!-- 遍历服务信息类别记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${subLists}" var="record">
					<tr>
						<td style="text-align:center">${record.name}</td>
						<td style="text-align:center">${record.creator}</td>
						<td style="text-align:center">
							<c:choose>
								<c:when test="${not empty record.creatTime}">
									<fmt:formatDate value='${record.creatTime}' pattern='yyyy/MM/dd'/>
								</c:when>
								<c:otherwise>
									不详
								</c:otherwise>
							</c:choose>
						</td>
						<td style="text-align: center">
                            <a href="#this" id="modifySubInfoType${record.id}" data-recordId="${record.id}">修改</a>
                            <a href="#this" id="deleteSubInfoType${record.id}" data-recordId="${record.id}">删除</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
			<ehr:paging/>
</div>
