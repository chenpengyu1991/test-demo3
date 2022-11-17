<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>

<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/grjlda/grjlda.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:editRecord.backToSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a id="grjldaAdd" href="javascript:grjlda.addRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
</div>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
        	<col style="width:4%;"/>
            <col style="width:6%;"/>
            <col style="width:5%;"/>
            <col style="width:12%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:12%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:11%;"/>
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>姓名</th>
					<th>性别</th> 
					<th>身份证号</th> 
					<th>出生日期</th>
					<th>职称</th>
					<th>开始放射工作时间</th>
					<th>剂量号</th>
					<th>工作证号</th>
					<th>健康档案号</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${infoRecords}" var="record" varStatus="status"> 
					<tr>
					    <td class="centertd">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>
					    </td>
						<td class="centertd" title="${record.name}"><a href="#this" onclick="grjlda.viewPersonalHealthRecord('${record.name}','${record.id}','${record.doseNo}')">${record.name}</a></td>
						<td class="centertd" title="${record.gender}"><ehr:dic dicmeta="GBT226112003" code="${record.gender}"></ehr:dic></td>
						<td class="centertd" title="${record.idCard}">${record.idCard}</td>
						<td class="centertd" title="${record.birthdate}">
						    <c:choose>
						        <c:when test="${not empty record.birthdate}">
						            <fmt:formatDate value="${record.birthdate}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
                        <td title="${record.proTitle}">${record.proTitle}</td>
                        <td class="centertd" title="${record.startDate}">
						    <c:choose>
						        <c:when test="${not empty record.startDate}">
						            <fmt:formatDate value="${record.startDate}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
                        <td title="${record.doseNo}">${record.doseNo}</td>
                        <td title="${record.jobNum}">${record.jobNum}</td>
                        <td class="centertd" title="${record.healthRecordNo}">${record.healthRecordNo}</td>
						<td class="centertd">
							<a href="javascript:void(0);" class="grjldaModify"  onclick="grjlda.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>
							<a href="javascript:void(0);" class="grjldaDelete"  onclick="grjlda.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="editRecord.grjlda" colspan="11"/>
	</table>
</div>
