<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/ehr-tag.tld" prefix="ehr"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<script type="text/javascript">
    function searchSr(pageIndex) {
        var searchObj = {
            url : "/sr/list",
            insertDiv : "srDiv",
            param : {
                pageIndex : pageIndex,
                idCard : $("#idCardForSr").val(),
                organCode : $("#organCodeForSr").val(),
                type : "onlyView"
            }
        };
        $("#searchCondition").submitFormLoadHtml(searchObj);
    }
</script>
<div class="repeattable">
	<table>
		<colgroup>
			<col/>
			<col/>
			<col/>
			<col/>
            <c:if test="${type != 'onlyView'}"><col style="width: 150px"/></c:if>
		</colgroup>
		<thead>
		<tr>
			<th style="text-align: center">序号</th>
			<th style="text-align: center">年份</th>
			<th style="text-align: center">类型</th>
			<th style="text-align: center">名称</th>
            <c:if test="${type != 'onlyView'}"><th style="text-align: center">操作</th></c:if>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="sr" items="${srList}">
			<tr>
				<td style="text-align: center">${sr.serialNumber}</td>
				<td style="text-align: center">${sr.year}</td>
				<td style="text-align: center">
				    <c:if test="${sr.srType == 1}">科技项目</c:if>
				    <c:if test="${sr.srType == 2}">科研成果</c:if>
				    <c:if test="${sr.srType == 3}">论文期刊</c:if>
				    <c:if test="${sr.srType == 4}">论著</c:if>
				    <c:if test="${sr.srType == 5}">专利发明</c:if>

                </td>
                <td style="text-align: center">
                    <c:if test="${sr.srType == 1}">${sr.projectName}</c:if>
                    <c:if test="${sr.srType == 2}">${sr.projectName}</c:if>
                    <c:if test="${sr.srType == 3}">${sr.periodicalName}</c:if>
                    <c:if test="${sr.srType == 4}">${sr.title}</c:if>
                    <c:if test="${sr.srType == 5}">${sr.patentName}</c:if>

                </td>
                <c:if test="${type != 'onlyView'}">
                    <td style="text-align: center">
                        <a href="javascript:void(0)" onclick="srSearch.view(${sr.id})">查看</a>
                        <a href="javascript:void(0)" onclick="srSearch.edit(${sr.id})">修改</a>
                        <a href="javascript:void(0)" onclick="srSearch.del(${sr.id})">删除</a>
                    </td>
                </c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<table>
		<tr>
            <c:if test="${type != 'onlyView'}"><ehr:pagination action="srSearch.search"/></c:if>
            <c:if test="${type == 'onlyView'}"><ehr:pagination action="searchSr"/></c:if>
		</tr>
	</table>
</div>
