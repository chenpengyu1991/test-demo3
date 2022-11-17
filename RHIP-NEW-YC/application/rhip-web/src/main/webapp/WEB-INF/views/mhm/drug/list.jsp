<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="min-width:120px;width: 10%;"/>
	        <col style="min-width:60px;width: 10%;"/>
			<col style="min-width:120px;width: 8%;"/>
	        <col style="min-width:80px;width: 8%;"/>
			<col style="min-width:100px;width: 8%;"/>
		    <col style="min-width:120px;width: 13%;"/>
		    <col style="min-width:120px;width: 10%;"/>
		    <col style="min-width:120px;width: 10%;"/>
		    <col style="min-width:120px;width: 10%;"/>
		    <col style="min-width:120px;width: 13%;"/>
		</colgroup>
		<thead>
			<tr>
                <th>药品名称</th>
				<th>药品剂型</th>
				<th>药品单位</th>
				<th>单位剂量</th>
				<th>每盒数量</th>
				<th>药品规格</th>
                <th>药品价格</th>
                <th>单位价格</th>
				<th>维护日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="mhmDrug" items="${mhmDrugs}" varStatus="status">
				<tr>
                    <td><ehr:tip>${mhmDrug.drugName}</ehr:tip></td>
                    <td><ehr:tip>${mhmDrug.drugForm}</ehr:tip></td>
                    <td><ehr:tip>${mhmDrug.drugUnit}</ehr:tip></td>
                    <td class="righttd"><tags:numberLabel value="${mhmDrug.unitMeasure}"/></td>
                    <td class="righttd"><tags:numberLabel value="${mhmDrug.amount}"/></td>
                    <td><ehr:tip>${mhmDrug.drugSpecifications}</ehr:tip></td>
                    <td class="righttd"><tags:numberLabel value="${mhmDrug.drugPrice}"/></td>
                    <td class="righttd"><tags:numberLabel value="${mhmDrug.unitPrice}"/></td>
                    <td class="centertd"><ehr:tip><fmt:formatDate pattern="yyyy/MM/dd" value="${mhmDrug.modifyDate}"/></ehr:tip></td>
					<td>
                        <a class="person-link-btn layui-btn layui-btn-xs" id="relatedIden" href="#" onclick="drugSearch.add(${mhmDrug.id})" title="修改" style="color: #FFF;font-size: 12px;"><i class="layui-icon">&#xe642;</i>修改</a>
                        <c:if test="${mhmDrug.deleteFlag == 0}">
                        	<a href="#" onclick="drugSearch.deleteDrug(${mhmDrug.id})" class="layui-btn layui-btn-danger layui-btn-xs" style="color: #FFF;font-size: 12px;" title="删除"><i class="layui-icon">&#xe640;</i>刪除</a>&nbsp;
                        	
                        </c:if>
						
					
					</td>
				</tr>
			</c:forEach>
			<tr>
			<ehr:pagination action="drugSearch.search" colspan="10"/>
			</tr>
		</tbody>
	</table>
	
	<%-- <table>
		<tr>
			<ehr:pagination action="drugSearch.search" />
		</tr>
	</table> --%>
</div>