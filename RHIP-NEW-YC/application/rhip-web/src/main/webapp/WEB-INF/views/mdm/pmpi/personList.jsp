<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="ehr" uri="/ehr-tag" %>
<script type="text/javascript">
//	$(function() {
//		personList.atStart();
//	});
</script>
<div class="repeattable">
	<table class="layui-table x-admin-sm-table-list-middle">
		<thead>
			<tr>
				<th width="50px"></th>
				<th width="85px">个人主索引</th>
				<th width="140px">身份证号码</th>
				<th width="140px">其他证件类型</th>
				<th width="140px">其他证件号</th>
				<th width="65px">姓名</th>
				<th width="60px">性别</th>
				<th width="80px">出生日期</th>
				<th width="100px">本人电话</th>
				<th>现住址</th>
			</tr>
		</thead>
		<c:forEach var="record" items="${personList}" varStatus="status">
			<tr class="${(status.index % 2 == 0) ? 'even' : 'odd'}">
				<td style="text-align:center;">
					<input type="checkbox" value="${record.pmpiId}" class="chk_selectall" onclick="$.selectAll(this)" checkLevel="sbr"/>
					<%-- <input type="button" class="expandDown" onclick="showLinkPersons(this,'${record.pmpiId}')"/> --%>
					<span flg="expandDown" onclick="personList.showLinkPersons(this,'${record.pmpiId}')"><img src="${pageContext.request.contextPath}/images/btn/expandDown.png" /></span>
				</td>
				<td style="text-align:center;"><a href="#" onclick="personList.showSBRDetail('${record.pmpiId}')">${record.pmpiId}</a></td>
				<td style="text-align:center;">${record.idCard}</td>
				<td style="text-align:center;"><ehr:dic dicmeta="CV0201101" code="${record.otherCardType}"/></td>
				<td style="text-align:center;">${record.otherCardNo}</td>
				<td style="text-align:center;" title="${record.name}">${record.name}</td>
				<td style="text-align:center;"><ehr:dic dicmeta="GBT226112003" code="${record.gender}"/></td>
				<td style="text-align:center;"><fmt:formatDate pattern="yyyy/MM/dd" value="${record.birthday}" /></td>
				<td style="text-align:center;">${record.phoneNumber}</td>
				<td style="text-align:left;">
				    <ehr:tip>${record.paProvince}${record.paCity}${record.paCounty}<ehr:dic dicmeta="FS990001" code="${record.paTownship}"/><ehr:dic dicmeta="FS990001" code="${record.paStreet}"/>${record.paHouseNumber}</ehr:tip>
	            </td>
			</tr>
		</c:forEach>
		<tr>
			<ehr:pagination action="personSearch.search" colspan="10"/>
		</tr>
	</table>
	<%--<div style="text-align: center">--%>
		<%--<input id="mergeBtn" type="button" class="search_btn" value="合并"/>&nbsp;&nbsp;&nbsp;--%>
		<%--<input id="splitBtn" type="button" class="search_btn" value="拆分"/>--%>
	<%--</div>--%>
	<%-- <table>
		<tr>
			<ehr:pagination action="personSearch.search" />
		</tr>
	</table> --%>
</div>


