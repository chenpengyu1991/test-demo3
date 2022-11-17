<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
<table id="hospitalInfo_record_table">
        <colgroup>
        	<col style="width:5%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:5%;"/>
            <col style="width:15%;">
        </colgroup>
			<thead> 
				<tr>
					<th>序号</th>
					<th>医院编号</th>
					<th>医院名称</th> 
					<th>所在地</th>
					<th>医院等级</th>
					<th>医院类别</th>	
					<th>医院电话</th>
					<th>创建时间</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<!-- 遍历机构记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${hospitalInfos}" var="record">
					<tr>
						<td title="${record.orderNum}">${record.orderNum}</td>
					    <td>
						    ${record.hospitalNo}
							<input class="selected_code" type="hidden" value='${record.hospitalNo}' />
						</td> 
						<td title="${record.hospitalName}">${record.hospitalName}</td>
						<td title="${record.belongArea}" style="text-align: center">
				    	    <c:choose>
							    <c:when test="${ empty record.belongArea}">不详</c:when>
							    <c:otherwise>${record.belongArea}</c:otherwise>
						    </c:choose>
						</td>						
						<td style="text-align:center">
							<ehr:hospital-level organGrade="${record.hospitalLevel}"></ehr:hospital-level>
						</td>
				    	<td title="${record.hospitalCategory}" style="text-align: center">
				    	    <c:choose>
							    <c:when test="${ empty record.hospitalCategory}">不详</c:when>
							    <c:otherwise>${record.hospitalCategory}</c:otherwise>
						    </c:choose>
						</td>
					    <td title="${record.hospitalPhone}" style="text-align:center">${record.hospitalPhone}</td>
					     <td style="text-align:center">
					    	<fmt:formatDate value='${record.createTime}' pattern='yyyy/MM/dd'/>
					    </td>
						<td style="text-align: center">
						       <ehr:tip><ehr:dic dicmeta="LH00008" code="${record.status}"/></ehr:tip>	
						</td>
						<td style="text-align: center;">
							<a href="#this" id="viewHospitalInfo${record.id}" data-recordId="${record.id}">查看</a>
							<c:choose>
								<c:when test="${record.status==0}">
									<a href="#this" id="modifyHospitalInfo${record.id}" data-recordId="${record.id}">修改</a>		
								</c:when>
							</c:choose>
							<ehr:authorize ifAnyGranted="01,39">
								<c:choose>
									<c:when test="${record.status == '1'}">
										<a href="#this" id="unpublishHospitalInfo${record.id}" data-recordId="${record.id}">撤销</a>
									</c:when>
									<c:otherwise>
										<a href="#this" id="publishHospitalInfo${record.id}" data-recordId="${record.id}">审核通过</a>
									</c:otherwise>
								</c:choose>
							</ehr:authorize>
							<c:choose>
								<c:when test="${record.status==0}">
									<ehr:authorize ifAnyGranted="01,39">
										<a href="#this" id="deleteHospitalInfo${record.id}" data-recordId="${record.id}">删除</a>
									</ehr:authorize>
								</c:when>
								<c:when test="${record.status==1}">
									<ehr:authorize ifAnyGranted="01,39">
										<a href="#this" id="deleteHospitalInfo${record.id}" data-recordId="${record.id}">删除</a>
									</ehr:authorize>
								</c:when>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
			<ehr:paging/>
	</div>
