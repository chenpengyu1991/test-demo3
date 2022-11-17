<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> --%>

<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table id="person_record_table">
        <colgroup>
            <col style="width:20%;"/>
            <col style="width:11%;"/>
            <col style="width:11%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:9%;"/>
            <col style="width:5%;"/>
            <col style="width:20%;">
        </colgroup>
			<thead> 
				<tr>
					<th>标  题</th>
					<th>类  别</th> 
					<th>子类别</th> 
					<th>作者</th>
					<th>来源</th>
					<th>创建时间</th>
					<th>滚动图片状态</th>	
					<th>审核状态</th>					
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${infoRecords}" var="record"> 
					<tr>
						<td title="${record.title}">${record.title}</td>
						<td title="${record.infoTypeName}" style="text-align:center">${record.infoTypeName}</td>
						<td title="${record.detailTypeName}" style="text-align:center">${record.detailTypeName}</td>
						<td title="${record.author}" style="text-align:center">${record.author}</td>
						<td title="${record.source}" style="text-align:center">${record.source}</td>
						 <td style="text-align:center">
					    	<fmt:formatDate value='${record.creatTime}' pattern='yyyy/MM/dd'/>
					    </td>
					    <td title="${record.isRollPicture}" style="text-align: center;">
							<ehr:tip><ehr:dic dicmeta="FS10186" code="${record.isRollPicture}"/></ehr:tip>	
						</td>
						<td title="${record.status}" style="text-align: center;">
							<ehr:tip><ehr:dic dicmeta="LH00008" code="${record.status}"/></ehr:tip>	
						</td>
						<td style="text-align: center;">
							<a href="#this" id="loadInfoService${record.id}" data-recordId="${record.id}">查看</a>
							<c:choose>
								<c:when test="${record.status==0}">
									<a href="#this" id="modifyInfoService${record.id}" data-recordId="${record.id}">修改</a>
										<!-- 卫计委和市级医院综合管理的医生可以审核‘信息查询’的内容 -->
									<c:choose>
										<c:when test="${record.infoTypeName eq '信息查询'}">
											<ehr:authorize ifAnyGranted="01,39">
												<a href="#this" id="publish${record.id}" data-recordId="${record.id}">审核通过</a> 			
											</ehr:authorize>
										</c:when>
										<c:otherwise>
											<ehr:authorize ifAnyGranted="01">
												<a href="#this" id="publish${record.id}" data-recordId="${record.id}">审核通过</a> 			
											</ehr:authorize>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${record.infoTypeName eq '信息查询'}">
											<ehr:authorize ifAnyGranted="01,39">
												<a href="#this" id="unpublish${record.id}" data-recordId="${record.id}">撤销</a>
		                                    </ehr:authorize>								
										</c:when>
										<c:otherwise>
											<ehr:authorize ifAnyGranted="01">
												<a href="#this" id="unpublish${record.id}" data-recordId="${record.id}">撤销</a>
		                                    </ehr:authorize>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
							<ehr:authorize ifAnyGranted="01,39">
								<a href="#this" id="deleteInfoService${record.id}" data-recordId="${record.id}">删除</a> 			
							</ehr:authorize>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
			<ehr:paging/>
		<!-- 实现分页功能 -->
</div>
