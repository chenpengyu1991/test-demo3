<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/oh/radiologyDepDoc/yyfssbqk/yyfssbqk.js" type="text/javascript"></script>
<div class="toolbar">
	<a href="javascript:void(0)" onclick="javascript:editRecord.backToSearch()"><button class="btn-gray layui-btn layui-btn-sm button"><i class="layui-icon">&#xe65c;</i>返回</button></a>
	<a id="yyfssbqkAdd" href="javascript:yyfssbqk.addRecord()"><button class="layui-btn layui-btn-sm"><i class="layui-icon">&#xe608;</i>新增</button></a>
</div>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
        	<col style="width:4%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
            <col style="width:10%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:8%;"/>
            <col style="width:11%;">
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>装置编号</th>
					<th>装置型号及名称</th> 
					<th>生产厂家</th> 
					<th>出厂时间</th>
					<th>启用时间</th>
					<th>停用时间</th>
					<th>主要参数(Kv/mA)</th>
					<th>球管数</th>
					<th>操作方式</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${infoRecords}" var="record" varStatus="status"> 
					<tr>
					    <td class="centertd">  <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number></td>
						<td title="${record.equipmentCode}">${record.equipmentCode}</td>
						<td title="${record.modelName}">${record.modelName}</td>
						<td title="${record.manufacutrer}">${record.manufacutrer}</td>
						<td class="centertd" title="${record.productionDate}">
						    <c:choose>
						        <c:when test="${not empty record.productionDate}">
						            <fmt:formatDate value="${record.productionDate}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
                        <td class="centertd" title="${record.activeDate}">
						    <c:choose>
						        <c:when test="${not empty record.activeDate}">
						            <fmt:formatDate value="${record.activeDate}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>
                        <td class="centertd" title="${record.stopDate}">
						    <c:choose>
						        <c:when test="${not empty record.stopDate}">
						            <fmt:formatDate value="${record.stopDate}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
                        </td>                        
                        <td title="${record.keyPara}">${record.keyPara}</td>
                        <td class="righttd" title="${record.tubeNum}" style="text-align:center">${record.tubeNum}</td>
                        <td title="${record.operatingMode}">${record.operatingMode}</td>
						<td class="centertd">
							<a href="javascript:void(0);" class="yyfssbqkModify" onclick="yyfssbqk.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>
							<a href="javascript:void(0);" class="yyfssbqkDelete" onclick="yyfssbqk.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="editRecord.yyfssbqk" colspan="11"/>
	</table>
</div>
