<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script src="${pageContext.request.contextPath}/js/views/oh/pesticidePoison/list.js" type="text/javascript"></script>

<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
        	<col style="width:4%;"/>
            <col style="width:8%;"/>
            <col style="width:4%;"/>
            <col style="width:4%;"/>
            <col style="width:12%;"/>
            <col style="width:7%;"/>
            <col style="width:13%;">
            <col style="width:6%;">
            <col style="width:5%;"/>
            <col style="width:5%;">
            <col style="width:8%;">
            <col style="width:7%;">
            <col style="width:12%;">
        </colgroup>
			<thead> 
				<tr>
                    <th>序号</th>
					<th>姓名</th>
					<th>性别</th> 
					<th>年龄</th> 
					<th>身份证号</th>
					<th>农药种类</th>					
					<th>中毒类型</th>
					<th>报卡类别</th>
					<th>中毒程度</th>
					<th>转归</th>
					<th>报卡时间</th>
					<th>审核状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody class="tbody"> 
				<c:forEach items="${infoRecords}" var="record" varStatus="status"> 
					<tr>
					    <td style="text-align:center">
					        <ehr:serial-number index="${status.index }" currentPage="${page.currentPage }" pageSize="${page.pageSize }"></ehr:serial-number>
					    </td>
						<td class="centertd" ><ehr:tip >${record.name}</ehr:tip></td>
						<td class="centertd"><ehr:tip ><ehr:dic dicmeta="GBT226112003" code="${record.gender}"></ehr:dic></ehr:tip></td>
						<td class="centertd">
						<ehr:tip >${record.age}</ehr:tip></td>
						<td class="centertd">
						<ehr:tip >${record.idcard}</ehr:tip></td>
						<td>
						    <ehr:tip >
						    <ehr:dic dicmeta="CV0300204" code="${record.drugType}"></ehr:dic>
						    </ehr:tip>
						</td>
						<td class="centertd">
						    <ehr:tip ><ehr:dic dicmeta="CV510123" code="${record.poisonType }"></ehr:dic></ehr:tip>
						</td>
						<td class="centertd">
						    <ehr:tip ><ehr:dic dicmeta="FS10016" code="${record.cardType}"></ehr:dic></ehr:tip>
						</td>
						<td class="centertd">
						    <ehr:tip ><ehr:dic dicmeta="OH00004" code="${record.poisonLevel }"></ehr:dic></ehr:tip>
						</td>
						<td class="centertd">
						    <ehr:tip ><ehr:dic dicmeta="CV550102" code="${record.outcome }"></ehr:dic></ehr:tip>
						</td>
						<td class="centertd">
						    <c:choose>
						        <c:when test="${not empty record.reportDate}">
						            <fmt:formatDate value="${record.reportDate}" pattern="yyyy/MM/dd"/>
						        </c:when>
						        <c:otherwise>不详</c:otherwise>
						    </c:choose>
						</td>
						<td class="centertd">
						    <ehr:tip ><ehr:dic dicmeta="CV0900103" code="${record.verifyState }"></ehr:dic></ehr:tip>
						</td>
						<td class="centertd">
							<a href="javascript:void(0);"  onclick="listRecord.viewRecord('${record.id}')" title="查看" ><i class="layui-icon">&#xe615;</i></a>&nbsp;&nbsp;
							<!-- 已审核 -->
						    <c:if test="${record.verifyState=='1'}">
							    <ehr:authorize ifAnyGranted="0123">
							        <!-- 审核 -->
									<a href="javascript:void(0);"  onclick="listRecord.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
									<a href="javascript:void(0);"  onclick="listRecord.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
							    </ehr:authorize>
						    </c:if> 
						    <c:if test="${record.verifyState!='1'}">
						        <ehr:authorize ifAnyGranted="0123">
						        	<c:if test="${record.verifyState=='3'}">
										<a href="javascript:void(0);"  onclick="listRecord.check('${record.id}')" title="审核"><i class="layui-icon">&#xe672;</i></a>&nbsp;&nbsp;
									</c:if>
							    </ehr:authorize>
							    <ehr:authorize ifNotGranted="01">
								<a href="javascript:void(0);"  onclick="listRecord.updateRecord('${record.id}')" title="修改"><i class="layui-icon">&#xe642;</i></a>&nbsp;&nbsp;
								<a href="javascript:void(0);"  onclick="listRecord.deleteRecord('${record.id}')" title="删除"><i class="layui-icon">&#xe640;</i></a>
								</ehr:authorize>
						    </c:if> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
			<ehr:pagination action="listRecord.search" colspan="13"/>
	</table>
</div>
