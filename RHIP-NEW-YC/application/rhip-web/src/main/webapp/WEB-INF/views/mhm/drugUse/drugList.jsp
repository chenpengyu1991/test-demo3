<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table id="useDrugListTable" class="layui-table x-admin-sm-table-list-middle">
	    <thead>
		    <tr>
		    	<th class="centerth" style="width: 100px;">发药机构</th>
		    	<th class="centerth" style="width: 100px;">药物名称</th>
		        <th class="centerth" style="width: 100px;">发药时间</th>
		        <th class="centerth" style="width: 60px;">发药数量</th>
		        <th class="centerth" style="width: 60px;">单价</th>
		        <th class="centerth" style="width: 70px;">操作</th>
		    </tr>
	    </thead>
	    <tbody>
			<c:forEach var="useDrug" items="${mhmDrugUseList}" varStatus="status">
				<tr>
					<td>
                        <c:if test="${not empty useDrug.fillOrganCenter && empty useDrug.fillOrganStation}"><ehr:tip><ehr:org code="${useDrug.fillOrganCenter}"/></ehr:tip></c:if>
                        <c:if test="${not empty useDrug.fillOrganStation}"><ehr:tip><ehr:org code="${useDrug.fillOrganStation}"/></ehr:tip></c:if>
					</td>
					<td><ehr:tip>${useDrug.drugName}</ehr:tip></td>
					<td><ehr:tip><fmt:formatDate value="${useDrug.useDt}" pattern="yyyy/MM/dd" /></ehr:tip></td>
					<td><ehr:tip>${useDrug.useCount}</ehr:tip></td>
					<td><ehr:tip>${useDrug.currentUnitOrice}</ehr:tip></td>
					<td>
						<%-- <a href="javascript:void(0)" onclick='drugUseEdit.popuDrugUse(${useDrug.id})'>修改</a> --%>	
						<a href="javascript:void(0)" onclick='drugUseEdit.popuDrugUse(${useDrug.id})' class="layui-btn layui-btn-xs" style="color: #FFF;font-size: 12px;" title="修改"><i class="layui-icon">&#xe642;</i>修改</a>
						<%-- <a href="javascript:void(0)" onclick="drugUseEdit.deleteDrugUse(${useDrug.id});" >删除</a> --%>
						<a href="javascript:void(0)" onclick="drugUseEdit.deleteDrugUse(${useDrug.id});" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon">&#xe640;</i>删除</a>
					</td>											
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="drugUseSearch.searchDrugList" colspan="6"/>
			</tr>
	    </tbody>
	</table>
	<%-- <table>
		<tr>
			<ehr:pagination action="drugUseSearch.searchDrugList" />
		</tr>
	</table> --%>
</div>