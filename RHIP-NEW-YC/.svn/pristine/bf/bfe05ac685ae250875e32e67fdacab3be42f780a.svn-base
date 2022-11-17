<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/WEB-INF/tld/ehr-tag.tld"%>

<div class="repeattable">
<input type="hidden" id="currentPage" value="${page.currentPage }"/>
	<table id="person_record_table">
        <colgroup>
         	<col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:10%;"/>
            <col style="width:15%;"/>
			<col style="width:55%;"/>
        </colgroup>
			<thead> 
				<tr>
					<th>姓名</th>
					<th>手机号</th>
					<th>短信类型</th>
					<th>发送时间</th>
					<th>短信内容</th>
				</tr>
			</thead>
			<!-- 遍历接种记录 -->
			<tbody class="tbody"> 
				<c:forEach items="${smsList}" var="sms" varStatus="status">
					<tr>
						<td title="${sms.name}" style="text-align:center">${sms.name}</td>
						<td title="${sms.phoneNumber}" style="text-align:center">${sms.phoneNumber}</td>
						<td title="${sms.type}" style="text-align:center">${sms.type}</td>
						<td style="text-align:center">
							<fmt:formatDate value='${sms.createTime}' pattern='yyyy-MM-dd HH:mm:ss'/>
						</td>
						<td title="${sms.content}" style="text-align:center">${sms.content}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>
			<ehr:paging/>
</div>
