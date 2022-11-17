<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/ehr-tag" prefix="ehr"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div  class="repeattable">
		<table class="layui-table x-admin-sm-table-list-small">
			<thead>
				<tr>
					<th>日期</th>
					<th>项目</th>
					<th>结论</th>
					<th>机构</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${studyEvents}" var="studyEvent">
					<tr>
						<td><fmt:formatDate value="${studyEvent.checkDate}" pattern="yyyy/MM/dd" /></td>
						<td><a onclick="javascript:return false;" title="检查报告单" class="serviceIndex_openDatail_btn study_report_btn" href="<c:url value="/study/report/${studyEvent.id}" />"><tags:textWithTip linkStyle="true" value="${studyEvent.inspectionItemName eq null||studyEvent.inspectionItemName eq '' ? '...' : studyEvent.inspectionItemName}"></tags:textWithTip></a></td>
						<td><tags:textWithTip value="${studyEvent.conclusionDesc}"></tags:textWithTip></td>
						<td><tags:textWithTip value="${studyEvent.hospitalName}"></tags:textWithTip></td>
					</tr>
				</c:forEach>
				<tr>
                	<ehr:pagination action="studySearch.search" colspan="4"/>
                </tr>
            </tbody>
        </table>
    </div>

