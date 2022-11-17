<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
	<input type="hidden" id="personId" value=""/>
<div class="repeattable">
	<table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
		<colgroup>
			<col style="width:20%;"/>
			<col style="width:15%;"/>
			<col style="width:15%;"/>
			<col style="width:15%;"/>
	        <col style="width:15%;"/>
			<col style="width:15%;"/>
		</colgroup>
		<thead>
			<tr>
				<c:choose>
					<c:when test="${searchType eq '2'}">
						<th rowspan="2">所在镇</th>
						<th rowspan="2">所在居委会</th>
					</c:when>
					<c:otherwise>
						<th rowspan="2">机构名称</th>
						<th rowspan="2">医务人员</th>
					</c:otherwise>
				</c:choose>
				<th colspan="2">新增管理人数</th>
				<th colspan="2">累计管理人数</th>
			</tr>
			<tr>
				<th>高血压</th>
				<th>糖尿病</th>
				<th>高血压</th>
				<th>糖尿病</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${managerMapList}" var="followupMap">
				<tr>
					<c:choose>
						<c:when test="${searchType eq '2'}">
							<td>
								<ehr:dic code="${followupMap.patown_Ship}" dicmeta="FS990001"/>
							</td>
							<td>
								<ehr:dic code="${followupMap.pastreet}" dicmeta="FS990001"/>
							</td>
						</c:when>
						<c:otherwise>
							<td><ehr:org code="${followupMap.create_organ_code}"/></td>
							<td title="${followupMap.create_doctor_code}">
								<ehr:user userCode="${followupMap.create_doctor_code}"/>
								<c:if test="${not empty followupMap.create_doctor_code}">
									[${followupMap.create_doctor_code}]
								</c:if>
							</td>
						</c:otherwise>
					</c:choose>
					<td>${followupMap.new_hbp_num}</td>
					<td>${followupMap.new_di_num}</td>
					<td>${followupMap.hbp_num}</td>
					<td>${followupMap.di_num}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
			<ehr:pagination action="followupStatistics.pagination" colspan="6"/>
		</tr>
	</table>
</div>



