<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="repeattable">
    <table id="person_record_table">
        <colgroup>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 20%"/>
            <col style="width: 15%"/>
            <col style="width: 10%"/>
            <col style="width: 10%"/>
            <col style="width: 15%"/>
			<col style="width: 10%"/>
        </colgroup>
        <thead>
			<tr>
				<th>用户名称</th>
				<th>用户性别</th>
				<th>身份证号</th>
				<th>用户编码</th>
				<th>用户身高</th>
				<th>用户体重</th>
				<th>入库时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody class="tbody">
		<c:forEach items="${userList}" var="user" varStatus="status">
			<tr>
				<td class="centertd">
					<ehr:tip>${user.userName}</ehr:tip>
				</td>
				<td class="centertd">
					<ehr:tip>${user.sex}</ehr:tip>
				</td>
				<td class="centertd">
					<ehr:tip>${user.idCardNo}</ehr:tip>
				</td>
				<td class="centertd">
					<ehr:tip>${user.userId}</ehr:tip>
				</td>
				<td class="centertd">
					<ehr:tip>${user.height}</ehr:tip>
				</td>
				<td class="centertd">
					<ehr:tip>${user.weight}</ehr:tip>
				</td>
				<td class="centertd">
					<ehr:tip>${fn:substring(user.create_at,0,10)}</ehr:tip>
				</td>
				<td class="centertd">
					<a href="javascript:void(0)" data-user-id="${user.userId}" id="detail${user.userId}" ><span class="label label-success">详情</span></a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<ehr:paging />
</div>

