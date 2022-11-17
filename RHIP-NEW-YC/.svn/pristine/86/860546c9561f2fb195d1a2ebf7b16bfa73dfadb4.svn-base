<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<div class="repeattable">
    <table id="person_record_table" class="layui-table x-admin-sm-table-list-middle">
        <colgroup>
            <col style="width: 35%"/>
            <col style="width: 35%"/>
            <col style="width: 15%"/>
            <col style="width: 15%"/>
        </colgroup>
        <thead>
			<tr>
				<th>姓名</th>
				<th>身份证</th>
				<th>性别</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
			<c:forEach items="${staffList}" var="staff">
					<tr>
						<td title="${staff.name}">${staff.name}</td>
						<td title="${staff.idCard}">${staff.idCard}</td>
						<td style="text-align: center;"><ehr:dic dicmeta="GBT226112003" code="${staff.gender}"/></td>
						<td style="text-align: center;">
							<a href="javascript:void(0)" id="selectedStaff${staff.idCard}" data-card="${staff.idCard}" data-name="${staff.name}" data-gender="${staff.gender}" data-staffCode="${staff.staffCode}" data-mobilecard="${staff.mobile}">选择</a>
						</td>
					</tr>
				</c:forEach>
				<tr>
				<ehr:pagination action="staffUser.searchStaff" colspan="5" />
			</tr>
		</tbody> 
	</table>
	<%-- <ehr:paging/> --%>
</div>
